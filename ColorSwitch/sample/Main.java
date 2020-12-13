package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Collection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent mainPage = FXMLLoader.load(getClass().getResource("resources/startingMenu.fxml"));
        Parent startingGame = FXMLLoader.load(getClass().getResource("resources/mainGame.fxml"));
        Parent pauseGame = FXMLLoader.load(getClass().getResource("resources/pauseGame.fxml"));
        Parent reloadGame = FXMLLoader.load(getClass().getResource("resources/reloadGame.fxml"));
        Parent saveGame = FXMLLoader.load(getClass().getResource("resources/saveGame.fxml"));



        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(mainPage, 480, 740));
//        primaryStage.setScene(new Scene(startingGame, 480, 740));
//        primaryStage.setScene(new Scene(pauseGame, 480, 740));
//        primaryStage.setScene(new Scene(reloadGame, 480, 740));
//        primaryStage.setScene(new Scene(saveGame, 480, 740));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
