package TokensTable.TokensTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import TokensTable.TokensTable.Lexer;
import TokensTable.TokensTable.TokenType;
import TokensTable.TokensTable.Tokens;

import java.awt.*;
import java.util.List;

public class TokenTableGUI extends JFrame {

    private JTextArea inputArea;
    private JTable table; 
    private DefaultTableModel model;

    public TokenTableGUI() {
        setTitle("Lexical Analyzer");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputArea = new JTextArea(5, 40);
        add(new JScrollPane(inputArea), BorderLayout.NORTH);

        String[] columns = {"Lexeme", "Token Type", "Position", "Line"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton analyzeBtn = new JButton("Analyze");
        add(analyzeBtn, BorderLayout.SOUTH);
        analyzeBtn.addActionListener(e -> analyzeText());
    }

    private void analyzeText() {
        String input = inputArea.getText();

        Lexer lexer = new Lexer();
        List<Tokens> tokens = lexer.analyze(input);

        loadTokens(tokens);
    }

    private void loadTokens(List<Tokens> tokens) {
        model.setRowCount(0);

        for (Tokens t : tokens) {
            model.addRow(new Object[]{
                t.getLexeme(),
                t.getType(),
                t.getPosition(),
                t.getLine()
            });
        }
    }
}