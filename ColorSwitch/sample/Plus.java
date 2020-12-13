package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Plus {
    private float Length;
    private float Breadth;

    private Group FinalPlus;
    public Plus(double Length,double Breadth){
        this.Length =(float) Length;
        this.Breadth =(float) Breadth;
        Line line1 = new Line();
        Line line2 = new Line();
        Line line3 = new Line();
        Line line4 = new Line();
        createLine(line1);
        line1.setLayoutX(line1.getLayoutX()-((Length-10)/2)-Breadth);
        createLine(line2);
        line2.setLayoutY(line2.getLayoutY()-((Length-10)/2)-Breadth);
        line2.setRotate(90);
        createLine(line3);
        line3.setLayoutX(line3.getLayoutX()+((Length-10)/2)+Breadth);
        line3.setRotate(180);
        createLine(line4);
        line4.setLayoutY(line4.getLayoutY()+((Length-10)/2)+Breadth);
        line4.setRotate(270);
        line1.setStroke(Color.BLUE);
        line2.setStroke(Color.GREEN);
        line3.setStroke(Color.RED);
        line4.setStroke(Color.YELLOW);
        FinalPlus = new Group();
        FinalPlus.getChildren().addAll(line1,line2,line3,line4);


    }
    private void createLine(Line line) {
        line.setStroke(Color.GREEN);
        line.setStrokeWidth(Breadth);
        line.setStartX(10);
        line.setEndX(Length);
        line.setRotate(0);
        line.setLayoutX(100);
        line.setLayoutY(100);
        line.setFill(Color.TRANSPARENT);
    }

    public Group getFinalSquare() {
        return FinalPlus;
    }
}
