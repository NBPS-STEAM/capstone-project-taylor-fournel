import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.border.Border;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
            createAndShowGUI();
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                // Code to be executed every period

            }
        }, 0, 100); //Period is in miliseconds - 1000 = 1 second - 100 = 1/10th of a second
    }


    private static void createAndShowGUI() {
        //Frame
        JFrame jFrame = new JFrame("Capstone Project");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Background
        JPanel Background = new JPanel();
        Background.setBackground(Color.darkGray);
        //Visibility
        jFrame.add(Background);
        jFrame.getContentPane().add(Background);
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
    }
    public static void Player(){

    }
    public static void PlayerCharacter(){

    }
}