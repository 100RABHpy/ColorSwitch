package sample;

import java.io.Serializable;

public class Character implements Serializable {
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
