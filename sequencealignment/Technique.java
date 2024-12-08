package sequencealignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author LEILA
 */
public class Technique {

    public Technique() {
        JFrame frame = new JFrame("Alignment Technique");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        // Central panel for title and description
        JPanel centralPanel = new JPanel();
        centralPanel.setBackground(Color.WHITE);
        centralPanel.setLayout(new GridBagLayout()); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.gridx = 0; 

        // Title Label
        JLabel titleLabel = new JLabel("Alignment Techniques");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy = 0; // row 0
        centralPanel.add(titleLabel, gbc);

        // Description Label
        JLabel descriptionLabel = new JLabel("<html><center>Pairwise Sequence Alignment (PSA) focuses on aligning two <br>"
                + "sequences to identify regions of similarity, while Multi-Sequence <br>"
                + "Alignment (MSA) extends this concept to align multiple sequences <br>"
                + "simultaneously, revealing conserved patterns across them.</center></html>");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 17));
        descriptionLabel.setForeground(Color.GRAY);
        gbc.gridy = 1; // row 1
        centralPanel.add(descriptionLabel, gbc);

        // Button panel
        CustomButton PSA = new CustomButton("PSA", 100, 60);
        PSA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new sequencealignment.PSA.PSA();
                System.out.println("PSA");
            }
        });
        CustomButton MSA = new CustomButton("MSA", 100, 60);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.add(PSA);
        buttonPanel.add(MSA);

       
        frame.add(centralPanel, BorderLayout.CENTER); 
        frame.add(buttonPanel, BorderLayout.SOUTH);   
    }
}
