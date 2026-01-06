import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Color;


public class Main {

    public static final int widthWindow = 420;
    public static final int lengthWindow = 420;

    public static final int rows = 30;
    public static final int cols = 30;

    //all possible tools
    public enum Tool {
        BRUSH,
        ERASER,
        PAINT_BUCKET
    }


    public static Tool currentTool = Tool.BRUSH;
    public static Color currentColor = Color.BLACK;

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

        // Red color button
        JButton redButton = new JButton("Red");

        redButton.addActionListener(e -> {
            currentColor = Color.RED;
            System.out.println("Color Selected: " + currentColor);
        });

        // Blue color button
        JButton blueButton = new JButton("Blue");

        blueButton.addActionListener(e -> {
            currentColor = Color.BLUE;
            System.out.println("Color Selected: " + currentColor);
        });

        // Black color button
        JButton blackButton = new JButton("Black");

        blackButton.addActionListener(e -> {
            currentColor = Color.BLACK;
            System.out.println("Color Selected: " + currentColor);
        });

        // White color button
        JButton whiteButton = new JButton("White");

        whiteButton.addActionListener(e -> {
            currentColor = Color.WHITE;
            System.out.println("Color Selected: " + currentColor);
        });

        // Green color button
        JButton greenButton = new JButton("Green");

        greenButton.addActionListener(e -> {
            currentColor = Color.GREEN;
            System.out.println("Color Selected: " + currentColor);
        });

        // Grey color button
        JButton greyButton = new JButton("Grey");

        greyButton.addActionListener(e -> {
            currentColor = Color.GRAY;
            System.out.println("Color Selected: " + currentColor);
        });

        // Yellow color button
        JButton yellowButton = new JButton("Yellow");

        yellowButton.addActionListener(e -> {
            currentColor = Color.YELLOW;
            System.out.println("Color Selected: " + currentColor);
        });

        // Orange color button
        JButton orangeButton = new JButton("Orange");

        orangeButton.addActionListener(e -> {
            currentColor = Color.ORANGE;
            System.out.println("Color Selected: " + currentColor);
        });

        toolBar.add(blackButton);
        toolBar.add(whiteButton);
        toolBar.add(greyButton);
        toolBar.add(redButton);
        toolBar.add(greenButton);
        toolBar.add(blueButton);
        toolBar.add(yellowButton);
        toolBar.add(orangeButton);
        toolBar.add(brushButton);
        toolBar.add(eraserButton);
        toolBar.add(paintBucketButton);


        GridManager gridPanel = new GridManager(rows, cols);

        // Add pixels to the center of the window
        frame.add(gridPanel, BorderLayout.CENTER);

        // Add toolbar to the left side of the window
        frame.add(toolBar, BorderLayout.WEST);

        frame.setSize(widthWindow,lengthWindow);
        frame.setVisible(true);
    }
}