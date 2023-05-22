import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

public class Ball extends Rectangle{

    Random random;
    int xVelocity;
    int yVelocity;
    int initialSpeed = 2;
    int id = 0;

    Ball(int x, int y, int width, int height, int i){
        super(x,y,width,height);
        random = new Random();
        int randomXDirection = random.nextInt(2);
        if(randomXDirection == 0)
            randomXDirection--;
        setXDirection(randomXDirection*initialSpeed);

        int randomYDirection = random.nextInt(2);
        if(randomYDirection == 0)
            randomYDirection--;
        setYDirection(randomYDirection*initialSpeed);
        this.id = i;
    }

    public void setXDirection(int randomXDirection) {
        xVelocity = randomXDirection;
    }
    public void setYDirection(int randomYDirection) {
        yVelocity = randomYDirection;
    }
    public void move() {
        x += xVelocity;
        y += yVelocity;
    }
    public void draw(Graphics g) {
        if(id == 0) {
            g.setColor(Color.white);
        } else if (id == 1) {
            g.setColor(Color.blue);
        } else {
            g.setColor(Color.red);
        }

        g.fillOval(x, y, height, width);
    }
}