import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * The Main class initializes the mhPaint application window,
 * sets up the toolbar and drawing grid, and launches the program.
 *
 * @author Michael Chinkov
 *
 * @version 01/1/2026
 */
public class Main {

    public static final int widthWindow = 420;
    public static final int lengthWindow = 420;

    public static final int rows = 100;
    public static final int cols = 100;

    //all possible tools
    public enum Tool {
        BRUSH,
        ERASER,
        PAINT_BUCKET
    }


    public static Tool currentTool = Tool.BRUSH;
    public static Color currentColor = Color.BLACK;
    public static String fileName = "image";

    /**
     * Creates and displays the mhPaint application window,
     * initializes the toolbar and grid, and starts user interaction.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        GridManager gridPanel = new GridManager(rows, cols);

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

        // Red input
        JTextField redInput = new JTextField();

        redInput.addActionListener(e -> {
            String input = redInput.getText();

            try {
                int redValue = Integer.parseInt(input);
                
                if (redValue < 0 || redValue > 255) {
                    throw new NumberFormatException();
                }

                Color c = new Color(redValue, currentColor.getGreen(), currentColor.getBlue());
                currentColor = c;
                System.out.println("Custom color: " + currentColor);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid red value. Please enter a number between 0 and 255.");
            }
        });

        // Green input
        JTextField greenInput = new JTextField();

        greenInput.addActionListener(e -> {
            String input = greenInput.getText();

            try {
                int greenValue = Integer.parseInt(input);

                if (greenValue < 0 || greenValue > 255) {
                    throw new NumberFormatException();
                }

                Color c = new Color(currentColor.getRed(), greenValue, currentColor.getBlue());
                currentColor = c;
                System.out.println("Custom color: " + currentColor);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid green value. Please enter a number between 0 and 255.");
            }
        });

        // Blue input
        JTextField blueInput = new JTextField();

        blueInput.addActionListener(e -> {
            String input = blueInput.getText();

            try {
                int blueValue = Integer.parseInt(input);

                if (blueValue < 0 || blueValue > 255) {
                    throw new NumberFormatException();
                }

                Color c = new Color(currentColor.getRed(), currentColor.getGreen(), blueValue);
                currentColor = c;
                System.out.println("Custom color: " + currentColor);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid blue value. Please enter a number between 0 and 255.");
            }
        });

        // Filename input
        JTextField filenameInput = new JTextField();

        filenameInput.addActionListener(e -> {
            String input = filenameInput.getText();

            if (!input.equals("")) {
                fileName = input;
                System.out.println("Filename set to: " + fileName);
            } else {
                System.out.println("Invalid filename.");
            }
        });

        // Save image button
        JButton saveButton = new JButton("Save Image");

        saveButton.addActionListener(e -> {
            FileUtil.saveFile(fileName + ".bmp", rows, cols, gridPanel);
            System.out.println("image saved");
        });

        toolBar.add(blackButton);
        toolBar.add(whiteButton);
        toolBar.add(greyButton);
        toolBar.add(redButton);
        toolBar.add(greenButton);
        toolBar.add(blueButton);
        toolBar.add(yellowButton);
        toolBar.add(orangeButton);
        toolBar.add(redInput);
        toolBar.add(greenInput);
        toolBar.add(blueInput);
        toolBar.add(brushButton);
        toolBar.add(eraserButton);
        toolBar.add(paintBucketButton);
        toolBar.add(filenameInput);
        toolBar.add(saveButton);

        // Add pixels to the center of the window
        frame.add(gridPanel, BorderLayout.CENTER);

        // Add toolbar to the left side of the window
        frame.add(toolBar, BorderLayout.WEST);

        frame.setSize(widthWindow,lengthWindow);
        frame.setVisible(true);
    }
}