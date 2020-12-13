package sample.Controller;

import com.sun.prism.Image;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class mainGameController {
    @FXML
    Circle ball;
    @FXML
    ImageView c1;
    @FXML
    ImageView c2;
    @FXML
    Label startGameLabel;
    @FXML
    Label starCountLabel;
    int flag =1;
    public void startGame( ) {
        if(flag ==1){
        rotate(c1,50,15);
        rotate(c2,50,15);
        flag=0;
        }
        startGameLabel.setOpacity(0);
        bounceBall();
    }

    public void bounceBall( ) {
        ball.setFill(Color.YELLOW);
        ball.setLayoutY(ball.getLayoutY()-10);
    }
    private void rotate(javafx.scene.image.ImageView ss, int time, int angle){
        Timeline t  = new Timeline();

        t.getKeyFrames().add(new KeyFrame(Duration.millis(time),(evt)->{{
            ss.setRotate(ss.getRotate()+angle);
        }}));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }
}
