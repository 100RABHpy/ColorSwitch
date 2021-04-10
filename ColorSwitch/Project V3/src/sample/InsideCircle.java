package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.Serializable;

public class InsideCircle extends Obstacle implements Serializable {
    private Group insideCircle;
    private String type = "Inside";

    public String getType() {
        return type;
    }

    public InsideCircle(Position initialPosition){
        super(initialPosition);
        CircleObstacle c1 = new CircleObstacle(50,new Position(90,initialPosition.getY()));
        CircleObstacle c2 = new CircleObstacle(70,new Position(90,initialPosition.getY()));
        c1.getObstacle().setRotate(c1.getObstacle().getRotate()+40);
        insideCircle = new Group();
        insideCircle.getChildren().addAll(c1.getObstacle(),c2.getObstacle());


    }
    @Override
    public void setLayoutY2(double y){
        for(Node circle : this.getObstacle().getChildren()){
            circle.setLayoutY(y);

        }

    }
    @Override
    public double getLayoutY2(){
        return this.getObstacle().getChildren().get(0).getLayoutY();

    }
    @Override
    public Group getObstacle() {
        return insideCircle;
    }
    @Override
    public boolean collide(Ball ball) {
        //for c1
        boolean c1 = false;
        boolean c2 = true;
        int flag = 1;
        for (Node grp : this.getObstacle().getChildren()) {
            Group a = (Group) grp;
            for (Node path : a.getChildren()) {
                if (((Path) Shape.intersect(ball.getBall(), (Path) path)).getElements().size() > 0) {
                    if (flag == 1) {
                        c1 = ball.getBall().getFill().equals(((Path) path).getFill());
                        flag = 0;
                    } else if (flag == 0) {
                        c2 = ball.getBall().getFill().equals(((Path) path).getFill());
                    }
                }
            }

            if (c1 && c2) {
                if (!c1) {
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public void rotate(int time, int angle){
        int incrementFactor =0;
        for(Node c :this.getObstacle().getChildren()){
            Timeline t  = new Timeline();
            t.getKeyFrames().add(new KeyFrame(Duration.millis(time+incrementFactor),(evt)->{{
                ((Group)c).setRotate(((Group)c).getRotate()+angle);
            }}));
            t.setCycleCount(Timeline.INDEFINITE);
            t.play();
            incrementFactor +=60;
        }
    }
}

