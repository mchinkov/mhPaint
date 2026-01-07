import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;

/**
 * The GridManager class creates and manages a two-dimensional grid
 * of Pixel objects used as the drawing canvas.
 * It is responsible for laying out the grid and providing access
 * to the underlying Pixel structure.
 *
 * @author Michael Chinkov
 *
 * @version 01/1/2026
 */
public class GridManager extends JButton{
    private final Pixel[][] pixels; // 2D array storing all pixels in the drawing grid
    private int ROWS;
    private int COLS;

    /**
     * Constructs a GridManager with the specified number of rows and columns,
     * initializes the grid layout, and populates it with Pixel objects.
     *
     * @param rows the number of rows in the pixel grid
     * @param cols the number of columns in the pixel grid
     */
    public GridManager(int rows, int cols)
    {
        setLayout(new GridLayout(rows, cols, 0, 0));
        pixels = new Pixel[rows][cols];

        ROWS = rows;
        COLS = cols;

        buildGrid();

    }

    private void buildGrid()
    {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                Pixel p = new Pixel(r, c, this);
                pixels[r][c] = p;
                add(p);
            }
        }
    }

    public void paintbucket(int r, int c, Color fillcolor, Color replacedColor)
    {
        if (r < 0 || r >= Main.rows || c < 0 || c >= Main.cols)
        {
            return;
        }

        Pixel p = pixels[r][c];

        if (p.getBackground() != replacedColor || p.getBackground() == fillcolor)
        {
            return;
        }

        p.setBackground(fillcolor);

        paintbucket(r + 1, c, fillcolor, replacedColor); // down
        paintbucket(r - 1, c, fillcolor, replacedColor); // up
        paintbucket(r, c + 1, fillcolor, replacedColor); // right
        paintbucket(r, c - 1, fillcolor, replacedColor); // left
    }

    public void clear()
{
    for (int r = 0; r < ROWS; r++) {
        for (int c = 0; c < COLS; c++) {
            pixels[r][c].reset();
        }
    }
}

    /**
     * Returns the two-dimensional array of Pixel objects managed by this grid.
     *
     * @return the 2D Pixel array representing the drawing canvas
     */
    public Pixel[][] getPixels()
    {
        return pixels;
    }
}
