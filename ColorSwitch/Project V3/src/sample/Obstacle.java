package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.Serializable;

public abstract class Obstacle extends Character implements Serializable {
    private float speed;
    private static int ObstacleIDGenerator=0;
    private final int ObstacleID;
    public Obstacle(Position initialPosition){
        super(initialPosition);
        ObstacleIDGenerator++;
        ObstacleID = ObstacleIDGenerator;

    }

    public int getObstacleID() {
        return ObstacleID;
    }


    public abstract Group getObstacle();
    public abstract String getType();
    public boolean collide(Ball ball) {
        for (Node path: this.getObstacle().getChildren()){
            if (((Path) Shape.intersect(ball.getBall(), (Line)path)).getElements().size()>0){
               return ball.getBall().getFill().equals(((Line) path).getFill());
            }

        }
        return true;
    }
    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    public void setLayoutY2(double y){
        this.getObstacle().setLayoutY(y);

    }
    public double getLayoutY2(){
        return this.getObstacle().getLayoutY();

    }
    public void rotate(int time, int angle){
        Timeline t  = new Timeline();
        t.getKeyFrames().add(new KeyFrame(Duration.millis(time),(evt)->{{
            (this).getObstacle().setRotate((this).getObstacle().getRotate()+angle);
        }}));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }
}
