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
    //start ball position
    public static final int BALL_POS_X = 120;
    public static final int BAL__POS_Y = 350;
    //start ball direction
    //direction = speed
    public static final int BALL_X_DIR = -1;
    public static final int BALL_Y_DIR = -2;
    //ball diameter
    public static final int BALL_DIAMETER = 20;
    //start player position
    public static final int PLAYER_X = 310;
    public static final int PLAYER_Y = 550;
    //player size
    public static final int PLAYER_WIDTH = 100;
    public static final int PLAYER_HEIGHT = 8;


    private boolean play = false;
    private int totalBricks;
    private Timer timer;
    private int delay = 8;
    private MapGenerator map;
    private Ball ball;
    private Player player;
    private Controller controller;

    public Gameplay(int totalBricks){
        this.totalBricks = totalBricks;
        map = new MapGenerator(4, 10);
        ball = new Ball(BALL_DIAMETER, BALL_POS_X, BAL__POS_Y, BALL_X_DIR, BALL_Y_DIR);
        player = new Player(PLAYER_X, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT);
        controller = new Controller();
        startLevel();
    }

    private void startLevel(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g){
        //background
        GraphicsController.drawBackground(g);
        //drawing map
        map.draw((Graphics2D)g);
        //borders
        GraphicsController.drawBorders(g);
        //the paddle
        GraphicsController.drawPaddle(g, player);
        //the ball
        GraphicsController.drawBall(g, ball);
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(play){
            if(ball.getBallRect().intersects(player.getPlayerRect())){
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
                            Game.setScore(Game.getScore() + 5);
                            if(ball.getBallRect().x + 19 <= brickRect.x || ball.getBallRect().x + 1 >= brickRect.x + brickRect.width){
                                ball.setNewDirection(-ball.getBallXdir(), ball.getBallYdir());
                            }else{
                                ball.setNewDirection(ball.getBallXdir(), -ball.getBallYdir());
                            }

                        }
                    }
                }
            }
           ball.ballMotion();
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    //method perfom when any key is pressed
    @Override
    public void keyPressed(KeyEvent e) {
        play = true;
        controller.movePlayer(player, e);
    }


    @Override
    public void keyReleased(KeyEvent e) {}
}
