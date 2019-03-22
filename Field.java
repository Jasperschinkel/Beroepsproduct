import javax.swing.*;
import java.awt.*;

public class Field extends JComponent {
    private Color color;
    private static final int FIELD_WIDTH = 30;
    private static final int FIELD_HEIGHT = 30;
    public Field(Color color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics looks) {
        looks.setColor(color);
        looks.fillRect(0,0,FIELD_WIDTH,FIELD_HEIGHT);
    }
}