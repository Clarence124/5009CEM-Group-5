import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;

public class SinkingFund extends JFrame {

    private JTable paymentTable;
    private DefaultTableModel tableModel;
    private Connection connection;
    
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public SinkingFund() {
        setTitle("Sinking Fund");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        createDatabaseConnection();
        createComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createDatabaseConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/apartment_management_system";
        String username = "your_username";
        String password = "your_password";

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Payment Detail");
        tableModel.addColumn("Amount");

        paymentTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(paymentTable);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton generateButton = new JButton("Generate Payments");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generatePayments();
            }
        });

        JButton makePaymentButton = new JButton("Make Payment");
        makePaymentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makePayment();
            }
        });

        JButton downloadButton = new JButton("Download");
        downloadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                savePaymentsToFile();
            }
        });

        buttonPanel.add(generateButton);
        buttonPanel.add(makePaymentButton);
        buttonPanel.add(downloadButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
    }

    private void generatePayments() {
        tableModel.setRowCount(0); // Clear the table before generating new payments

        String[] paymentDetails = {"Transportation", "Home", "Travel", "Shopping", "Food and Drinks"};

        for (String paymentDetail : paymentDetails) {
            double amount = generateRandomPaymentAmount();
            String formattedAmount = formatCurrency(amount);

            Object[] rowData = {paymentDetail, formattedAmount};
            tableModel.addRow(rowData);
        }
    }

    private double generateRandomPaymentAmount() {
        Random random = new Random();
        return random.nextInt(200) + 1; // Generate a random payment amount between 1 and 200
    }

    private String formatCurrency(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return "$" + decimalFormat.format(amount);
    }

    private void savePaymentsToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Payment Detail,Amount\n");

                int rowCount = tableModel.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    String paymentDetail = tableModel.getValueAt(i, 0).toString();
                    String amount = tableModel.getValueAt(i, 1).toString();

                    stringBuilder.append(paymentDetail).append(",").append(amount).append("\n");
                }

                writer.write(stringBuilder.toString());
                JOptionPane.showMessageDialog(this, "Payments saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "An error occurred while saving the payments.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void makePayment() {
        String[] paymentOptions = {"Credit Card", "PayPal"};
        String selectedOption = (String) JOptionPane.showInputDialog(this, "Select Payment Option:", "Make Payment",
                JOptionPane.QUESTION_MESSAGE, null, paymentOptions, paymentOptions[0]);

        if (selectedOption != null) {
            if (selectedOption.equals("Credit Card")) {
                makeCreditCardPayment();
            } else if (selectedOption.equals("PayPal")) {
                makePayPalPayment();
            }
        }
    }

    private void makeCreditCardPayment() {
        JTextField cardNumberField = new JTextField();
        JTextField nameField = new JTextField();

        Object[] message = {
                "Card Number:", cardNumberField,
                "Name:", nameField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Credit Card Payment", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String cardNumber = cardNumberField.getText();
            String name = nameField.getText();

            saveCreditCardPaymentToDatabase(cardNumber, name);
        }
    }

    private void makePayPalPayment() {
        JTextField emailField = new JTextField();

        Object[] message = {
                "Email:", emailField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "PayPal Payment", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String email = emailField.getText();

            savePayPalPaymentToDatabase(email);
        }
    }

    private void saveCreditCardPaymentToDatabase(String cardNumber, String name) {
        try {
            String query = "INSERT INTO payments (payment_detail, amount, payment_option, card_number, card_name) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            int rowCount = tableModel.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String paymentDetail = tableModel.getValueAt(i, 0).toString();
                double amount = Double.parseDouble(tableModel.getValueAt(i, 1).toString());

                statement.setString(1, paymentDetail);
                statement.setDouble(2, amount);
                statement.setString(3, "Credit Card");
                statement.setString(4, cardNumber);
                statement.setString(5, name);

                statement.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "Payments saved to the database.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "An error occurred while saving the payments to the database.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void savePayPalPaymentToDatabase(String email) {
        try {
            String query = "INSERT INTO payments (payment_detail, amount, payment_option, paypal_email) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            int rowCount = tableModel.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String paymentDetail = tableModel.getValueAt(i, 0).toString();
                double amount = Double.parseDouble(tableModel.getValueAt(i, 1).toString());

                statement.setString(1, paymentDetail);
                statement.setDouble(2, amount);
                statement.setString(3, "PayPal");
                statement.setString(4, email);

                statement.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "Payments saved to the database.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "An error occurred while saving the payments to the database.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SinkingFund());
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

