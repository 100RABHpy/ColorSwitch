package sample;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

import java.io.Serializable;

public class BigStar extends Character  implements Serializable {
    private ImageView Star;
    public BigStar(Position initialPosition, ImageView star){
        super(initialPosition);
        Star= star;

    }

    public ImageView getBigStar() {
        return Star;
    }
int check = 1;
    public boolean collide(Ball ball){
        if(check ==1){
        if(this.getBigStar().getOpacity() != 0){
            if((this.getBigStar().getBoundsInParent().intersects(ball.getBall().getBoundsInParent()))){
                check=0;
                return  true;
            }
        }

        }
        return false;
    }
}
