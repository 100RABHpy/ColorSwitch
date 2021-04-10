package sample;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.Serializable;

import static java.lang.Thread.sleep;

public class CircleObstacle extends Obstacle implements Serializable {
    private float radius;
    private double degree;
    private Group FinalCircle;
    private Shape path;
    private Shape path2;
    private Shape path3;
    private Shape path4;
    private Circle c2;
    private String type = "Circle";
    public String getType() {
        return type;
    }
    public CircleObstacle(double Radius, Position position){
        super(position);
        this.degree = 0;
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
        c2 = new Circle();
        c2.setRadius(Radius);
        c2.setCenterX(50d);
        c2.setCenterY(50d);
        c2.setLayoutX(100);
        c2.setLayoutY(100);
        path = Path.subtract(arc1, c2);
        path2 = Path.subtract(arc2, c2);
        path3 = Path.subtract(arc3, c2);
        path4 = Path.subtract(arc4, c2);
        path.setFill(Color.BLUE);
        path2.setFill(Color.GREEN);
        path3.setFill(Color.RED);
        path4.setFill(Color.YELLOW);
        this.FinalCircle  = new Group();
        FinalCircle.getChildren().addAll(path,path2,path3,path4);
        FinalCircle.setLayoutX(getPosition().getX());
        FinalCircle.setLayoutY(getPosition().getY());
    }
    public Color getColor(Shape path)
    {
        return (Color) path.getStroke();
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public Circle getC2() {
        return c2;
    }

    public float getRadius() {
        return radius;
    }
    public void setRadius(float radius) {
        this.radius = radius;
    }
    private void createArc(Arc arc) {
        arc.setStroke(Color.GREEN);
        arc.setStrokeWidth(20);
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


    public Group getObstacle() {
        return this.FinalCircle;
    }

    @Override
    public boolean collide(Ball ball) {
        int i =0;
        for (Node path: this.getObstacle().getChildren()){
        if (((Path) Shape.intersect(ball.getBall(), (Path)path)).getElements().size()>0){
            i++;
            System.out.println(ball.getBall().getFill() );
            System.out.println(((Path)path).getFill());
            System.out.println(i);
            return ball.getBall().getFill().equals(((Path) path).getFill());
        }
    }
        return true;
    }


}
