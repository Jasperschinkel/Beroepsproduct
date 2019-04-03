import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartMenu extends JFrame {

    /**
     * this class is the level select screen, you will start here
     */
    private static final int width = 400;
    private static final int height = 400;
    private static final String title = "Test";
    public static String level;

    public static void main(String[] args) {
        StartMenu sm = new StartMenu();
    }

    public StartMenu() {

        this.setSize(width, height);
        this.setTitle(title);

        // initializes 3 buttons so you can choose 3 levels
        JButton lvl1 = new JButton("level 1");
        JButton lvl2 = new JButton("level 2");
        JButton lvl3 = new JButton("level 3");

        //KeyListener so the program knows which button you pressed
        class Listener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == lvl1) {
                    level = "level 1";
                } else if (e.getSource() == lvl2) {
                    level = "level 2";
                } else if (e.getSource() == lvl3) {
                    level = "level 3";
                }
                Playfield p = new Playfield();
                setVisible(false);
            }
        }

        //upperPanel with the name of the game
        JPanel upperPanel = new JPanel();
        upperPanel.setPreferredSize(new Dimension(400, 100));
        upperPanel.setBackground(Color.LIGHT_GRAY);

        JLabel title = new JLabel("Keybarricade");
        title.setPreferredSize(new Dimension(200, 100));
        title.setFont(new Font("Monospaced", Font.BOLD, 25));
        upperPanel.add(title);


        //panel with instructions and buttons to select a level
        JPanel panel = new JPanel();

        ActionListener listener = new Listener();
        lvl1.addActionListener(listener);
        lvl2.addActionListener(listener);
        lvl3.addActionListener(listener);

        JLabel instructions = new JLabel("<html>Instructions: you can walk with the arrow keys.<br>" +
                "You win when you reach the finish.<br>" +
                "If you are stuck, press R to reset the level.</html>");
        instructions.setHorizontalAlignment(SwingConstants.CENTER);
        instructions.setPreferredSize(new Dimension(300,100));
        panel.add(instructions);
        panel.add(lvl1); //todo fix this so the 3 button are next to each other
        panel.add(lvl2);
        panel.add(lvl3);

        //add panels to frame
        add(upperPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
