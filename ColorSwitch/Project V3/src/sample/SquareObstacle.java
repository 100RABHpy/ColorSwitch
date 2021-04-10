package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;

import java.io.Serializable;

public class SquareObstacle extends Obstacle implements Serializable {
    private float sideLength;
    private Group FinalSquare;
    private String type = "Square";
    public String getType() {
        return type;
    }
    public SquareObstacle(Position initialPosition,double initialLength){
        super(initialPosition);
        this.sideLength =(float) initialLength;
        Line line1 = new Line();
        Line line2 = new Line();
        Line line3 = new Line();
        Line line4 = new Line();
        createLine(line1);
        line1.setLayoutY(line1.getLayoutY()-50+5);
        createLine(line2);
        line2.setRotate(90);
        line2.setLayoutX(line2.getLayoutX()-50+5);
        createLine(line3);
        line3.setRotate(180);
        line3.setLayoutY(line3.getLayoutY()+50-5);
        createLine(line4);
        line4.setRotate(270);
        line4.setLayoutX(line4.getLayoutX()+50-5);
        line1.setStroke(Color.BLUE);
        line2.setStroke(Color.GREEN);
        line3.setStroke(Color.RED);
        line4.setStroke(Color.YELLOW);
        FinalSquare = new Group();
        FinalSquare.getChildren().addAll(line1,line2,line3,line4);
        FinalSquare.setLayoutX(getPosition().getX());
        FinalSquare.setLayoutY(getPosition().getY());
    }
    private void createLine(Line line) {
        line.setStroke(Color.GREEN);
        line.setStrokeWidth(10);
        line.setStartX(10);
        line.setEndX(100);
        line.setRotate(0);
        line.setLayoutX(100);
        line.setLayoutY(100);
        line.setFill(Color.TRANSPARENT);
    }

    @Override
    public Group getObstacle() {
        return FinalSquare;
    }



}
