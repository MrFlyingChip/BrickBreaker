package brickBreaker;

import java.awt.*;

/**
 * Created by MrFlyingChip on 25.02.2017.
 */
public class GraphicsController {
    public static final Color BACKGROUND_COLOR = Color.black;
    public static final Color PADDLE_COLOR = Color.green;
    public static final Color BALL_COLOR = Color.yellow;
    public static final Color BORDER_COLOR = Color.yellow;

    public static void drawBackground(Graphics g){
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
    }

    public static void drawPaddle(Graphics g, Player player){
        g.setColor(PADDLE_COLOR);
        g.fillRect(player.getPlayerX(), player.getPlayerY(), player.getPlayerWidth(), player.getPlayerHeight());
    }

    public static void drawBall(Graphics g, Ball ball){
        g.setColor(BALL_COLOR);
        g.fillOval(ball.getBallXpos(), ball.getBallYpos(), ball.getBallDiameter(), ball.getBallDiameter());
    }

    public static void drawBorders(Graphics g){
        g.setColor(BORDER_COLOR);
        g.fillRect(0,0, 3, 592);
        g.fillRect(0,0, 692, 3);
        g.fillRect(691,0, 3, 592);
    }

}
