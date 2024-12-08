package sequencealignment.PSA.Local;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LEILA
 */
public class NWAFixedValues {
    public NWAFixedValues(String seq1, String seq2, String Gap, String match, String mismatch){
            
        JFrame frame = new JFrame("Needleman-Wunsch Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setSize(900, 700);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null); 
        frame.setResizable(false);
        frame.setVisible(true);
        
        JPanel centralPanel = new JPanel();
        centralPanel.setBackground(Color.WHITE);
        centralPanel.setLayout(new GridBagLayout()); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.gridx = 0; 

        // Title Label
        JLabel titleLabel = new JLabel("Needleman-Wunsch Algorithm");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy = 0; 
        centralPanel.add(titleLabel, gbc);

        // Description Label
        JLabel descriptionLabel = new JLabel("<html><center>"
                                            + "Fixed Values Scoring"
                                            + "</center></html>");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 17));
        descriptionLabel.setForeground(Color.GRAY);
        gbc.gridy = 1; 
        centralPanel.add(descriptionLabel, gbc);

        
        //**********************************************************************
        // int match, int mismatch, int gap, String seq1, String seq2
        NeedlemanWunsch SM = new NeedlemanWunsch(Integer.parseInt(match), Integer.parseInt(mismatch), Integer.parseInt(Gap), seq1, seq2);
        
        // Create column names
        String[] columnNames = new String[seq1.length() + 2]; 
        columnNames[0] = ""; 
        columnNames[1] = ""; 
        for (int i = 2; i < columnNames.length; i++) {
            columnNames[i] =  "";
        }

       
        String[][] tableData = SM.resultSWFTable();
        
        JPanel summaryPanel = new JPanel(new GridLayout(2, 4));
        summaryPanel.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100)); 
        summaryPanel.setBackground(Color.WHITE);
        
        // Display sequence 1
        JLabel seq1Label = new JLabel("Sequence 1: " + seq1);
        seq1Label.setForeground(Color.BLACK);
        seq1Label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        summaryPanel.add(seq1Label);

        // Display sequence 2
        JLabel seq2Label = new JLabel("Sequence 2: " + seq2);
        seq2Label.setForeground(Color.BLACK);
        seq2Label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        summaryPanel.add(seq2Label);
        
        // Display gap penalty
        JLabel gapLabel = new JLabel("Gap: " + Gap);
        gapLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        summaryPanel.add(gapLabel);

        // Display match and mismatch scores
        JLabel matchMismatchLabel = new JLabel("Match: " + match + ", Mismatch: " + mismatch);
        matchMismatchLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        summaryPanel.add(matchMismatchLabel);
        
        // alignment score 
        int score = SM.score();
        JLabel scoreLabel = new JLabel("Alignment Score: " + score);
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        summaryPanel.add(scoreLabel);
        
        String result = SM.result();
        
        JTextArea resultTextArea = new JTextArea(result);
        resultTextArea.setEditable(false); // Make it non-editable
        resultTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        resultTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Use monospaced font for proper alignment

        summaryPanel.add(resultTextArea);
        

        JTable table = new JTable(new DefaultTableModel(tableData, columnNames));
        table.setBackground(Color.WHITE);
        table.setOpaque(true);
        table.setFillsViewportHeight(true);

        // JScrollPane for table scrolling
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.WHITE);

        // Main panel to hold everything
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.add(summaryPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);


        // Add panels to the frame
        frame.add(centralPanel, BorderLayout.CENTER); 
        frame.add(mainPanel, BorderLayout.SOUTH); 
    
    }
}
