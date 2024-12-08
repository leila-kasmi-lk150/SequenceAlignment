package sequencealignment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author LEILA
 */
public class CustomButton extends JButton {
    public CustomButton(String text, int width, int height) {
        super(text);
        
        Font font = new Font("Canva Sans", Font.BOLD, 20);
        setForeground(Color.BLACK);
        setBackground(new Color(2, 146, 183));
        setFont(font);
        setFocusable(false);
        //setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        setOpaque(true);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setPreferredSize(new Dimension(width, height));
        
    }
}
