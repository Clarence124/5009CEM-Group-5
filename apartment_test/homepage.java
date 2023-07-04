import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ApartmentHomepage extends JFrame {
    private JLabel welcomeLabel;
    private JButton registerButton, loginButton, exitButton;

    public ApartmentHomepage() {
        setTitle("Apartment Homepage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        welcomeLabel = new JLabel("Welcome to Apartment System");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));

        registerButton = new JButton("Register");
        loginButton = new JButton("Login");
        exitButton = new JButton("Exit");

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the registration page
                dispose(); // Close the current window
                new ApartmentRegistrationPage();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the login page
                dispose(); // Close the current window
                new ApartmentLoginPage();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exit the application
                System.exit(0);
            }
        });

        add(welcomeLabel);
        add(registerButton);
        add(loginButton);
        add(exitButton);

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ApartmentHomepage();
            }
        });
    }
}
