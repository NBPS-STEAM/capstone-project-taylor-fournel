import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class WallUp extends Rectangle {
    private int count;
    Random random;
    WallUp(int x, int y, int width, int height){
        super(x,y,width,height);
        random = new Random();
    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, width, height);
    }
    public void Count(Graphics g){
        if(count <= 0){
            count = random.nextInt(1000);
            new Wall(random.nextInt(100, 300), random.nextInt(100,300), width, height);
        }
        if(count < 250){
            this.move(1000, 1000);
        }
    }
}
