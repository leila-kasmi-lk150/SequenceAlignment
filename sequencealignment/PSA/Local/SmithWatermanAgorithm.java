package sequencealignment.PSA.Local;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sequencealignment.CustomButton;
/**
 *
 * @author LEILA
 */
public class SmithWatermanAgorithm {
    public SmithWatermanAgorithm(){
        
        JFrame frame = new JFrame("Smith-Waterman Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null); // Centers the frame
        frame.setResizable(false);
        frame.setVisible(true);

        JPanel centralPanel = new JPanel();
        centralPanel.setBackground(Color.WHITE);
        centralPanel.setLayout(new GridBagLayout()); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.gridx = 0; 

        // Title Label
        JLabel titleLabel = new JLabel("Smith-Waterman Algorithm");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy = 0; 
        centralPanel.add(titleLabel, gbc);

        // Description Label
        JLabel descriptionLabel = new JLabel("<html><center>"
            + "Local Alignment Algorithm.<br>"
                + "Scoring Systems <br>"
            + "PAM: Mutation scoring matrix for evolution.<br>"
            + "BLOSUM: Scoring matrix for conserved regions.<br>"
            + "Fixed Values: Simplified match/mismatch scoring."
            + "</center></html>");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 17));
        descriptionLabel.setForeground(Color.GRAY);
        gbc.gridy = 1; 
        centralPanel.add(descriptionLabel, gbc);
        
        
        // Button panel for PAM, BLOSUM, and FIX
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        CustomButton PAM = new CustomButton("PAM", 120, 60);
        PAM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new sequencealignment.PSA.Local.SWAInput("PAM");
                System.out.println("Global");
            }
        });
        CustomButton BLOSUM = new CustomButton("BLOSUM", 120, 60);
        BLOSUM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new sequencealignment.PSA.Local.SWAInput("BLOSUM");
                System.out.println("Global");
            }
        });
        CustomButton FIX = new CustomButton("FIX", 120, 60);
        FIX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new sequencealignment.PSA.Local.SWAInput("Fixed Values");
                System.out.println("Global");
            }
        });

        // Add buttons to the panel
        buttonPanel.add(PAM);
        buttonPanel.add(BLOSUM);
        buttonPanel.add(FIX);

        // Add central panel and button panel to the frame
        frame.add(centralPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH); // Buttons at the bottom
        
        
    }
    
}
