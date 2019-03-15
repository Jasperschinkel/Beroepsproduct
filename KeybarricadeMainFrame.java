import javax.swing.*;
import java.awt.*;

public class KeybarricadeMainFrame extends JFrame {

    private int[][] playingfieldSize;
    private JPanel playingField;
    private JPanel playingfieldGrid;

    private static final String TITLE = "Speelveld";
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;

    public KeybarricadeMainFrame(){

        this.setTitle(TITLE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        playingField = new JPanel();
        playingField.setLayout(new BorderLayout());
        playingField.setBackground(Color.LIGHT_GRAY);

        playingfieldGrid = new JPanel();
        playingfieldGrid.setLayout(new GridLayout(10,10));
        playingfieldSize = new int[10][10];

        this.drawGridPanel();

        playingField.add(playingfieldGrid, BorderLayout.CENTER);
        playingfieldGrid.setBackground(Color.LIGHT_GRAY);

        this.add(playingField);
        this.setVisible(true);
    }
    private void drawGridPanel() {
        playingfieldGrid.removeAll();
        for (int i = 0; i < playingfieldSize.length; i++) {
            for (int j = 0; j < playingfieldSize[i].length; j++) {
                if (playingfieldSize[i][i] == 1) {
                    playingfieldGrid.add(new Field(Color.BLUE));
                } else {
                    playingfieldGrid.add(new Field(Color.LIGHT_GRAY));
                }
            }
        }
        playingfieldGrid.revalidate();
    }

}
