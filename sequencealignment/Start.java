package sequencealignment;


import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author LEILA
 */
public class Start {
    public Start(){
        JFrame frame = new JFrame("Sequence Alignment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setSize(900, 700); 
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null); // Centers the frame
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel sideMenu = new JPanel();
        sideMenu.setLayout(new BoxLayout(sideMenu, BoxLayout.Y_AXIS));
        sideMenu.setBackground(new Color(139, 211, 221));
        sideMenu.setPreferredSize(new Dimension(100, 700)); 
        sideMenu.setBorder(BorderFactory.createEmptyBorder());

        JButton NWA = createMenuButton("NWA"); 
        //NWA.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JButton SWA = createMenuButton("SWA");
        JButton button3 = createMenuButton("Button 3");

        sideMenu.add(NWA);
        sideMenu.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        sideMenu.add(SWA);
        sideMenu.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        sideMenu.add(button3);

        // Create a table for the center area
        String[] columnNames = {"Column 1", "Column 2", "Column 3"};
        Object[][] data = {
                {"Data 1", "Data 2", "Data 3"},
                {"Data 4", "Data 5", "Data 6"},
                {"Data 7", "Data 8", "Data 9"}
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setBackground(Color.WHITE);
        table.setBorder(BorderFactory.createEmptyBorder());

        // Put the table inside a JScrollPane
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBackground(Color.WHITE);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder());
        
        // Create the main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(sideMenu, BorderLayout.WEST); // Add side menu to the west
        mainPanel.add(tableScrollPane, BorderLayout.CENTER); // Add table to the center



        // Add main panel to the frame
        frame.add(mainPanel);

        // Set frame visibility
        frame.setVisible(true);
    }
    // Helper method to create a button with an icon and title
    private static JButton createMenuButton(String title) {
        // Load the icon (make sure icons are in your project directory)
        JButton button = new JButton(title);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFocusPainted(false);
        button.setBackground(new Color(139, 211, 221)); 
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return button;
    }
}
