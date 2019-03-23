import javax.swing.*;
import java.awt.*;

public class Wall extends JComponent {
    private Color color;

    public Wall() {
        this.color = Color.BLACK;
    }

    @Override
    protected void paintComponent(Graphics looks) {
        looks.setColor(color);
        looks.fillRect(0,0,35,35);
    }
}