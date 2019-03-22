import javax.swing.*;
import java.awt.*;

public class KeybarricadeMainFrame extends JFrame {


    /**
     * De initialisaties van de JPanels, de playingField zelf, het grid zelf en de 2d array voor de grootte van het grid.
     * Ook zijn de afmetingen van het speelveld geinitialiseerd en de titel van het Speelveld.
     */
    private static int[][] playingfieldSize;
    private JPanel playingField;
    private JPanel playingfieldGrid;

    private static final String TITLE = "Playingfield";
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;

    /**
     *
     *
     */
    public KeybarricadeMainFrame(){

        this.setTitle(TITLE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playingfieldSize = new int[10][10];
        int playingfieldSize[][] = {

                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 2, 3, 0, 0, 0, 0, 0, 0, 0},
                {1, 2, 3, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 3, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}

        };

        playingField = new JPanel();
        playingField.setLayout(new BorderLayout());
        playingField.setBackground(Color.LIGHT_GRAY);

        playingfieldGrid = new JPanel();
        playingfieldGrid.setLayout(new GridLayout (playingfieldSize.length, playingfieldSize[0].length));

        this.drawGridPanel();

        playingField.add(playingfieldGrid, BorderLayout.CENTER);
        playingfieldGrid.setBackground(Color.LIGHT_GRAY);

        this.add(playingField);
        this.setResizable(false);
        this.setVisible(true);

        }

    private void drawGridPanel() {
        playingfieldGrid.removeAll();
        for (int x = 0; x < playingfieldSize.length; x++) {
            for (int y = 0; y < playingfieldSize[x].length; y++) {
                if (playingfieldSize[x][0] == 0) {
                    playingfieldGrid.add(new Field(Color.LIGHT_GRAY));
                } else if (playingfieldSize [0][y] == 0){
                    playingfieldGrid.add(new Field(Color.LIGHT_GRAY));
                } else

                if (playingfieldSize[x][0] == 1) {
                    playingfieldGrid.add(new Field(Color.RED));
                } else if (playingfieldSize [0][y] == 1){
                    playingfieldGrid.add(new Field(Color.RED));
                } else

                if (playingfieldSize[x][0] == 2) {
                    playingfieldGrid.add(new Field(Color.BLUE));
                } else if (playingfieldSize [0][y] == 2){
                    playingfieldGrid.add(new Field(Color.BLUE));
                } else

                if (playingfieldSize[x][0] == 3) {
                    playingfieldGrid.add(new Field(Color.GREEN));
                } else if (playingfieldSize [0][y] == 3){
                    playingfieldGrid.add(new Field(Color.GREEN));
                }
            }
        }
        playingfieldGrid.revalidate();
    }

}
