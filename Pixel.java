import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;

public class Pixel extends JButton{

    private final int row;
    private final int col;
    
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

    public String getCoords()
    {
        return "(" + row + ", " + col + ")";
    }
}