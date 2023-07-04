package apartment_test;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Expense {
    private String name;
    private double amount;

    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}

public class SinkingFund extends JFrame {
    private List<Expense> sinkingFund;

    public SinkingFund() {
        initializeSinkingFund();
        createAndShowGUI();
    }

    private void initializeSinkingFund() {
        sinkingFund = new ArrayList<>();
        sinkingFund.add(new Expense("Home", -100));
        sinkingFund.add(new Expense("Shopping", -100));
        sinkingFund.add(new Expense("Travel", -100));
        sinkingFund.add(new Expense("Food&Drink", -100));
        sinkingFund.add(new Expense("Transportation", -100));
    }

    private void createAndShowGUI() {
        setTitle("Sinking Fund Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> sinkingFundList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(sinkingFundList);

        sinkingFund.forEach(expense -> {
            listModel.addElement(expense.getName() + " - " + expense.getAmount() + " MYR");
        });

        add(scrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SinkingFund::new);
    }
}
