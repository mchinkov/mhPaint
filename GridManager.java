import java.awt.GridLayout;
import javax.swing.JButton;

public class GridManager extends JButton{
    private final Pixel[][] pixels; // for the save and load file system we could prolly just set pixels to a Pixel[][] array that is stored in a txt or smt

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

    public Pixel[][] getPixels()
    {
        return pixels;
    }
}
