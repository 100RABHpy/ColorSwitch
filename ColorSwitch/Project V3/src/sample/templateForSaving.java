package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class templateForSaving implements Serializable {

    private double ballLocation;
    private HashMap<String ,Double> obstacleDetails;
    private int noOfStar;
    private String color;
    public templateForSaving(double ballY,String color,HashMap<String,Double>obsDetail,int noOfStar){
    this.ballLocation = ballY;
    this.noOfStar = noOfStar;
    this.obstacleDetails = obsDetail;
        this.color = color;

    }

    public String getColor() {
        return color;
    }

    public int getNoOfStar() {
        return noOfStar;
    }

    public double getBallLocation() {
        return ballLocation;
    }

    public HashMap<String, Double> getObstacleDetails() {
        return obstacleDetails;
    }
}
