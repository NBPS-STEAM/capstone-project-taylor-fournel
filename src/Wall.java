import java.awt.*;
import java.util.Random;

public class Wall extends Rectangle {
    Random random = new Random();
    public int time = 2000;
    Wall(int x, int y, int width, int height){
        super(x,y,width,height);
    }
    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        if(time <= 0) {
            time = 2000;
        }
        if(time > 0){
            g.fillRect(x, y, 25, 100);
        }
        time--;
    }
    public int getTime(){
        return time;
    }
    public void setXloc(int x2){
        x = x2;
    }
    public void setYloc(int y2){
        y = y2;
    }
    public int getYloc(){
        return y;
    }
    public int getXloc(){
        return x;
    }
}
