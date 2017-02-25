package brickBreaker;
import javax.swing.*;
/**
 * Created by MrFlyingChip on 25.02.2017.
 */
public class Game {

    public static void StartGame(){
        JFrame obj = new JFrame();
        Gameplay gameplay = new Gameplay();
        obj.setBounds(10, 10, 700, 600);
        obj.setTitle("Break Breaker");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);
    }
}
