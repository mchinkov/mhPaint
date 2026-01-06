import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;

public class GridManager extends JButton{
    private final Pixel[][] pixels; // for the save and load file system we could prolly just set pixels to a Pixel[][] array that is stored in a txt or smt

    public GridManager(int rows, int cols)
    {
        setLayout(new GridLayout(rows, cols, 0, 0));
        pixels = new Pixel[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
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

    public Pixel[][] getPixels()
    {
        return pixels;
    }
}
