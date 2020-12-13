package sample;

public class Obstacle extends Character {
    private float speed;
    public Obstacle(Position intialPosition){
        super(intialPosition);

    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
