package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import static java.lang.Thread.sleep;

public class CircleObstacle {
    private float radius;
    private Group FinalCircle;
//    private Shape path;
//    private Shape path2;
//    private Shape path3;
//    private Shape path4;
    public CircleObstacle(){}
    public CircleObstacle(double Radius){
        this.radius =(float)Radius;
        Arc arc1 = new Arc();
        Arc arc2 = new Arc();
        Arc arc3 = new Arc();
        Arc arc4 = new Arc();
        createArc(arc1);
        createArc(arc2);
        arc2.setStartAngle(180);
        createArc(arc3);
        arc3.setStartAngle(270);
        createArc(arc4);
        arc4.setStartAngle(0);
        Circle c2 = new Circle();
        c2.setRadius(Radius);
        c2.setCenterX(50d);
        c2.setCenterY(50d);
        c2.setLayoutX(100);
        c2.setLayoutY(100);
        Shape path = Path.subtract(arc1, c2);
        Shape path2 = Path.subtract(arc2, c2);
        Shape path3 = Path.subtract(arc3, c2);
        Shape  path4 = Path.subtract(arc4, c2);
        path.setFill(Color.BLUE);
        path2.setFill(Color.GREEN);
        path3.setFill(Color.RED);
        path4.setFill(Color.YELLOW);
        this.FinalCircle  = new Group();
        FinalCircle.getChildren().addAll(path,path2,path3,path4);
    }

    public float getRadius() {
        return radius;
    }
    public void setRadius(float radius) {
        this.radius = radius;
    }
    private void createArc(Arc arc) {
        arc.setStroke(Color.GREEN);
        arc.setStrokeWidth(10);
        arc.setRadiusX(this.radius+2);
        arc.setRadiusY(this.radius+2);
        arc.setLayoutX(100);
        arc.setLayoutY(100);
        arc.setStartAngle(90);
        arc.setLength(90);
        arc.setFill(Color.TRANSPARENT);
        arc.setCenterX(50d);
        arc.setCenterY(50d);
    }

    public Group getCircle() {
        return this.FinalCircle;
    }
}
