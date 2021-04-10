package sample;

public class NotEnoughStarException extends Exception{
    public NotEnoughStarException(){

    }  public NotEnoughStarException(String s){
        System.out.println(s);
    }

}