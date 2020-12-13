package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class VerticalLines {
    private float Length;
    private Line Line;
    public VerticalLines(double Length){
        this.Length =(float) Length;
        this.Line = new Line();
        createLine(this.Line);

    }
    private void createLine(Line line) {
        line.setStroke(Color.GREEN);
        line.setStrokeWidth(10);
        line.setStartX(10);
        line.setEndX(Length);
        line.setRotate(0);
        line.setLayoutX(100);
        line.setLayoutY(100);
        line.setFill(Color.TRANSPARENT);
    }

    public Line getLine() {
        return this.Line;
    }

    public float getLength() {
        return Length;
    }

    public void setLength(float length) {
        Length = length;
    }
}
