import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends JComponent {
    private Image player;


    public Player() {
        try {
            player = ImageIO.read(new File("C:\\Users\\Joost\\IdeaProjects\\TestField2\\src\\tiles\\PCFront.png"));
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(player, 0, 0, this);
    }
}