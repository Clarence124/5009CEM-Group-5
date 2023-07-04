import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ApartmentRegistrationPage extends JFrame {
    private JLabel nameLabel, emailLabel, phoneLabel, apartmentLabel;
    private JTextField nameField, emailField, phoneField, apartmentField;
    private JButton registerButton;

    public ApartmentRegistrationPage() {
        setTitle("Apartment Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();
        apartmentLabel = new JLabel("Apartment Number:");
        apartmentField = new JTextField();
        registerButton = new JButton("Register");

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the values entered by the user
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String apartment = apartmentField.getText();

                // Perform registration logic here
                // ...

                // Display a dialog box with a message
                JOptionPane.showMessageDialog(ApartmentRegistrationPage.this, "Registration Successful!");

                // Clear the input fields after registration
                nameField.setText("");
                emailField.setText("");
                phoneField.setText("");
                apartmentField.setText("");
            }
        });

        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(phoneLabel);
        add(phoneField);
        add(apartmentLabel);
        add(apartmentField);
        add(new JLabel()); // Empty label for spacing
        add(registerButton);

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ApartmentRegistrationPage();
            }
        });
    }
}
