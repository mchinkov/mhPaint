import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;


public class Main {

    public static final int widthWindow = 420;
    public static final int lengthWindow = 420;

    //all possible tools
    public enum Tool {
        BRUSH,
        ERASER,
        PAINT_BUCKET
    }

    public static Tool currentTool = Tool.BRUSH;

    public static void main(String[] args) {
        ImageIcon image = new ImageIcon("Paint Brush Image.png");
        JFrame frame = new JFrame();

        frame.setTitle("mhPaint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(image.getImage());

        // Use BorderLayout so we can place a toolbar on the side
        frame.setLayout(new BorderLayout());

        // Side toolbar panel
        JPanel toolBar = new JPanel();
        toolBar.setLayout(new BoxLayout(toolBar, BoxLayout.Y_AXIS));

        // Brush tool button
        JButton brushButton = new JButton("Brush");
        brushButton.addActionListener(e -> {
            currentTool = Tool.BRUSH;
            System.out.println("Tool selected: " + currentTool);
        });

        // Eraser tool button
        JButton eraserButton = new JButton("Eraser");
        eraserButton.addActionListener(e -> {
            currentTool = Tool.ERASER;
            System.out.println("Tool selected: " + currentTool);
        });

        // PaintBucket tool button
        JButton paintBucketButton = new JButton("Paint Bucket");
        paintBucketButton.addActionListener(e -> {
            currentTool = Tool.PAINT_BUCKET;
            System.out.println("Tool selected: " + currentTool);
        });


        toolBar.add(brushButton);
        toolBar.add(eraserButton);
        toolBar.add(paintBucketButton);

        // Add toolbar to the left side of the window
        frame.add(toolBar, BorderLayout.WEST);

        frame.setSize(widthWindow,lengthWindow);
        frame.setVisible(true);
    }
}