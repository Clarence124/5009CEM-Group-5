import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

public class BillingReceipt extends JFrame {

    private JTextField nameTextField;
    private JTextField apartmentTextField;
    private JTextField periodTextField;
    private JTextArea receiptTextArea;

    @SuppressWarnings("unchecked")
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
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USERNAME = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public BillingReceipt() {
        setTitle("Billing Receipt");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        createComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Tenant Name:");
        nameTextField = new JTextField(20);

        JLabel apartmentLabel = new JLabel("Apartment Number:");
        apartmentTextField = new JTextField(10);

        JLabel periodLabel = new JLabel("Billing Period:");
        periodTextField = new JTextField(10);

        formPanel.add(nameLabel, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        formPanel.add(nameTextField, gridBagConstraints);

        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 0;
        formPanel.add(apartmentLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        formPanel.add(apartmentTextField, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 0;
        formPanel.add(periodLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        formPanel.add(periodTextField, gridBagConstraints);

        mainPanel.add(formPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        JButton generateButton = new JButton("Generate Receipt");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateReceipt();
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
                saveReceiptToFile();
            }
        });

        buttonPanel.add(generateButton);
        buttonPanel.add(makePaymentButton);
        buttonPanel.add(downloadButton);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        receiptTextArea = new JTextArea(10, 30);
        receiptTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(receiptTextArea);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
    }

    private void generateReceipt() {
        String name = nameTextField.getText();
        String apartmentNumber = apartmentTextField.getText();
        String period = periodTextField.getText();

        double randomFee = generateRandomFee();
        String amount = formatCurrency(randomFee);

        StringBuilder receiptBuilder = new StringBuilder();
        receiptBuilder.append("Apartment Management System\n");
        receiptBuilder.append("----------------------------\n");
        receiptBuilder.append("Tenant Name: ").append(name).append("\n");
        receiptBuilder.append("Apartment Number: ").append(apartmentNumber).append("\n");
        receiptBuilder.append("Billing Period: ").append(period).append("\n");
        receiptBuilder.append("Total Amount: ").append(amount).append("\n");
        receiptBuilder.append("----------------------------\n");
        receiptBuilder.append("Thank you for your payment!");

        receiptTextArea.setText(receiptBuilder.toString());
    }

    private double generateRandomFee() {
        // Generate a random maintenance fee between 50 and 200
        Random random = new Random();
        return 50 + (random.nextDouble() * (200 - 50));
    }

    private String formatCurrency(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return "$" + decimalFormat.format(amount);
    }

    private void makePayment() {
        String paymentOption = JOptionPane.showInputDialog(this, "Select Payment Option:", "Make Payment", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Credit Card", "PayPal"}, "Credit Card").toString();

        if (paymentOption.equals("Credit Card")) {
            String cardNumber = JOptionPane.showInputDialog(this, "Enter Card Number:", "Credit Card Payment", JOptionPane.PLAIN_MESSAGE);
            String cardName = JOptionPane.showInputDialog(this, "Enter Card Name:", "Credit Card Payment", JOptionPane.PLAIN_MESSAGE);
            double amount = parseAmountFromReceipt();
            processCreditCardPayment(cardNumber, cardName, amount);
        } else if (paymentOption.equals("PayPal")) {
            double amount = parseAmountFromReceipt();
            processPayPalPayment(amount);
        }
    }

    private double parseAmountFromReceipt() {
        String receiptText = receiptTextArea.getText();
        String[] lines = receiptText.split("\n");
        String lastLine = lines[lines.length - 2]; // Assuming the second last line is the "Total Amount" line
        String[] amountParts = lastLine.split(":");
        String amountString = amountParts[1].trim().replace("$", "");
        return Double.parseDouble(amountString);
    }

    private void processCreditCardPayment(String cardNumber, String cardName, double amount) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String insertPaymentQuery = "INSERT INTO payments (card_number, card_name, amount) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertPaymentQuery);
            statement.setString(1, cardNumber);
            statement.setString(2, cardName);
            statement.setDouble(3, amount);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(this, "Credit Card Payment Processed Successfully!", "Payment Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while processing the payment.", "Payment Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void processPayPalPayment(double amount) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String insertPaymentQuery = "INSERT INTO payments (amount) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(insertPaymentQuery);
            statement.setDouble(1, amount);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(this, "PayPal Payment Processed Successfully!", "Payment Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while processing the payment.", "Payment Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveReceiptToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()))) {
                writer.write(receiptTextArea.getText());
                JOptionPane.showMessageDialog(this, "Receipt saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "An error occurred while saving the receipt.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BillingReceipt());
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

