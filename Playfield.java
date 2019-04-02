import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Playfield extends JFrame {

    public static void main(String[] args) {
        Playfield p = new Playfield();
    }

    private static final String TITLE = "Test";
    private static final int FRAME_WIDTH = 650;
    private static final int FRAME_HEIGHT = 650;

    // ATTRIBUTES
    protected static int keyValue = 0;
    protected static String[][] grid = { //spaties zijn er om array leesbaar te houden
            {"p", "g", "g", "w", "g", "g", "w", "g", "w", "g"},
            {"g", "k100", "g", "b100", "g", "g", "w", "g", "w", "g"},
            {"w", "w", "w", "w", "g", "g", "g", "g", "g", "g"},
            {"w", "w", "w", "w", "g", "w", "g", "g", "g", "w"},
            {"g", "g", "g", "g", "g", "g", "w", "w", "w", "g"},
            {"g", "b100", "b100", "g", "g", "k100", "g", "g", "g", "g"},
            {"g", "b200", "b200", "g", "g", "k200", "g", "g", "g", "g"},
            {"g", "b300", "b300", "g", "g", "k300", "g", "g", "g", "g"},
            {"g", "g", "g", "g", "g", "g", "g", "g", "w", "b100"},
            {"g", "g", "g", "g", "g", "g", "g", "g", "b100", "f"}
    };

    // FIELD
    protected static JPanel field;
    protected static JPanel fieldGrid;
    protected static JPanel infoPanel;
    public static JLabel info;

    public Playfield() {

        JFrame frame = new JFrame();
        frame.setTitle(TITLE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        addComponents();
        drawGrid();

        frame.add(field, BorderLayout.CENTER);
        frame.add(infoPanel, BorderLayout.SOUTH);

        KeyListener listener = new Move();
        frame.addKeyListener(listener);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    /**
     * adds components to the field
     */

    public static void addComponents() {
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
            info.setText("test");
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
        }


    }
