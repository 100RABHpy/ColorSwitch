package sample.Controller;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import sample.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GamePlay  implements Initializable, Serializable{
    @FXML
    private Label startGameLabel;
    @FXML
    private Label starCountLabel;
    @FXML
    private Circle ball1;
    @FXML
    private ImageView Star;
    @FXML
    private ImageView BigStar;
    @FXML
    private ListView<String> ListOfSavedGame;
    @FXML
    private Label totalStarCount;
    @FXML
    private Label notEnoughStar;
    @FXML
    private TextField gameNameLabel;
    private Ball ball;
    private sample.ColorChanger colorChanger;
    private sample.Star star;
    private sample.BigStar bigStar;
    private AnimationTimer timer;
    private ArrayList<Obstacle> obstacle = new ArrayList();
    private static ObservableList<String> savedGames;
    private ArrayList<Group> AllObstacle;
    private  int noOfStar=0;
    private double ballY;
    private String ballColor;
    private HashMap<String,Double> obsDetail = new HashMap<String, Double>();
    static int flag =1;
    int check=1;
    public void setObstacle(Obstacle c)
    {
        obstacle.add(c);
    }
    public void listGame() throws InterruptedException {
        savedGames = FXCollections.observableArrayList ("Game1","Game2","Game3");
        ListOfSavedGame.setItems(savedGames);


    }
    public void checkSelectedOption() throws Exception {
            int index = ListOfSavedGame.getSelectionModel().getSelectedIndex();
           templateForSaving loadedGame = (templateForSaving) load(savedGames.get(index));
        System.out.println(loadedGame.getBallLocation());
        System.out.println(loadedGame.getNoOfStar());
        System.out.println(loadedGame.getColor());
        System.out.println(loadedGame.getObstacleDetails().size());
       for(Map.Entry<String,Double> entry: loadedGame.getObstacleDetails().entrySet()){
            System.out.println("key "+ " " +entry.getKey());
           System.out.println("value "+ " " +entry.getValue());
           Menu.reloadFunction(loadedGame.getBallLocation(),loadedGame.getColor(),loadedGame.getObstacleDetails(),loadedGame.getNoOfStar());
        }
    }

    public void start(Ball ball, sample.Star star,BigStar bigStar ,sample.ColorChanger colorChanger, FXMLLoader loader) {
        check=1;
        startGameLabel.setOpacity(100);
        timer = new myTimer();
        timer.start();
        starCountLabel.setText(String.valueOf(noOfStar));
        this.ball = ball;
        this.star = star;
        this.bigStar = bigStar;
        this.colorChanger = colorChanger;

        for (Obstacle o:
                obstacle) {
            if(flag==1) {
                o.rotate(110,15);
            }
            else {
                o.rotate(120,20);
            }
            flag = 1-flag;
        }

        }
    public Circle getBall1(){
            return ball1;
    }
    public Ball getBall(){
        return ball;
    }

    public void bounceBall() throws InterruptedException {
        if(check ==1){
            startGameLabel.setOpacity(0);

            check=0;
        }


        //System.out.println(ball.getY());
        //System.out.println(obstacle.get(0).getObstacle().getLayoutY());
        if(ball.getY()>340)
        {
            int j=0;
            while(j<20)
            {
                ball.setBallVel(0.75);
                ball.setPosition(Math.max(ball.getY()-3,340), ball.getX());
                for (int i = 0; i <obstacle.size() ; i++) {
                    if (!obstacle.get(i).collide(ball)|| ball.getBall().getLayoutY()>740){
//                        System.out.println("no");
                        System.out.println(ball.getY());
                        for (int k=0;k<10000000; k++){

                        }
                        timer.stop();

                        Menu.changeToContinuePage(noOfStar);
                    }
                    if(bigStar.collide(ball)){
                        noOfStar +=5;
                        starCountLabel.setText(Integer.toString(noOfStar));
                        bigStar.getBigStar().setOpacity(0);
                    }
                    if(star.collide(ball)){
                        noOfStar++;
                        starCountLabel.setText(String.valueOf(noOfStar));
                        star.getStar().setOpacity(0);
                    }if(colorChanger.collide(ball)){
                        colorChanger.getColorChanger().setOpacity(0);
                        Paint[] colors = {Color.GREEN,Color.YELLOW,Color.RED,Color.BLUE};
                        Random rand = new Random();
                        int wrongColor=1;
                        while(wrongColor ==1){
                            int randNo =rand.nextInt(4);
                            if(colors[randNo]!=ball.getBall().getFill()){
                                ball.getBall().setFill(colors[randNo]);
                                wrongColor =0;
                            }
                        }

                }
                }
                j++;
            }
        }

        if(ball.getY()<350)
        {
            for (Obstacle o: obstacle) {
                int i=0;
                while(i<20)
                {
                    o.setLayoutY2(o.getLayoutY2()+3);

                    i++;
                }
            }
            int j=0;
            while(j<20)
            {
                bigStar.getBigStar().setLayoutY(bigStar.getBigStar().getLayoutY()+3);
                star.getStar().setLayoutY(star.getStar().getLayoutY()+3);
                colorChanger.getColorChanger().setLayoutY(colorChanger.getColorChanger().getLayoutY()+3);
                j++;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void backToMainMenu( ) {
        Menu.changeToMenu();
    }

    public void newGame( ) {
//        for(int i=0; i<obstacle.size() ; i++  ){
//            obstacle.remove(i);
//        }
        obstacle.clear();

        Menu.changeToGamePage();
    }

    public void  getNameForGame( ) {

        Menu.changeToGetName(ballY,ballColor,obsDetail,noOfStar);
    }

    public ImageView  getBigStar() {
       return BigStar;
    }


//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        if(e.getKeyCode()==32){
//            System.out.println("dsfbgfdvfdc");
//            Menu.changeToPausePage();
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }




    private class myTimer extends AnimationTimer{
        int flagForStar;
        @Override
        public void handle(long l) {
            ball.setPosition(ball.getY() + ball.getBallVel(), ball.getX());
            for (int i = 0; i <obstacle.size() ; i++) {
                if (!obstacle.get(i).collide(ball)|| ball.getBall().getLayoutY()>740){

                    this.stop();
                    for (int k=0;k<10000000; k++){

                    }
                    System.out.println(ball.getY());

                    Menu.changeToContinuePage(noOfStar);
                }
                if(bigStar.collide(ball)){
                    noOfStar +=5;
                    starCountLabel.setText(Integer.toString(noOfStar));
                    bigStar.getBigStar().setOpacity(0);
                }
                if(star.collide(ball)){
                    noOfStar++;
                    star.getStar().setOpacity(0);
                    starCountLabel.setText(String.valueOf(noOfStar));
                }if(colorChanger.collide(ball)){
                    colorChanger.getColorChanger().setOpacity(0);
                    Paint[] colors = {Color.GREEN,Color.YELLOW,Color.RED,Color.BLUE};
                    Random rand = new Random();
                    int wrongColor=1;
                    while(wrongColor ==1){
                        int randNo =rand.nextInt(4);
                        if(colors[randNo]!=ball.getBall().getFill()){
                            ball.getBall().setFill(colors[randNo]);
                            wrongColor =0;
                        }
                    }
                }
            }

            ball.setBallVel(ball.getBallVel()+0.01);
            if(obstacle.get(0).getLayoutY2()>740)
            {   if(flagForStar <2){
                    flagForStar++;
                }
                else if(flagForStar==2){
                    flagForStar=0;
            }
                Obstacle obs = obstacle.get(0);
                obstacle.remove(0);
                obs.setLayoutY2(obstacle.get(obstacle.size()-1).getLayoutY2()-550);
                obstacle.add(obs);
                    if(flagForStar==2){
                        star.getStar().setLayoutY(obs.getObstacle().getLayoutY());
                        star.getStar().setOpacity(100);
                    }
                if(flagForStar==2){
                    colorChanger.getColorChanger().setLayoutY(obs.getObstacle().getLayoutY()-300);
                    colorChanger.getColorChanger().setOpacity(100);

                }

                }

            }

        }


    public ImageView getStar() {
        return Star;
    }

    @FXML
    public  void saveGame() throws  Exception{

        templateForSaving game = new templateForSaving(ballY,ballColor,obsDetail,noOfStar);
        System.out.println("saved "+gameNameLabel.getText());
        save(game, gameNameLabel.getText());
        Menu.changeToMenu();
    }

    public void setBallY(double ballY) {
        this.ballY = ballY;
    }

    public void setBallColor(String ballColor) {
        this.ballColor = ballColor;
    }

    public void setObsDetail(HashMap<String, Double> obsDetail) {
        this.obsDetail = obsDetail;
    }
    //    }
//    public static void reloadGame() throws  Exception{
//        loader.setController((GamePlay)load("Game1"));
//    }

    private static void save(Serializable data, String fileName) throws  Exception{

        ObjectOutputStream str = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
        str.writeObject(data);

    }
    public static Object load( String fileName) throws  Exception{
        ObjectInputStream str = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
        return str.readObject();
    }
    @FXML
    private void pauseGame(){
        if(timer !=null){
            timer.stop();
        }
        for(Obstacle o: obstacle){
            obsDetail.put(o.getType(), o.getLayoutY2());
        }
        System.out.println("gane"+  obsDetail.size());
        Menu.changeToPausePage(ball.getBall().getLayoutY(),ball.getBall().getFill().toString(),obsDetail,noOfStar);
    }

    @FXML
    private void continueGame(){
        Menu.changeToGamePage(noOfStar);
    }
    private void exitGame(){}
    @FXML
    private void restartGame() throws InterruptedException {
        try{
        if(noOfStar>5){
        }
        else{
            throw new NotEnoughStarException();
        }
        }
        catch(NotEnoughStarException e){
            notEnoughStar.setOpacity(100);
            Thread.sleep(500);
            Menu.changeToMenu();
        }

    }

    public Label getNotEnoughStar() {
        return notEnoughStar;
    }

    public void setNoOfStar(int noOfStar) {
        this.noOfStar = noOfStar;
    }

    public void setTotalStarCount(int totalStarCount) {
        this.totalStarCount.setText(String.valueOf(totalStarCount));
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }


    public void setObstacle(ArrayList<Obstacle> obstacle) {
        this.obstacle = obstacle;
    }

    public ArrayList<Obstacle> getObstacle() {
        return obstacle;
    }

    public int getNoOfStar() {
        return noOfStar;
    }
}

