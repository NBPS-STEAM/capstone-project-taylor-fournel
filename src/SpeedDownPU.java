import java.awt.*;
import java.util.Random;

public class SpeedDownPU extends Rectangle{
    private int count = -1;
    Random random;
    SpeedDownPU(int x, int y, int width, int height){
        super(x,y,width,height);
        random = new Random();
    }
    public void draw(Graphics g) {
        g.setColor(Color.cyan);
        if(count <= 0) {
            count = random.nextInt(250, 1000);
            x = random.nextInt(300,700);
            y = random.nextInt(100,300);

        }
        if(count > 250){
            g.fillOval(x, y, width, height);
        }
        count--;
    }
    public boolean canbeHit(){
        if(count>500){
            return true;
        }
        else{
            return false;
        }
    }
}
