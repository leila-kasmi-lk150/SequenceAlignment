package sequencealignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author LEILA
 */


public class SequenceAlignment {

    public SequenceAlignment() {
        JFrame frame = new JFrame("Sequence Alignment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setSize(900, 700); 
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null); // Centers the frame
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("img.png"));
        if (imageIcon.getIconWidth() == -1) {
            System.out.println("Image not found or invalid format!");
        } else {
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER); 
            frame.add(imageLabel, BorderLayout.CENTER);
        }

        // Start button
        CustomButton startButton = new CustomButton("Start", 160, 60);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                // new Technique();
                new sequencealignment.PSA.PSA();
                System.out.println("Start");
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(new EmptyBorder(0, 0, 60, 0));
        buttonPanel.add(startButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    
    public static void main(String[] args) {
        new SequenceAlignment();
    }
}

