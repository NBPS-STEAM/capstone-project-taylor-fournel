import java.awt.*;
import java.util.Random;

public class Wall extends Rectangle {
    Wall(int x, int y, int width, int height){
        super(x,y,width,height);
    }
    public void draw(Graphics g, int x, int y){
        g.setColor(Color.white);
        g.drawRect(x,y, 10, 100);
    }
}
