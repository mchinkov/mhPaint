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

    private final int row; // row position of this pixel in the grid
    private final int col; // column position of this pixel in the grid
    
    /**
     * Constructs a Pixel at the specified row and column location
     * and initializes its appearance and behavior.
     *
     * @param r the row index of this pixel
     * @param c the column index of this pixel
     */
    public Pixel(int r, int c)
    {
        row = r;
        col = c;

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
                else
                {
                    setBackground(Main.currentColor);
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
}