package DataMap;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DataMap {

    public enum HighlightType{
        CONNECTED_AREA("Connected Area"),
        SQUARE_AREA("Square Area"),
        LINES("Lines"),
        POLYGONS("Polygons"),
        ELLIPSE("Ellipse"),
        ;
        private String name;
        HighlightType(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
    }

    private Color[][] colorMap;
    private int height;
    private int width;

    Color[][] getColorMap() {
        return colorMap;
    }

    int getHeight() {
        return height;
    }

    int getWidth() {
        return width;
    }

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