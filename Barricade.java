import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Barricade extends JComponent {
    private int value;
    private Image barricade100;
    private Image barricade200;
    private Image barricade300;


    public Barricade(int value) {
        this.value = value;
        try {
            barricade100 = ImageIO.read(new File("C:\\Users\\Joost\\IdeaProjects\\TestField2\\src\\tiles\\Barricade.png"));
            barricade200 = ImageIO.read(new File("C:\\Users\\Joost\\IdeaProjects\\TestField2\\src\\tiles\\Bush.png"));
            barricade300 = ImageIO.read(new File("C:\\Users\\Joost\\IdeaProjects\\TestField2\\src\\tiles\\Stump.png"));

        } catch (IOException e) {
            System.out.println("error");
        }
    }

    @Override
    protected void paintComponent(Graphics g) { //aangepaste x & y om het te laten passen
        if (value == 100) {
            g.drawImage(barricade100,-5,-10,this);
        } else if (value == 200) {
            g.drawImage(barricade200,0,-25,this);
        } else if (value == 300) {
            g.drawImage(barricade300,-8,-15,this);
        }
    }
}

