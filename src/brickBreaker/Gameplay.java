package brickBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by MrFlyingChip on 21.02.2017.
 */
public class Gameplay extends JPanel implements KeyListener, ActionListener{
    private static final int ballPosX = 120;
    private static final int ballPosY = 350;
    private static final int ballXdir = -1;
    private static final int ballYdir = -2;
    private static final int ballDiameter = 20;

    private boolean play = false;
    private int score = 0;
    private int totalBricks = 21;
    private Timer timer;
    private int delay = 8;
    private int playerX = 310;
    private MapGenerator map;
    private Ball ball;
    public Gameplay(){
        map = new MapGenerator(3, 7);
        ball = new Ball(ballDiameter, ballPosX, ballPosY, ballXdir, ballYdir);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){
        //background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);
        //drawing map
        map.draw((Graphics2D)g);

        //borders
        g.setColor(Color.yellow);
        g.fillRect(0,0, 3, 592);
        g.fillRect(0,0, 692, 3);
        g.fillRect(691,0, 3, 592);

        //the paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100, 8);

        //the ball
        g.setColor(Color.yellow);
        g.fillOval(ball.getBallXpos(), ball.getBallYpos(), ball.getBallDiameter(), ball.getBallDiameter());

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();

        if(play){
            if(ball.getBallRect().intersects(new Rectangle(playerX, 550, 100, 8))){
                ball.setNewDirection(ball.getBallXdir(), -ball.getBallYdir());
            }

            for(int i = 0; i < map.map.length; i++){
                for (int j = 0; j < map.map[0].length; j++){
                    if(map.map[i][j] > 0){
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;
                        int brickX = j * map.brickWidth + 80;
                        int brickY = i * map.brickHeight + 50;

                        Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);

                        if(ball.getBallRect().intersects(brickRect)){
                            map.setBrickValue(0, i, j);
                            totalBricks--;
                            score += 5;


                        }


                    }
                }
            }
           ball.ballMotion();
            if((ball.getBallXpos() <  0) || (ball.getBallXpos() > 670)){
                ball.setNewDirection(-ball.getBallXdir(), ball.getBallYdir());
            }
            if(ball.getBallYpos() < 0){
                ball.setNewDirection(ball.getBallXdir(), -ball.getBallYdir());
            }

        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(playerX >= 600){
                playerX = 600;
            }else{
                moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(playerX < 10){
                playerX = 10;
            }else{
                moveLeft();
            }
        }
    }

    public void moveRight() {
        play = true;
        playerX += 20;
    }

    public void moveLeft() {
        play = true;
        playerX -= 20;
    }
    @Override
    public void keyReleased(KeyEvent e) {}
}
