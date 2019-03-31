import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Grass extends JComponent {
    private  Image grass;

    public Grass() {
        try {
            grass = ImageIO.read(new File("C:\\Users\\Joost\\IdeaProjects\\TestField2\\src\\tiles\\grass.png"));
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
       g.drawImage(grass,0,0, this);

    }
}
