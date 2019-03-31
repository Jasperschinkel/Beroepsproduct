import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Key extends JComponent {
    private int value;
    private Image key100;
    private Image key200;
    private Image key300;

    public Key(int value) {
        this.value = value;
        try {
            key100 = ImageIO.read(new File("C:\\Users\\Joost\\IdeaProjects\\TestField2\\src\\tiles\\Key.png"));
            key200 = ImageIO.read(new File("C:\\Users\\Joost\\IdeaProjects\\TestField2\\src\\tiles\\Scissors.png"));
            key300 = ImageIO.read(new File("C:\\Users\\Joost\\IdeaProjects\\TestField2\\src\\tiles\\Chainsaw.png"));
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (value == 100) {
            g.drawImage(key100, -10, -7, this);
        } else if (value == 200) {
            g.drawImage(key200, -10, -7, this);
        } else if (value == 300) {
            g.drawImage(key300, -10, -7, this);
        }
    }
}