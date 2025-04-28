import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CSView {
    private CSController controller;

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

        // Add action listener to the button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientId = textField.getText();
                String result = controller.getPatientInfo(patientId);
                resultLabel.setText(result);
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
