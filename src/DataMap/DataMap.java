package DataMap;

import java.awt.*;

public class DataMap {

    public enum HighlightType{
        ONE_COLOR("One color"),
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

        @Override
        public String toString(){
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

    public Result getConnectedAreas(){
        ConnectedAreasExecutor connectedAreasExecutor = new ConnectedAreasExecutor();
        return connectedAreasExecutor.maxConnectedArea(this);
    }
}