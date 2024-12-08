package sequencealignment.PSA;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sequencealignment.CustomButton;
/**
 *
 * @author LEILA
 */
public class PSA {
    public PSA(){
        JFrame frame = new JFrame("Pairwise Sequence Alignment PSA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setSize(600, 400);
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
        JLabel titleLabel = new JLabel("Alignment Types");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy = 0; 
        centralPanel.add(titleLabel, gbc);

        // Description Label
        JLabel descriptionLabel = new JLabel("<html><center>"
                                            + "Pairwise Sequence Alignment (PSA) <br>"
                                            + "Local Alignment: Aligns the most similar subsequence regions <br> within two sequences(e.g., Smith-Waterman algorithm). <br>"
                                            + "Global Alignment: Aligns the entire length of two sequences <br> end-to-end (e.g., Needleman-Wunsch algorithm).<br>"
                                            + "</center></html>");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 17));
        descriptionLabel.setForeground(Color.GRAY);
        gbc.gridy = 1; 
        centralPanel.add(descriptionLabel, gbc);

        // Button panel
        CustomButton Global = new CustomButton("Global", 100, 60);
        Global.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                // new sequencealignment.PSA.PSA();
                new sequencealignment.PSA.Local.NWAInput("Fixed Values");
                System.out.println("Global");
            }
        });
        CustomButton Local = new CustomButton("Local", 100, 60);
        Local.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                // new sequencealignment.PSA.Local.SmithWatermanAgorithm();
                new sequencealignment.PSA.Local.SWAInput("Fixed Values");
                System.out.println("Local");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.add(Global);
        buttonPanel.add(Local);

        // Add panels to the frame
        frame.add(centralPanel, BorderLayout.CENTER); 
        frame.add(buttonPanel, BorderLayout.SOUTH);  
    
    }
}
