import javax.swing.*;
import java.awt.*;

public class Grass extends JComponent {
    private Color color;

    public Grass() {
        this.color = Color.GREEN;
    }

    @Override
    protected void paintComponent(Graphics looks) {
        looks.setColor(color);
        looks.fillRect(0,0,35,35);
    }
}