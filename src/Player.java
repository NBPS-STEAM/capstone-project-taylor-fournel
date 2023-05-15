import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.border.Border;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Player extends JPanel{
        public static int x = 475;
        public int y = 250;
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // drawing code goes here
            g.setColor(Color.white);
            g.fillOval(x,y,50,50);
            g.drawOval(x,y,50,50);
        }
        public static void pressA(){
            x+=1;
        }
        public static void staticPaint(){
            Player obj = new Player();
            obj.paintComponent(obj.getGraphics());
        }
}
class MyKeyListener implements KeyListener {
    public static Boolean M = false;
    public void keyPressed(KeyEvent a) {
        if (a.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("A key pressed!");
            M = true;
        }
    }
    public void keyReleased(KeyEvent a) {
        // Handle key released event
        if (a.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("A key released!");
            M = false;
        }
    }
    public void keyTyped(KeyEvent a) {
        // Handle key typed event

    }
    public static boolean moveA(){
        return M;
    }
}

