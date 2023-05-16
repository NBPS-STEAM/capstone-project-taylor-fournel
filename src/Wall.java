import java.awt.*;
import java.util.Random;

public class Wall extends Rectangle {
    Random random = new Random();
    private int xloc = 500;
    private int yloc = 200;
    Wall(int x, int y, int width, int height){
        super(x,y,width,height);
        xloc = x;
        yloc = y;
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillRect(xloc, yloc, 10, 100);
    }
}
