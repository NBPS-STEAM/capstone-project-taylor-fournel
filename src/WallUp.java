import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class WallUp extends Rectangle {
    private int count = -1;
    Random random;
    private boolean isHit = false;
    WallUp(int x, int y, int width, int height){
        super(x,y,width,height);
        random = new Random();
    }
    public void draw(Graphics g) {
        g.setColor(Color.green);
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
    public void setisHit(boolean h){
        isHit = h;
    }
    public boolean getisHit(){
        return isHit;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxloc(){
        return x;
    }
    public int getyloc(){
        return y;
    }
    public int getCount(){
        return count;
    }
}
