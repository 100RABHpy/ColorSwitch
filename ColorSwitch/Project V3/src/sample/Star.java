package sample;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

import java.io.Serializable;

public class Star extends Character  implements Serializable {
    private ImageView Star;
    public Star(Position initialPosition, ImageView star){
        super(initialPosition);
       Star= star;

    }

    public ImageView getStar() {
        return Star;
    }

    public boolean collide(Ball ball){
        if(this.getStar().getOpacity() != 0){
        if((this.getStar().getBoundsInParent().intersects(ball.getBall().getBoundsInParent()))){
            return  true;
        }
        }
      return false;
    }
}
