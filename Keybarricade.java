import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Frame {
    
    private static final String TITLE = "Test";
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    // ATTRIBUTES
    protected int keyValue = 0;
    protected static String[][] grid = { //spaties zijn er om array leesbaar te houden
           {"p", "g",    "g",    "w",    "g", "g",    "w", "g", "w",    "g"},
           {"g", "k100", "g",    "b100", "g", "g",    "w", "g", "w",    "g"},
           {"w", "w",    "w",    "w",    "g", "g",    "g", "g", "g",    "g"},
           {"w", "w",    "w",    "w",    "g", "w",    "g", "g", "g",    "w"},
           {"g", "g",    "g",    "g",    "g", "g",    "w", "w", "w",    "g"},
           {"g", "b100", "b100", "g",    "g", "k100", "g", "g", "g",    "g"},
           {"g", "b200", "b200", "g",    "g", "k200", "g", "g", "g",    "g"},
           {"g", "b300", "b300", "g",    "g", "k300", "g", "g", "g",    "g"},
           {"g", "g",    "g",    "g",    "g", "g",    "g", "g", "w",    "w"},
           {"g", "g",    "g",    "g",    "g", "g",    "g", "g", "b100", "g"}
    };

    // FIELD
    protected static JPanel field;
    protected static JPanel fieldGrid;

    // UNDERPANEL
    private static JPanel underPanel;
    private static boolean isRuning = true;
    private static Long start = System.currentTimeMillis();
    private static JLabel timelbl;

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();

        JFrame frame = new JFrame();
        frame.setTitle(TITLE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        addComponents();
        drawGrid();
        //addTime();
        frame.add(field, BorderLayout.CENTER);
        frame.add(underPanel, BorderLayout.SOUTH);
        KeyListener listener = new Move();
        frame.addKeyListener(listener);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * adds components to the field
     */

    private static void addComponents() {
        // UNDERPANEL
        timelbl = new JLabel();
        JButton button = new JButton("reset");

        underPanel = new JPanel();
        underPanel.setBackground(Color.WHITE);
        //underPanel.add(button); //todo move button to the left
        //underPanel.add(timelbl); //todo move time to the right

        // GRID
        fieldGrid = new JPanel();
        fieldGrid.setLayout(new GridLayout(10,10));
        fieldGrid.setBackground(Color.LIGHT_GRAY);

        // FIELD
        field = new JPanel();
        field.setLayout(new BorderLayout());
        field.setBackground(Color.LIGHT_GRAY);
        field.add(fieldGrid, BorderLayout.CENTER);
    }

    /**
     * draws the grid on the field
     * loops through the 2d String array
     * if the array has a certain name, it will change to a certain tile
     * g = grass
     * w = wall
     * p = player
     * bx = barricade (with value x)
     * kx = key (with value x)
     */

    protected static void drawGrid() {
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
            }
            fieldGrid.revalidate();
        }
    }

    /**
     * adds a timer to the underPanel
     */

    private static void addTime() { //todo fix this method
        while (isRuning) {
            Long end = System.currentTimeMillis();
            long time = (end - start) / 1000;
            String time2 = "time: " + time;
            try {
                timelbl.setText(time2);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }
}
