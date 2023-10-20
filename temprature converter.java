import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI {
    private JFrame frame;
    private JTextField inputField;
    private JLabel resultLabel;

    public TemperatureConverterGUI() {
        frame = new JFrame("Temperature Converter");
        inputField = new JTextField(10);
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("Converted Temperature: ");

        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Temperature: "));
        inputPanel.add(inputField);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(convertButton);

        // Set layout for the frame
        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resultLabel, BorderLayout.SOUTH);

        // Add action listener for the Convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get input temperature from the text field
                    double temperature = Double.parseDouble(inputField.getText());

                    // Convert temperature from Celsius to Fahrenheit
                    double convertedTemperature = (temperature * 9 / 5) + 32;

                    // Display the converted temperature
                    resultLabel.setText("Converted Temperature: " + convertedTemperature + " Fahrenheit");
                } catch (NumberFormatException ex) {
                    // Handle invalid input
                    resultLabel.setText("Invalid input. Please enter a number.");
                }
            }
        });

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
    }

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure thread safety of Swing components
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureConverterGUI();
            }
        });
    }
}
