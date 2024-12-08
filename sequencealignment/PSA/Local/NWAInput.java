package sequencealignment.PSA.Local;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sequencealignment.CustomButton;

/**
 *
 * @author LEILA
 */
public class NWAInput {
    public NWAInput(String scoring){
        
    JFrame frame = new JFrame("Needleman-Wunsch Algorithm");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.WHITE);
    frame.setSize(600, 500);
    frame.setLayout(new BorderLayout());
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);

    // Central Panel
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
        + "Pairwise Sequence Alignment<br>"
        + "Global Alignment Algorithm.<br>"
        + scoring + " Scoring"
        + "</center></html>");
    descriptionLabel.setFont(new Font("Arial", Font.BOLD, 17));
    descriptionLabel.setForeground(Color.GRAY);
    gbc.gridy = 1;
    centralPanel.add(descriptionLabel, gbc);

    // Main Panel
    JPanel mainPanel = new JPanel();
    mainPanel.setBackground(Color.WHITE);
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

    // Sequence 1 Panel
    JPanel seq1Panel = new JPanel(new BorderLayout());
    seq1Panel.setBackground(Color.WHITE);
    JLabel label1 = new JLabel("Sequence 01:");
    JTextField textField1 = new JTextField();
    seq1Panel.add(label1, BorderLayout.NORTH);
    seq1Panel.add(textField1, BorderLayout.CENTER);
    seq1Panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

    // Sequence 2 Panel
    JPanel seq2Panel = new JPanel(new BorderLayout());
    seq2Panel.setBackground(Color.WHITE);
    JLabel label2 = new JLabel("Sequence 02:");
    JTextField textField2 = new JTextField();
    seq2Panel.add(label2, BorderLayout.NORTH);
    seq2Panel.add(textField2, BorderLayout.CENTER);
    seq2Panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

    // Gap Panel
    JPanel gapPanel = new JPanel(new BorderLayout());
    gapPanel.setBackground(Color.WHITE);
    JLabel gapLabel = new JLabel("GAP:");
    JTextField textFieldGap = new JTextField();
    gapPanel.add(gapLabel, BorderLayout.NORTH);
    gapPanel.add(textFieldGap, BorderLayout.CENTER);
    gapPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

    mainPanel.add(seq1Panel);
    mainPanel.add(seq2Panel);
    mainPanel.add(gapPanel);

    JTextField matchField = new JTextField();
    JTextField mismatchField = new JTextField();
    if ("Fixed Values".equals(scoring)) {
        JPanel matchPanel = new JPanel(new BorderLayout());
        matchPanel.setBackground(Color.WHITE);
        JLabel matchLabel = new JLabel("Match Score:");
        matchPanel.add(matchLabel, BorderLayout.NORTH);
        matchPanel.add(matchField, BorderLayout.CENTER);
        matchPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        JPanel mismatchPanel = new JPanel(new BorderLayout());
        mismatchPanel.setBackground(Color.WHITE);
        JLabel mismatchLabel = new JLabel("Mismatch Score:");
        mismatchPanel.add(mismatchLabel, BorderLayout.NORTH);
        mismatchPanel.add(mismatchField, BorderLayout.CENTER);
        mismatchPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        mainPanel.add(matchPanel);
        mainPanel.add(mismatchPanel);
    }

    // Compute Button
    CustomButton computeButton = new CustomButton("Compute", 120, 60);
    computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Fixed Values".equals(scoring)){
                    frame.setVisible(false);
                    new sequencealignment.PSA.Local.NWAFixedValues(textField1.getText(),textField2.getText(),textFieldGap.getText(),matchField.getText(),mismatchField.getText());
                }
                System.out.println(textField1.getText());
                System.out.println(textField2.getText());
                System.out.println(textFieldGap.getText());
                System.out.println(matchField.getText());
                System.out.println(mismatchField.getText());
            }
        });
    computeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    mainPanel.add(computeButton);

    // Add panels to frame
    frame.add(centralPanel, BorderLayout.NORTH);
    frame.add(mainPanel, BorderLayout.CENTER);

    frame.setVisible(true);
    }
}
