import javax.swing.JButton;
import java.awt.Color;

public class Pixel extends JButton{

    private final int row;
    private final int col;
    
    public Pixel(int r, int c)
    {
        row = r;
        col = c;

        JButton cell = new JButton(); // no text by default
        cell.setText("o");                
        cell.setOpaque(true); // shows background?
        cell.setBackground(Color.WHITE); // starting color
        cell.setBorderPainted(true); // enables border
        cell.setFocusPainted(false); // removes focus outline
        cell.setContentAreaFilled(true);        
    }

    public String getCoords()
    {
        return "(" + row + ", " + col + ")";
    }
}