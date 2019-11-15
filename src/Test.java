import DataMap.DataMap;
import DataMap.DataMapBuilder;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            DataMap dataMap = DataMapBuilder.fromIntFile("Resources/noise.txt");
            File outputFile = new File("image.jpg");
            ImageIO.write(dataMap.toBufferedImage(), "jpg", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}