package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import sample.Controller.GamePlay;

import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu extends Application implements Serializable {
    private static Stage stage;
    private static Parent startingGame;
    private static Scene Menu;
    private static Scene MainGame;
    private static Scene PauseGame;
    private static Scene ReloadGame;
    private static Scene SaveGame;
    private static Scene ContinueGame;
    private static FXMLLoader loader;
    private static FXMLLoader loader2;
    private static FXMLLoader loader3;
    private static FXMLLoader loaderPause;
    private  int noOfStar;

    public static void changeToPausePage(double ballY, String s, HashMap<String, Double> obsDetail, int noOfStar) {
        GamePlay cont = loaderPause.getController();
        cont.setBallY(ballY);
        cont.setObsDetail(obsDetail);
        cont.setNoOfStar(noOfStar);
        cont.setBallColor(s);
        System.out.println(obsDetail.size());
        System.out.println(ballY);
        System.out.println(noOfStar);
        stage.setScene(PauseGame);

    }

    public static void changeToMenu() {
        stage.setScene(Menu);
    }

    public static void changeToContinuePage(int noOfStar) {
        GamePlay c = loader2.getController();
        c.setTotalStarCount(noOfStar);
        c.setNoOfStar(7);
        c.getNotEnoughStar().setOpacity(0);
        stage.setScene(ContinueGame);
    }

    public static void changeToGetName(double ballY, String ballColor, HashMap<String, Double> obsDetail, int noOfStar) {
       GamePlay cont = loader3.getController();
       cont.setBallY(ballY);
       cont.setObsDetail(obsDetail);
       cont.setNoOfStar(5);
       cont.setBallColor(ballColor);
        System.out.println(ballY);
        System.out.println(noOfStar);
        stage.setScene(SaveGame);
    }




    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent mainPage = FXMLLoader.load(getClass().getResource("resources/startingMenu.fxml"));
//        startingGame = FXMLLoader.load(getClass().getResource("resources/mainGame.fxml"));
        loader = new FXMLLoader();
        loader.setLocation(Menu.class.getResource("resources/mainGame.fxml"));
         startingGame = loader.load();
        loader2 = new FXMLLoader();
        loader2.setLocation(Menu.class.getResource("resources/continueGame.fxml"));
        loader3= new FXMLLoader();
        loader3.setLocation(Menu.class.getResource("resources/saveGame.fxml"));
        loaderPause= new FXMLLoader();
        loaderPause.setLocation(Menu.class.getResource("resources/pauseGame.fxml"));
        Parent pauseGame = loaderPause.load();
        Parent reloadGame = FXMLLoader.load(getClass().getResource("resources/reloadGame.fxml"));
        Parent saveGame = loader3.load();
        Parent continueGame =  loader2.load();
        primaryStage.setTitle("Color Switch");
        Menu =new Scene(mainPage, 480, 740);
        PauseGame =new Scene(pauseGame, 480, 740);
        ReloadGame =new Scene(reloadGame, 480, 740);
        SaveGame =new Scene(saveGame, 480, 740);
        ContinueGame = new Scene(continueGame,480,740);
        stage.setScene(Menu);
        primaryStage.show();
        primaryStage.setResizable(false);
        // serializable test

//        try {
////            Score score = new Score();
////            score.setHighScore(-20);
////            saveScore(score,"Score.save");
//            Score score = (Score) loadScore("Score.save");
//            System.out.println(score.getHighScore());
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        //end
    }
