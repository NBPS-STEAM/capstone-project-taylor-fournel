import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Throw extends Rectangle {
    int id;
    public boolean newBall = false;
    static Ball eball;
    int temp1;
    int temp2;

    Throw(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!this.newBall) {
                        this.newBall = true;
                        eball = new Ball(GamePanel.GAME_WIDTH / 2, GamePanel.GAME_HEIGHT / 2, GamePanel.BALL_DIAMETER, GamePanel.BALL_DIAMETER, 2);
                    }
                }
                break;
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (!this.newBall) {
                        this.newBall = true;
                        eball = new Ball(GamePanel.GAME_WIDTH / 2, GamePanel.GAME_HEIGHT / 2, GamePanel.BALL_DIAMETER, GamePanel.BALL_DIAMETER, 1);
                    }
                }
                break;
        }
    }

    public void draw(Graphics g) {
        if (id == 1)
            g.setColor(Color.blue);
        else
            g.setColor(Color.red);

        if (!newBall)
            g.fillOval(x, y, width, height);
        g.drawOval(x, y, width, height);
        if (newBall) {
            this.eball.draw(g);
            this.eball.move();

        }
    }

    public boolean getNewBall() {
        return this.newBall;
    }

    public void setNewBall(boolean newBall) {
        this.newBall = newBall;
    }
}
