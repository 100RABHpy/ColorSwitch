package sample;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;

import java.io.Serializable;

public class VerticalLines extends Obstacle implements Serializable {
    private float Length;
    private Group Line;
    public VerticalLines(Position position,double Length){
        super(position);
        this.Length =(float) Length;
        Line line = new Line();
        createLine(line);
        Line = new Group();
        Line.getChildren().add(line);

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

    public Group getLine() {
        return this.Line;
    }

    public float getLength() {
        return Length;
    }

    public void setLength(float length) {
        Length = length;
    }

    @Override
    public Group getObstacle() {
        return Line;
    }

    @Override
    public String getType() {
        return null;
    }

}
