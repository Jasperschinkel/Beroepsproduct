import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Wall extends JComponent {
    private Image wall;

    public Wall() {
        try {
            wall = ImageIO.read(new File("C:\\Users\\Joost\\IdeaProjects\\TestField2\\src\\tiles\\Wall.png"));
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
       g.drawImage(wall,0,0,this);
    }
}