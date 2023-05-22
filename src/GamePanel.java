import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;
    WallUp wallup;
    Wall wall;
    Wall wall2;
    SpeedDownPU speeddown;
    Throw ballthrow1;
    Throw ballthrow2;

    GamePanel(){
        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        newWallUp();
        newWall();
        newWall2();
        newSpeedDown();
        newBallThrow1();
        newBallThrow2();
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        random = new Random();
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER, 0);
    }
    public void newPaddles() {
        paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
        paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
    }
    public void newWallUp(){
        random = new Random();
        wallup = new WallUp(random.nextInt(300,700),random.nextInt(100,300),BALL_DIAMETER * 2,BALL_DIAMETER * 2);
    }
    public void newWall(){
        random = new Random();
        wall = new Wall(random.nextInt(300,700), random.nextInt(100,300), 25, 100);
    }
    public void newWall2(){
        random = new Random();
        wall2 = new Wall(random.nextInt(300,700), random.nextInt(100,300), 25, 100);
    }
    public void newSpeedDown(){
        random = new Random();
        speeddown = new SpeedDownPU(random.nextInt(300,700),random.nextInt(100,300),BALL_DIAMETER * 2,BALL_DIAMETER * 2);
    }
    public void newBallThrow1(){
     ballthrow1 = new Throw(370,20,20,20,1);
    }
    public void newBallThrow2(){
        ballthrow2 = new Throw(600,20,20,20,2);
    }
    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    public void draw(Graphics g) {
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
        if(wallup.getisHit()) {
            wall.setXloc(wallup.getxloc() - 8);
            wall.setYloc(wallup.getyloc());
            wall2.setXloc(wallup.getxloc() + 8);
            wall2.setYloc(wallup.getyloc());
            if (wall.getTime() <= 0) {
                wallup.setisHit(false);
            }
            wall.draw(g);
            wall2.draw(g);
        }
        if(!wallup.getisHit()) {
            wallup.draw(g);
        }
        speeddown.draw(g);
        ballthrow1.draw(g);
        ballthrow2.draw(g);
        Toolkit.getDefaultToolkit().sync(); // I forgot to add this line of code in the video, it helps with the animation

    }
    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }
    public void checkCollision() {

        //bounce ball off top & bottom window edges
        if(ball.y <=0) {
            ball.setYDirection(-ball.yVelocity);
        }
        if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }
        //bounce ball off paddles
        if(ball.intersects(paddle1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; //optional for more difficulty
            if(ball.yVelocity>0)
                ball.yVelocity++; //optional for more difficulty
            else
                ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if(ball.intersects(paddle2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; //optional for more difficulty
            if(ball.yVelocity>0)
                ball.yVelocity++; //optional for more difficulty
            else
                ball.yVelocity--;
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if(wallup.getisHit()){
            if(ball.intersects(wall2)) {
                ball.xVelocity = Math.abs(ball.xVelocity);
                ball.xVelocity++; //optional for more difficulty
                if(ball.yVelocity>0)
                    ball.yVelocity++; //optional for more difficulty
                else
                    ball.yVelocity--;
                ball.setXDirection(ball.xVelocity);
                ball.setYDirection(ball.yVelocity);
            }
            if(ball.intersects(wall)) {
                ball.xVelocity = Math.abs(ball.xVelocity);
                ball.xVelocity++; //optional for more difficulty
                if(ball.yVelocity>0)
                    ball.yVelocity++; //optional for more difficulty
                else
                    ball.yVelocity--;
                ball.setXDirection(-ball.xVelocity);
                ball.setYDirection(ball.yVelocity);
            }
        }
            if (speeddown.canbeHit()) {
                if (ball.intersects(speeddown)) {
                    if(ball.xVelocity>1) {
                        ball.xVelocity--;
                    } else if (ball.xVelocity < -1){
                        ball.xVelocity++;
                    }
                }
            }
        if(wallup.getCount() > 250){
            if(ball.intersects(wallup)){
                wallup.setisHit(true);
            }
        }

        if(ballthrow1.getNewBall() || ballthrow2.getNewBall()){
            if(Throw.eball.y <=0) {
                Throw.eball.setYDirection(-Throw.eball.yVelocity);
            }
            if(Throw.eball.y >= GAME_HEIGHT-BALL_DIAMETER) {
                Throw.eball.setYDirection(-Throw.eball.yVelocity);
            }
            //bounce ball off paddles
            if(Throw.eball.intersects(paddle1)) {
                Throw.eball.xVelocity = Math.abs(Throw.eball.xVelocity);
                Throw.eball.xVelocity++; //optional for more difficulty
                if(Throw.eball.yVelocity>0)
                    Throw.eball.yVelocity++; //optional for more difficulty
                else
                    Throw.eball.yVelocity--;
                Throw.eball.setXDirection(Throw.eball.xVelocity);
                Throw.eball.setYDirection(Throw.eball.yVelocity);
            }
            if(Throw.eball.intersects(paddle2)) {
                Throw.eball.xVelocity = Math.abs(Throw.eball.xVelocity);
                Throw.eball.xVelocity++; //optional for more difficulty
                if(Throw.eball.yVelocity>0)
                    Throw.eball.yVelocity++; //optional for more difficulty
                else
                    Throw.eball.yVelocity--;
                Throw.eball.setXDirection(-ball.xVelocity);
                Throw.eball.setYDirection(ball.yVelocity);
            }
            if(wallup.getisHit()){
                if(Throw.eball.intersects(wall2)) {
                    Throw.eball.xVelocity = Math.abs(ball.xVelocity);
                    Throw.eball.xVelocity++; //optional for more difficulty
                    if(Throw.eball.yVelocity>0)
                        Throw.eball.yVelocity++; //optional for more difficulty
                    else
                        Throw.eball.yVelocity--;
                    Throw.eball.setXDirection(Throw.eball.xVelocity);
                    Throw.eball.setYDirection(Throw.eball.yVelocity);
                }
                if(Throw.eball.intersects(wall)) {
                    Throw.eball.xVelocity = Math.abs(Throw.eball.xVelocity);
                    Throw.eball.xVelocity++; //optional for more difficulty
                    if(Throw.eball.yVelocity>0)
                        Throw.eball.yVelocity++; //optional for more difficulty
                    else
                        Throw.eball.yVelocity--;
                    Throw.eball.setXDirection(-Throw.eball.xVelocity);
                    Throw.eball.setYDirection(Throw.eball.yVelocity);
                }
            }
            if (speeddown.canbeHit()) {
                if (Throw.eball.intersects(speeddown)) {
                    if(Throw.eball.xVelocity>1) {
                        Throw.eball.xVelocity--;
                    } else if (ball.xVelocity < -1){
                        Throw.eball.xVelocity++;
                    }
                }
            }
        }

        //stops paddles at window edges
        if(paddle1.y<=0)
            paddle1.y=0;
        if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
        if(paddle2.y<=0)
            paddle2.y=0;
        if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
        //give a player 1 point and creates new paddles & ball
        if(ball.x <=0) {
            score.player2++;
            newPaddles();
            newBall();
            System.out.println("Player 2: "+score.player2);
        }
        if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
            score.player1++;
            newPaddles();
            newBall();
            System.out.println("Player 1: "+score.player1);
        }
    }
    public void run() {
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks =60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if(delta >=1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
            ballthrow1.keyPressed(e);
            ballthrow2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}
