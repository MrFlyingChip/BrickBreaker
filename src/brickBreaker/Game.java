package brickBreaker;
import javax.swing.*;
/**
 * Created by MrFlyingChip on 25.02.2017.
 */
public class Game {
    public static final int GAME_WIDTH = 700;
    public static final int GAME_HEIGHT = 600;
    public static final String GAME_TITLE = "Break Breaker";

    private  static  int score;

    public static void StartGame(){
        JFrame obj = new JFrame();
        Gameplay gameplay = new Gameplay(40);
        obj.setBounds(10, 10, GAME_WIDTH, GAME_HEIGHT);
        obj.setTitle(GAME_TITLE);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);
        score = 0;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Game.score = score;
    }
}
