import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Playfield  {

    /**
     * in this class you can play a level, after you finish a level
     * you will return to the StartMenu class.
     */
    private static final String TITLE = "Playfield";
    private static final int FRAME_WIDTH = 650;
    private static final int FRAME_HEIGHT = 650;

    // ATTRIBUTES
    protected static int keyValue = 0;
    protected static String[][] grid;
    protected static String[][] originalGrid;

    // FIELD
    protected static JPanel field;
    protected static JPanel fieldGrid;
    protected static JPanel infoPanel;
    public static JLabel info;

    public Playfield() {
        //checks which level is chosen and applies that level
        if (StartMenu.level.equals("level 1")) {
            grid = Levels.lvl1.clone();
            originalGrid = Levels.lvl1;
        }
        if (StartMenu.level.equals("level 2")) {
            grid = Levels.lvl2.clone();
            originalGrid = Levels.lvl2;
        }
        if (StartMenu.level.equals("level 3")) {
            grid = Levels.lvl3.clone();
            originalGrid = Levels.lvl3;
        }

        JFrame frame = new JFrame();
        frame.setTitle(TITLE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        addComponents();
        drawGrid();

        frame.add(field, BorderLayout.CENTER);
        frame.add(infoPanel, BorderLayout.SOUTH);

        //add movement to the player
        KeyListener listener = new Move();
        frame.addKeyListener(listener);

        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    /**
     * adds components to the field
     */

    public void addComponents() {
        // GRID
        fieldGrid = new JPanel();
        fieldGrid.setLayout(new GridLayout(10, 10));

        // FIELD
        field = new JPanel();
        field.setLayout(new BorderLayout());
        field.setBackground(Color.LIGHT_GRAY);
        field.add(fieldGrid);

        //INFO
        infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(650, 25));
        info = new JLabel();
        infoPanel.add(info);


    }

    /**
     * draws the grid on the field
     * loops through the 2d String array
     * if the array has a certain name, it will change to a certain tile
     * g = grass
     * w = wall
     * p = player
     * f = finish
     * bx = barricade (with value x)
     * kx = key (with value x)
     */

    protected static void drawGrid () {
        fieldGrid.removeAll();
        fieldGrid.setBackground(new Color(4, 167, 12));

        for (int x = 0; x < grid.length; x++) { // loops through columns
            for (int y = 0; y < grid[x].length; y++) { // loops through rows
                if (grid[x][y].equals("g")) {
                    fieldGrid.add(new Grass());
                }

                if (grid[x][y].equals("w")) {
                    fieldGrid.add(new Wall());
                }

                if (grid[x][y].equals("p")) {
                    fieldGrid.add(new Player());
                }

                if (grid[x][y].equals("b100")) {
                    fieldGrid.add(new Barricade(100));
                }

                if (grid[x][y].equals("b200")) {
                    fieldGrid.add(new Barricade(200));
                }

                if (grid[x][y].equals("b300")) {
                    fieldGrid.add(new Barricade(300));
                }

                if (grid[x][y].equals("k100")) {
                    fieldGrid.add(new Key(100));
                }

                if (grid[x][y].equals("k200")) {
                    fieldGrid.add(new Key(200));
                }

                if (grid[x][y].equals("k300")) {
                    fieldGrid.add(new Key(300));
                }

                if (grid[x][y].equals("f")) {
                    fieldGrid.add(new Finish());
                }
            }
            fieldGrid.revalidate();
        }
        info.setText(StartMenu.level);
    }

    public void close() {
    }
}
