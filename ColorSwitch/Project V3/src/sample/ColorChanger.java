package sample;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import sample.Character;
import sample.Position;

import java.io.Serializable;

public class ColorChanger extends Character implements Serializable {

    private float radius;
    private Group ColorChanger;

    public ColorChanger(Position initialPosition,float radius) {
        super(initialPosition);
        this.radius = radius;
        Arc arc1 = new Arc();
        Arc arc2 = new Arc();
        Arc arc3 = new Arc();
        Arc arc4 = new Arc();
        createArc(arc1,Color.GREEN);
        createArc(arc2,Color.YELLOW);
        arc2.setStartAngle(180);
        createArc(arc3,Color.BLUE);
        arc3.setStartAngle(270);
        createArc(arc4,Color.RED);
        arc4.setStartAngle(0);
        this.ColorChanger = new Group();
       ColorChanger.getChildren().addAll(arc1,arc2,arc3,arc4);
       ColorChanger.setLayoutX(getPosition().getX());
       ColorChanger.setLayoutY(getPosition().getY());
    }
    private void createArc(Arc arc, Paint color) {
        arc.setRadiusX(this.radius);
        arc.setRadiusY(this.radius);
        arc.setLayoutX(100);
        arc.setLayoutY(100);
        arc.setStartAngle(90);
        arc.setLength(130);
        arc.setFill(color);
        arc.setCenterX(50d);
        arc.setCenterY(50d);
    }

    public Group getColorChanger() {
        return ColorChanger;
    }


    public boolean collide(Ball ball){
       // System.out.println("fsdfds");
        if(this.getColorChanger().getOpacity()!=0){
        for (Node path: this.getColorChanger().getChildren()){
            if (((Path) Shape.intersect(ball.getBall(), (Arc)path)).getElements().size()>0){
                return true;
            }
        }
        }
        return false;

    }
}
