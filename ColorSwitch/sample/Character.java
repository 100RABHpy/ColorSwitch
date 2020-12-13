package sample;



public class Character {
    private Position position;

    public Character(Position initialPosition){
        this.position = initialPosition;
    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
