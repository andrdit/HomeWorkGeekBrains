import java.awt.*;
import java.util.Random;

public class Background {

    private Color color;
    private Random rnd = new Random();

    private long timeToChangeColor;
    private long lastChangeTime;

    Background(){
        this.color = new Color(255,255,255); // default color
        timeToChangeColor = (long) (5 / 0.000000001f); // set change color every 5 sec
      //timeToChangeColor = (long) (Math.random() * 10 / 0.000000001f);  // random time to change color, don't use
        lastChangeTime = System.nanoTime();
    }

    public void setColorBk(float lasTime){

        if(System.nanoTime() - lastChangeTime > timeToChangeColor){
            color = new Color(rnd.nextInt());
            lastChangeTime = System.nanoTime();
        }
    }

    public Color getColor() {
        return color;
    }
}
