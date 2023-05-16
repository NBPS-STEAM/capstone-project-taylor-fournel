import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class WallUp extends Rectangle {
    private int count = -1;
    Random random;
    private int x;
    private int y;
    WallUp(int x, int y, int width, int height){
        super(x,y,width,height);
        random = new Random();
    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        if(count <= 0) {
            count = random.nextInt(1000);
            x = random.nextInt(300,700);
            y = random.nextInt(100,300);

        }
        if(count > 250){
            g.fillOval(x, y, width, height);
        }
        count--;
    }
}
