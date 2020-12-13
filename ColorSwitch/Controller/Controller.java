package sample.Controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Arc;
import javafx.util.Duration;


import java.awt.*;

public class Controller {
    @FXML
    ImageView image1;
    @FXML
    ImageView image2;
    @FXML
    ImageView image3;
    @FXML
    ImageView image4;
    @FXML
    ImageView image5;
    @FXML
    ImageView image6;
    @FXML
    ImageView image7;
    @FXML
    ImageView image8;
    @FXML
    ImageView reload;
    @FXML
    ImageView exit;
    public void play(){
        rotate(image1,110,15);
        rotate(image2,120,20);
        rotate(image3,110,15);
        rotate(image4,120,20);
        rotate(image5,110,15);
        rotate(image6,120,20);
        rotate(image7,70,15);
        rotate(image8,70,15);
        //let(exit,500,15);
        rotate(reload,200,-300);
    }
    private void rotate(ImageView ss,int time,int angle){
        Timeline t  = new Timeline();

        t.getKeyFrames().add(new KeyFrame(Duration.millis(time),(evt)->{{
            ss.setRotate(ss.getRotate()+angle);
        }}));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
}

    public void newGame( ) {
    }
}
