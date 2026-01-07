import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;

/**
 * The Pixel class represents a single drawable cell in the paint grid.
 * Each Pixel responds to user interaction by changing its color
 * based on the currently selected drawing tool.
 *
 * @author Michael Chinkov
 *
 * @version 01/1/2026
 */
public class Pixel extends JButton{

    private final int row;
    private final int col;
    private GridManager gm;
    
    public Pixel(int r, int c, GridManager g)
    {
        row = r;
        col = c;
        gm = g;

        setText("");                
        setOpaque(true); // shows background?
        setBackground(Color.WHITE); // starting color
        setBorderPainted(true); // enables border
        setFocusPainted(false); // removes focus outline
        setContentAreaFilled(true);      
        
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(200,200,200)));
        setBorderPainted(true);
        setFocusPainted(false);
        setFocusable(false);

        addActionListener(e -> 
            {
                
                System.out.println("Clicked " + getCoords());

                if (Main.currentTool == Main.Tool.ERASER)
                {
                    setBackground(Color.WHITE);
                }
                else if (Main.currentTool == Main.Tool.BRUSH)
                {
                    setBackground(Main.currentColor);
                }
                else if (Main.currentTool == Main.Tool.PAINT_BUCKET)
                {
                    Color filledColor = getBackground();
                    gm.paintbucket(row, col, Main.currentColor, filledColor);
                }
             });
    }

    /**
     * Returns the row and column coordinates of this pixel
     * in a readable string format.
     *
     * @return a string containing this pixel's coordinates
     */
    public String getCoords()
    {
        return "(" + row + ", " + col + ")";
    }

    public void reset()
    {
        setBackground(Color.WHITE);
    }
}