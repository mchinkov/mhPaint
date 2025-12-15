import javax.swing.JFrame;

public class Main {

    public static final int widthWindow = 420;
    public static final int lengthWindow = 420;

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setTitle("mhPaint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(widthWindow,lengthWindow);
        frame.setVisible(true);
    }
}