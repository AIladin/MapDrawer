package DataMap;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DataMap {

    private Color[][] colorMap;
    private int height;
    private int width;

    void setHeight(int height) {
        this.height = height;
    }

    void setWidth(int width) {
        this.width = width;
    }

    void setColorMap(Color[][] colorMap) {
        this.colorMap = colorMap;
    }

    public BufferedImage toBufferedImage(){
        BufferedImage bf = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for (int y=0; y<height; y++){
            for (int x=0; x<width; x++){
                bf.setRGB(x, y, colorMap[y][x].getRGB());
            }
        }
        return bf;
    }

}