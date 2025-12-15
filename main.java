import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

    public static final int widthWindow = 420;
    public static final int lengthWindow = 420;
    

    public static void main(String[] args) {
        ImageIcon image = new ImageIcon("Paint Brush Image.png");
        JFrame frame = new JFrame();

        frame.setTitle("mhPaint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(image.getImage());

        frame.setSize(widthWindow,lengthWindow);
        frame.setVisible(true);
    }
}