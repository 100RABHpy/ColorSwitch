package sample.Controller;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

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
    int flag=1;
    public void play(){
        if(flag==1){
            AnimationTimer timer1 = new myTimer1();
            timer1.start();
        rotate(image1,110,15);
        rotate(image2,110,15);
        rotate(image3,110,15);
        rotate(image4,110,15);
        rotate(image5,110,15);
        rotate(image6,110,15);
        rotate(image7,70,15);
        rotate(image8,70,15);
        //let(exit,500,15);
        rotate(reload,200,-300);
        flag=0;
        }
    }
    private void rotate(ImageView ss,int time,int angle){
        Timeline t  = new Timeline();

        t.getKeyFrames().add(new KeyFrame(Duration.millis(time),(evt)->{{
            ss.setRotate(ss.getRotate()+angle);
        }}));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
}
    private class myTimer1 extends AnimationTimer {

        @Override
        public void handle(long l) {
            addMusic();
        }
    }
    private MediaPlayer mediaPlayer;
    public void addMusic() {
        Media sound = new Media(getClass().getResource("/sample/resources/Pacman.wav").toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(50));
        mediaPlayer.play();
    }
    public void newGame() {
        sample.Menu.newGame();
    }

    public void reloadPage() throws Exception {
        sample.Menu.resumeGame();
    }

    public void Exit( ) {
        System.exit(0);
    }

}
