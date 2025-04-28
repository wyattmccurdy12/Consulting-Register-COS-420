import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * CSView is responsible for creating and managing the graphical user interface (GUI)
 * for the Consulting Register application. It interacts with the CSController to
 * retrieve patient information based on user input.
 */
public class CSView {
    private CSController controller;

    /**
     * Constructs a CSView instance and initializes the GUI components.
     *
     * @param controller The controller responsible for handling business logic and data retrieval.
     */
    public CSView(CSController controller) {
        this.controller = controller;

        // Create the frame
        JFrame frame = new JFrame("Patient Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // Create components
        JLabel label = new JLabel("Enter Patient ID:");
        JTextField textField = new JTextField(20);
        JButton submitButton = new JButton("Submit");
        JLabel resultLabel = new JLabel("");

        // Add components to frame
        frame.add(label);
        frame.add(textField);
        frame.add(submitButton);
        frame.add(resultLabel);

        JButton viewRecordsButton = new JButton("View Patient Information");
        frame.add(viewRecordsButton);

        // Add action listener to the button
        submitButton.addActionListener(new ActionListener() {
            /**
             * Handles the action event triggered when the submit button is clicked.
             * Retrieves the patient ID from the text field, fetches the patient information
             * using the controller, and displays the result in the result label.
             *
             * @param e The action event triggered by the button click.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientId = textField.getText();
                String result = controller.getPatientInfo(patientId);
                resultLabel.setText(result);
            }
        });

        viewRecordsButton.addActionListener(new ActionListener() {
            /**
             * Handles the action event triggered when the "View Patient Information" button is clicked.
             * Displays detailed information for the currently retrieved patient in a JTable.
             *
             * @param e The action event triggered by the button click.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientId = textField.getText();
                Patient patient = controller.getPatientDetails(patientId);

                if (patient != null) {
                    String[] columnNames = {"Field", "Value"};
                    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

                    tableModel.addRow(new Object[]{"Patient ID", patient.getPatientId()});
                    tableModel.addRow(new Object[]{"Name", patient.getName()});
                    tableModel.addRow(new Object[]{"Date of Birth", patient.getDateOfBirth()});
                    tableModel.addRow(new Object[]{"Age", patient.getAge()});
                    tableModel.addRow(new Object[]{"Address", patient.getAddress()});
                    tableModel.addRow(new Object[]{"Sex", patient.getSex()});
                    tableModel.addRow(new Object[]{"Mother ID", patient.getMotherId()});

                    JTable table = new JTable(tableModel);
                    JScrollPane scrollPane = new JScrollPane(table);
                    JFrame tableFrame = new JFrame("Patient Information");
                    tableFrame.setSize(400, 300);
                    tableFrame.add(scrollPane);
                    tableFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(frame, "No patient found with ID: " + patientId, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
