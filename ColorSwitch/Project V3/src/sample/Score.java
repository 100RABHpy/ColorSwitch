package sample;

import javafx.collections.ObservableList;

import java.io.Serializable;

public class Score  implements Serializable {
    private static int noOfStar;
    private static  int HighScore;
    private static ObservableList<String> savedGames;
    public int getHighScore() {
        return HighScore;
    }

    public ObservableList<String> getSavedGames() {
        return savedGames;
    }

    public void setSavedGames(ObservableList<String> savedGames) {
        Score.savedGames = savedGames;
    }

    public int getNoOfStar() throws NotEnoughStarException{
        return noOfStar;
    }

    public void setHighScore(int highScore) {
        HighScore = highScore;
    }

    public void setNoOfStar(int noOfStar) {
        this.noOfStar = noOfStar;
    }


}
