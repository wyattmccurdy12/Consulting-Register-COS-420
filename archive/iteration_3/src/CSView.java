
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

/**
 * CSView manages the GUI for the Consulting Register application.
 * It lets you search for patients, add new patients, view details, and record visits.
 */
public class CSView {
    private final CSController controller;
    private final SimpleDateFormat df  = new SimpleDateFormat("M/d/yyyy");
    private final SimpleDateFormat dtf = new SimpleDateFormat("M/d/yyyy HH:mm:ss");  // includes time
    private final JFrame frame;
    private final JTextField idField;
    private final JTextField nameField;
    private final JTextField dobField;
    private final JLabel statusLabel;
    private final JButton viewBtn;
    private final JButton recordBtn;
    private final Patient[] current = new Patient[1];
    private final Font font = new Font("SansSerif", Font.PLAIN, 14);

    /**
     * Constructs and shows the main Consulting Register window.
     * @param controller the controller handling business logic
     */
    public CSView(CSController controller) {
        this.controller = controller;

        frame = new JFrame("Consulting Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 500));
        frame.setLayout(new BorderLayout(10, 10));

        // --- Top: Search Panel ---
        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(),
            "Find or Add Patient",
            TitledBorder.LEFT, TitledBorder.TOP,
            font.deriveFont(Font.BOLD, 14)
        ));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 8, 5, 8);
        c.anchor = GridBagConstraints.WEST;

        // Patient ID
        c.gridx = 0; c.gridy = 0;
        JLabel lblId = new JLabel("Patient ID:"); lblId.setFont(font);
        searchPanel.add(lblId, c);
        idField = new JTextField();
        idField.setFont(font);
        Dimension idDim = new Dimension(120, 24);
        idField.setPreferredSize(idDim);
        idField.setMinimumSize(idDim);
        c.gridx = 1;
        searchPanel.add(idField, c);

        // Name
        c.gridx = 2;
        JLabel lblName = new JLabel("Name:"); lblName.setFont(font);
        searchPanel.add(lblName, c);
        nameField = new JTextField();
        nameField.setFont(font);
        Dimension nameDim = new Dimension(180, 24);
        nameField.setPreferredSize(nameDim);
        nameField.setMinimumSize(nameDim);
        c.gridx = 3;
        searchPanel.add(nameField, c);

        // DOB
        c.gridx = 4;
        JLabel lblDob = new JLabel("DOB (M/d/yyyy):"); lblDob.setFont(font);
        searchPanel.add(lblDob, c);
        dobField = new JTextField();
        dobField.setFont(font);
        Dimension dobDim = new Dimension(120, 24);
        dobField.setPreferredSize(dobDim);
        dobField.setMinimumSize(dobDim);
        c.gridx = 5;
        searchPanel.add(dobField, c);

        // Buttons: Search, Clear, Add Patient
        JButton searchBtn = new JButton("Search"); searchBtn.setFont(font);
        JButton clearBtn  = new JButton("Clear");  clearBtn.setFont(font);
        JButton addBtn    = new JButton("Add Patient"); addBtn.setFont(font);
        c.gridx = 6; searchPanel.add(searchBtn, c);
        c.gridx = 7; searchPanel.add(clearBtn, c);
        c.gridx = 8; searchPanel.add(addBtn, c);

        frame.add(searchPanel, BorderLayout.NORTH);

        // --- Center: Status Bar ---
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusLabel = new JLabel(" ");
        statusLabel.setFont(font);
        statusPanel.add(statusLabel);
        frame.add(statusPanel, BorderLayout.CENTER);

        // --- Bottom: Actions Panel ---
        JPanel actionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        actionsPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(),
            "Actions",
            TitledBorder.LEFT, TitledBorder.TOP,
            font.deriveFont(Font.BOLD, 14)
        ));
        viewBtn   = new JButton("View Details"); viewBtn.setFont(font);
        recordBtn = new JButton("Record Visit"); recordBtn.setFont(font);
        viewBtn.setEnabled(false);
        recordBtn.setEnabled(false);
        actionsPanel.add(viewBtn);
        actionsPanel.add(recordBtn);
        frame.add(actionsPanel, BorderLayout.SOUTH);

        // --- Event wiring ---
        searchBtn.addActionListener(e -> onSearch());
        clearBtn .addActionListener(e -> onClear());
        addBtn   .addActionListener(e -> onAddPatient());
        viewBtn  .addActionListener(e -> onViewDetails());
        recordBtn.addActionListener(e -> onRecordVisit());

        // --- Pack, lock minimum size, and display ---
        frame.pack();
        frame.setMinimumSize(frame.getSize());      // lock the packed size as minimum
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /** Search by ID or Name+DOB and update the status bar and actions. */
    private void onSearch() {
        Patient p = null;
        try {
            Date dob = dobField.getText().isBlank() ? null : df.parse(dobField.getText());
            p = controller.retrievePatient(idField.getText(), nameField.getText(), dob);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Bad DOB format", "Error", JOptionPane.ERROR_MESSAGE);
        }
        current[0] = p;
        if (p != null) {
            statusLabel.setText("✔ Found patient: " + p.getName());
            viewBtn.setEnabled(true);
            recordBtn.setEnabled(true);
        } else {
            statusLabel.setText("✖ No patient found");
            viewBtn.setEnabled(false);
            recordBtn.setEnabled(false);
        }
    }

    /** Clear all search fields and reset the UI state. */
    private void onClear() {
        idField.setText("");
        nameField.setText("");
        dobField.setText("");
        statusLabel.setText(" ");
        current[0] = null;
        viewBtn.setEnabled(false);
        recordBtn.setEnabled(false);
    }

    /** Show a dialog to add a completely new patient to the system. */
    private void onAddPatient() {
        String newPatientId = IDGenerator.getInstance().generatePatientId();
        JDialog dialog = new JDialog(this.frame, "Add New Patient", true);
        dialog.setSize(400, 400);
        dialog.setLayout(new GridLayout(0, 2, 10, 10)); // Using a simple grid layout for fields

        JLabel idLabel = new JLabel("Patient ID:");
        JTextField idField = new JTextField(newPatientId);
        idField.setEditable(false);

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel dobLabel = new JLabel("Date of Birth (M/d/yyyy):");
        JTextField dobField = new JTextField();

        JLabel sexLabel = new JLabel("Sex:");
        JTextField sexField = new JTextField();

        JLabel addressLabel = new JLabel("Address:");
        JTextField addressField = new JTextField();

        dialog.add(idLabel);
        dialog.add(idField);
        dialog.add(nameLabel);
        dialog.add(nameField);
        dialog.add(dobLabel);
        dialog.add(dobField);
        dialog.add(sexLabel);
        dialog.add(sexField);
        dialog.add(addressLabel);
        dialog.add(addressField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String dobText = dobField.getText().trim();
            String sex = sexField.getText().trim();
            String address = addressField.getText().trim();
            Date dob;
            try {
                dob = new SimpleDateFormat("M/d/yyyy").parse(dobText);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(dialog, "Invalid Date of Birth format. Use M/d/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (name.isEmpty() || sex.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "All fields except Patient ID must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            controller.addPatient(new Patient(dob, name, null, null, null, address, sex, 0, null, new ArrayList<>()) {
            });

            dialog.dispose();
        });

        dialog.add(new JLabel());
        dialog.add(saveButton);
        dialog.setVisible(true);
    }

    /** Display patient details and past visits in a table dialog. */
    private void onViewDetails() {
        if (current[0] == null) {
            JOptionPane.showMessageDialog(frame, "Search first!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Patient p = current[0];
        DefaultTableModel dm = new DefaultTableModel(new String[]{"Field","Value"}, 0);
        dm.addRow(new Object[]{"ID", p.getPatientId()});
        dm.addRow(new Object[]{"Name", p.getName()});
        dm.addRow(new Object[]{"DOB", df.format(p.getDateOfBirth())});
        dm.addRow(new Object[]{"Age", p.getAge()});
        dm.addRow(new Object[]{"Address", p.getAddress()});
        dm.addRow(new Object[]{"Sex", p.getSex()});
        dm.addRow(new Object[]{"Mother ID", p.getMotherId()});
        for (Visit v : controller.getVisitsForPatient(p.getPatientId())) {
            dm.addRow(new Object[]{
                "— Visit on",
                dtf.format(v.getDate())  // now shows real date+time
            });
            dm.addRow(new Object[]{"   Diagnosis", v.getPrincipalDiagnosis()});
            dm.addRow(new Object[]{"   Treatment", v.getTreatmentGiven()});
        }

        JTable table = new JTable(dm);
        table.setFont(font);
        table.setRowHeight(24);
        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(600, 300));
        JOptionPane.showMessageDialog(frame, sp, "Patient Details & Visits", JOptionPane.INFORMATION_MESSAGE);
    }

    /** Open a dialog to record a new visit for the currently loaded patient. */
    private void onRecordVisit() {
        if (current[0] == null) {
            JOptionPane.showMessageDialog(frame, "Search first!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JDialog dlg = new JDialog(frame, "Record Visit", true);
        dlg.setLayout(new GridLayout(0,2,5,5));
        dlg.setMinimumSize(new Dimension(400,400));

        String[] labels = {
          "Blood Pressure:", "Pulse:", "Temperature:", "Weight:", "Respiration:",
          "History:", "Diagnosis:", "Addl Diagnosis:", "Treatment:",
          "Referred? (true/false):", "Outcome Of Referral:", "Cost:", "Remarks:"
        };
        JTextField[] fields = new JTextField[labels.length];
        for (int i = 0; i < labels.length; i++) {
            JLabel lbl = new JLabel(labels[i]); lbl.setFont(font);
            dlg.add(lbl);
            fields[i] = new JTextField();
            fields[i].setFont(font);
            dlg.add(fields[i]);
        }

        JButton save = new JButton("Save"); save.setFont(font);
        dlg.add(new JLabel());
        dlg.add(save);

        save.addActionListener(ae -> {
            try {
                Visit v = new Visit(
                  current[0].getPatientId(),
                  "CLINIC1",
                  new Date(),
                  fields[0].getText(),
                  fields[1].getText(),
                  Float.parseFloat(fields[2].getText()),
                  Float.parseFloat(fields[3].getText()),
                  fields[4].getText(),
                  fields[5].getText(),
                  fields[6].getText(),
                  fields[7].getText(),
                  fields[8].getText(),
                  Boolean.parseBoolean(fields[9].getText()),
                  fields[10].getText(),
                  Float.parseFloat(fields[11].getText()),
                  fields[12].getText()
                );
                boolean ok = controller.recordVisit(v);
                JOptionPane.showMessageDialog(
                  dlg,
                  ok ? "Saved!" : "Error saving",
                  ok ? "Success" : "Error",
                  ok ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE
                );
                if (ok) dlg.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                  dlg, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE
                );
            }
        });

        dlg.pack();
        dlg.setLocationRelativeTo(frame);
        dlg.setVisible(true);
    }

    /**
     * Method to display visit details, including the patient and any child assessment information.
     *
     * @param record The medical record associated with the visit
     */
    public void displayVisitDetails(Record record) {
        System.out.println("Visit Details:");
        System.out.println("---------------------------");
        System.out.println("Record ID: " + record.getRecordId());
        System.out.println("Patient Name: " + record.getPatient().getName());
        System.out.println("Clinic: " + record.getClinic().getName());

        if (record.getChildAssessment() != null) {
            System.out.println("Child Assessment is required for this patient.");
            ChildAssessment ca = record.getChildAssessment();

            System.out.println("Child Attributes: " + ca.getChildAttributes());
            System.out.println("Fever present: " + ca.isTempForFever());
            System.out.println("Respiration for Pneumonia: " + ca.isRespirationForPneumonia());
            System.out.println("Palmar Pallor for Anemia: " + ca.isPalmarPallorForAnemia());
            System.out.println("Stridor: " + ca.isPulseRateForStridor());
            System.out.println("Malaria pulse rate: " + ca.isPulseRateForMalaria());
            System.out.println("Blood in stool for Dysentery: " + ca.isBloodInStoolForDysentery());
            System.out.println("Skin Rashes: " + ca.isSkinRashes());
            System.out.println("Signs of Convulsion: " + ca.isSignsOfConvulsionOrHistoryOfConvulsion());
            System.out.println("Lethargy: " + ca.isLethargy());
            System.out.println("---------------------------");
        } else {
            System.out.println("No Child Assessment required for this patient.");
        }
    }
}