import javax.swing.*;
import java.awt.*;

public class Field extends JComponent {
    private Color color;

    public Field(Color color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics looks) {
        looks.setColor(color);
        looks.fillRect(0,0,30,30);
    }
}