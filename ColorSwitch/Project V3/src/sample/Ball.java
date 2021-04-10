package sample;

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

import java.io.Serializable;


public class Ball implements Serializable {
    private Circle ball;
    private double ballVel;
    public Ball(Circle ball)
    {
//        ball = new Circle(240.0f, 600.0f, 10.f);
        this.ball = ball;
        this.ballVel=0;
        ball.setFill(Color.BLUE);
    }
    public Circle getBall()
    {
        return ball;
    }
    public double getX()
    {
        return ball.getLayoutX();
    }
    public double getY()
    {
        return ball.getLayoutY();
    }
    public void setPosition(double y, double x)
    {
        ball.setLayoutX(x);
        ball.setLayoutY(y);
    }
    public Color getColor()
    {
        return (Color) ball.getFill();
    }
    public void setColor(Color c)
    {
        ball.setFill(c);
    }

    public double getBallVel() {
        return ballVel;
    }

    public void setBallVel(double ballVel) {
        this.ballVel = ballVel;
    }

}
