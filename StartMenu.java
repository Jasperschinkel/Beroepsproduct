import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartMenu extends JFrame{

    private static final int width = 400;
    private static final int height = 400;
    private static final String title = "Test";

    public static void main(String[] args) {

        StartMenu sm = new StartMenu();
        sm.setSize(width, height);
        sm.setTitle(title);

            class Listener implements ActionListener {
                public void actionPerformed(ActionEvent e) {
                    Playfield p = new Playfield();
                }
            }

        //upperPanel
        JPanel upperPanel = new JPanel();
        upperPanel.setPreferredSize(new Dimension(400,100));
        upperPanel.setBackground(Color.LIGHT_GRAY);

        JLabel title = new JLabel("Keybarricade");
        title.setPreferredSize(new Dimension(200,100));
        title.setFont(new Font("Monospaced", Font.BOLD, 25));
        upperPanel.add(title);

        //panel
        JPanel panel = new JPanel();
        JButton start = new JButton("start");
        panel.add(start);
        ActionListener listener = new Listener();
        start.addActionListener(listener);

        //add panels to frame
        sm.add(upperPanel, BorderLayout.NORTH);
        sm.add(panel, BorderLayout.CENTER);

        sm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sm.setVisible(true);
    }
}
