import java.awt.GridLayout;
import javax.swing.JButton;

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

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Pixel p = new Pixel(r, c);
                pixels[r][c] = p;
                add(p);
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