//    public void saveScore(Serializable data, String fileName) throws  Exception{
//
//            ObjectOutputStream str = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
//            str.writeObject(data);
//
//    }
//    public Object loadScore( String fileName) throws  Exception{
//
//        ObjectInputStream str = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
//        return str.readObject();
//    }

    public int getNoOfStar() {
        return noOfStar;
    }

    public void setNoOfStar(int noOfStar) {
        this.noOfStar = noOfStar;
    }
    public static void newGame(){
        changeToGamePage();
    }
    public static  void resumeGame() throws Exception {
        changeToReloadPage();
    }
    public void Exit(){
        //pending
    }
    public static void changeToGamePage()
    {

        Group group = new Group();
        CircleObstacle c1 = new CircleObstacle(50, new Position(90,100));
        SquareObstacle s1 = new SquareObstacle(new Position(90,-300),10);
        Plus p1 = new Plus(new Position(50,-700),80,10);
        InsideCircle inside = new InsideCircle(new Position(90,-1100));
        NotInsideCircles notInside = new NotInsideCircles(new Position(90,-1500),10);
        Group plusObstacle = p1.getObstacle();
        Group squareObstacle = s1.getObstacle();
        Group group1 = c1.getObstacle();
        GamePlay cont = loader.getController();
        Ball ball = new Ball(cont.getBall1());
        ball.getBall().setLayoutY(580);
        Star star = new Star(new Position(1,2),cont.getStar());
        star.getStar().setLayoutY(-650);
        BigStar bigStar = new BigStar(new Position(1,2),cont.getBigStar());
        bigStar.getBigStar().setLayoutY(-1650);
        ColorChanger colorChanger = new ColorChanger(new Position(90,-50),10);
        group.getChildren().addAll(startingGame,group1,squareObstacle,plusObstacle, ball.getBall(),star.getStar(),bigStar.getBigStar(),colorChanger.getColorChanger(),notInside.getObstacle(),inside.getObstacle());
        MainGame = new Scene(group, 480, 740);
        stage.setScene(MainGame);
        cont.setObstacle(c1);
        cont.setObstacle(s1);
        cont.setObstacle(p1);
        cont.setObstacle(notInside);
        cont.setObstacle(inside);
        cont.start(ball,star,bigStar,colorChanger,loader);
    }
    public static void changeToGamePage(int noOfStar)
    {

        Group group = new Group();
        CircleObstacle c1 = new CircleObstacle(50, new Position(90,100));
        SquareObstacle s1 = new SquareObstacle(new Position(90,-300),10);
        Plus p1 = new Plus(new Position(50,-700),80,10);
        InsideCircle inside = new InsideCircle(new Position(90,-1100));
        NotInsideCircles notInside = new NotInsideCircles(new Position(90,-1500),10);
        Group plusObstacle = p1.getObstacle();
        Group squareObstacle = s1.getObstacle();
        Group group1 = c1.getObstacle();
        GamePlay cont = loader.getController();
        Ball ball = new Ball(cont.getBall1());
        ball.getBall().setLayoutY(580);
        Star star = new Star(new Position(1,2),cont.getStar());
        star.getStar().setLayoutY(-650);
        BigStar bigStar = new BigStar(new Position(1,2),cont.getBigStar());
        bigStar.getBigStar().setLayoutY(-1650);
        ColorChanger colorChanger = new ColorChanger(new Position(90,-50),10);
        group.getChildren().addAll(startingGame,group1,squareObstacle,plusObstacle, ball.getBall(),star.getStar(),bigStar.getBigStar(),colorChanger.getColorChanger(),notInside.getObstacle(),inside.getObstacle());
        MainGame = new Scene(group, 480, 740);
        stage.setScene(MainGame);
        cont.setObstacle(c1);
        cont.setObstacle(s1);
        cont.setObstacle(p1);
        cont.setObstacle(notInside);
        cont.setObstacle(inside);
        cont.setNoOfStar(noOfStar);
        cont.start(ball,star,bigStar,colorChanger,loader);
    }
    public static void reloadFunction(double ballY,String ballColor,HashMap<String,Double>obsDetail,int noOfStar){
        Group group = new Group();
        GamePlay cont = loader.getController();
        cont.setNoOfStar(noOfStar);
        Ball ball = new Ball(cont.getBall1());
        ball.getBall().setLayoutY(ballY);
        ball.getBall().setFill(Paint.valueOf(ballColor));
        CircleObstacle c1 = new CircleObstacle(50, new Position(90,100));
        SquareObstacle s1 = new SquareObstacle(new Position(90,-300),10);
        Plus p1 = new Plus(new Position(50,-700),80,10);
        InsideCircle inside = new InsideCircle(new Position(90,-1100));
        NotInsideCircles notInside = new NotInsideCircles(new Position(90,-1500),10);
        Group plusObstacle = p1.getObstacle();
        Group squareObstacle = s1.getObstacle();
        Group group1 = c1.getObstacle();
        BigStar bigStar = new BigStar(new Position(1,2),cont.getBigStar());
        bigStar.getBigStar().setLayoutY(-1650);
        for(Map.Entry<String,Double>entry: obsDetail.entrySet()){
            if(entry.getKey() == "Circle"){
                 c1 = new CircleObstacle(50, new Position(90,entry.getValue()));
                    group1 = c1.getObstacle();
            }
            else if(entry.getKey() == "Inside"){
              inside = new InsideCircle(new Position(90,-1500));

            }
            else if(entry.getKey() == "NotInside"){
                 notInside = new NotInsideCircles(new Position(90,entry.getValue()),10);

            }
            else if(entry.getKey() == "Square"){
               s1 = new SquareObstacle(new Position(90, entry.getValue()),10);
               squareObstacle = s1.getObstacle();
            }
            if(entry.getKey() == "Plus"){
               p1 = new Plus(new Position(50, entry.getValue()),80,10);
                plusObstacle = p1.getObstacle();
            }

        }

        Star star = new Star(new Position(1,2),cont.getStar());
        star.getStar().setLayoutY(-650);
        ColorChanger colorChanger = new ColorChanger(new Position(90,-50),10);
        group.getChildren().addAll(startingGame,group1,squareObstacle,plusObstacle, ball.getBall(),star.getStar(),bigStar.getBigStar(),colorChanger.getColorChanger(),notInside.getObstacle(),inside.getObstacle());
        MainGame = new Scene(group, 480, 740);
        stage.setScene(MainGame);
        cont.setObstacle(c1);
        cont.setObstacle(s1);
        cont.setObstacle(p1);
        cont.setObstacle(notInside);
        cont.setObstacle(inside);
        cont.start(ball,star,bigStar,colorChanger,loader);
    }
    public static void changeToReloadPage(){

        stage.setScene(ReloadGame);
    }
    public static Object load( String fileName) throws  Exception{
        ObjectInputStream str = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
        return str.readObject();
    }
    static  double obstacleLocation =400;
//    public static void alignComponent(Group obs){
//        obs.setLayoutX(90);
//        obs.setLayoutY(obstacleLocation-300);
//        obstacleLocation = obs.getLayoutY();
//    }
    public static void main(String[] args) {
        launch(args);
    }
}
