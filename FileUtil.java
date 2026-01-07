import java.awt.Color;
import java.io.*;

public class FileUtil
{
	public static void saveFile(String fileName, int rows, int cols, GridManager gm) {
        int rowLength = round4(3 * cols);

        int[] tag = {0x42, 0x4D}; // BM

        int[] header = {
            0x3a, 0x00, 0x00, 0x00, // size of file
            0x00, 0x00, 0x00, 0x00, // reserved (?????)
            0x36, 0x00, 0x00, 0x00, // offset to start of image data (54 bytes)
            0x28, 0x00, 0x00, 0x00, // size of info header (40 bytes)
            cols, 0x00, 0x00, 0x00, // width of image in pixels
            rows, 0x00, 0x00, 0x00, // height of image in pixels
            0x01, 0x00,             // number of color planes (??)
            0x18, 0x00,             // bits per pixel (??)
            0x00, 0x00, 0x00, 0x00, // compression (none)
            0x04, 0x00, 0x00, 0x00, // size of image data (ignored if no compression, but still 4 i guess??)
            // these two only matter for printing apparently
            0x13, 0x0B, 0x00, 0x00, // horizontal resolution (pixels per meter) (2835)
            0x13, 0x0B, 0x00, 0x00, // vertical resolution (pixels per meter) (2835)
            0x00, 0x00, 0x00, 0x00, // number of colors in palette (0 = default 2^n)
            0x00, 0x00, 0x00, 0x00  // important colors (0 = all)
        };

        int[][] bmp = new int[rows][rowLength];

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                Color color = gm.getPixels()[i][j].getBackground();

                bmp[rows - i - 1][j * 3] = color.getBlue();
                bmp[rows - i - 1][j * 3 + 1] = color.getGreen();
                bmp[rows - i - 1][j * 3 + 2] = color.getRed();
            }
        }

		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName));

			for (int x : tag) {
                dos.writeByte(x);
            }

            for (int x : header) {
                dos.writeByte(x);
            }

            for (int[] row : bmp) {
                for (int x : row) {
                    dos.writeByte(x);
                }
            }

            dos.close();
		}
		catch(IOException e)
		{
			System.out.println("save error; message: " + e.getMessage());
		}
	}

    public static int round4(int x) {
        while (x % 4 != 0) {
            x++;
        }

        return x;
    }
}