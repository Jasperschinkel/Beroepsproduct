import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Endscreen extends JFrame{
    JFrame endscreen; // end screen for returning to level select screen
    private static final int width = 400, height = 400;
    private static final String title = "End screen";

    JButton goBack;

    public Endscreen(){
        endscreen = new JFrame();
        setSize(width, height);
        setTitle(title);
        setResizable(false);
        endscreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.goBack = new JButton("Go back to level select screen.");
        ActionListener listener = new Listener();
        goBack.addActionListener(listener);

        JPanel upperPanel = new JPanel();
        upperPanel.setPreferredSize(new Dimension(500, 100));
        upperPanel.setBackground(Color.LIGHT_GRAY);
        JLabel text = new JLabel("You have completed this level!");
        text.setPreferredSize(new Dimension(370, 100));
        text.setFont(new Font("Monospaced", Font.BOLD, 20));
        upperPanel.add(text);

        //add panels to screen
        add(upperPanel, BorderLayout.NORTH);
        add(goBack, BorderLayout.SOUTH);

        setVisible(true);
    }
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == goBack){
                setVisible(false);
                StartMenu newMenu = new StartMenu();
                newMenu.setVisible(true);
            }

        }
    }
    public static void main(String[] args) {
        Endscreen es = new Endscreen();
    }
}
