import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
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
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int playerX = 250;
        int playerY = 250;
        createAndShowGUI();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                // Code to be executed every period
                if (MyKeyListener.moveA()){
                    Player.pressA();
                }
                Player.staticPaint();
            }
        }, 0, 100); //Period is in miliseconds - 1000 = 1 second - 100 = 1/10th of a second
    }


    private static void createAndShowGUI() {
        //Frame
        JFrame jFrame = new JFrame("Capstone Project");
        jFrame.setSize(1000, 1000);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Background
        JPanel Background = new JPanel();
        Background.setBackground(Color.darkGray);
        //Player
        SwingUtilities.invokeLater(Player::new);
        jFrame.addKeyListener(new MyKeyListener());
        //Visibility
        jFrame.add(Background);
        jFrame.getContentPane().add(Background);
        jFrame.setVisible(true);
    }
}