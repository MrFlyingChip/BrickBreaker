package brickBreaker;

import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;

/**
 * Created by MrFlyingChip on 25.02.2017.
 */
public class Controller {
    //buttons for left and right directions
    private static  final int LEFT = KeyEvent.VK_LEFT;
    private static  final int RIGHT = KeyEvent.VK_RIGHT;
    //measure of moving the paddle with one key pressed
    public static final  int PLAYER_SPEED = 20;


    //method that changes the x position of the paddle
    public void movePlayer(Player player, KeyEvent e){
        //direction of moving: 0 - no direction
        //1 - right, -1 - left
        int dir = 0;
        int playerX = player.getPlayerX();
        //checking the buttons that were pressed
        switch (e.getKeyCode()){
            case LEFT:
                //left border
                if(playerX <= 0){
                    playerX = 0;
                }else {
                    dir = -1;
                }
                break;
            case RIGHT:
                //right border
                if(playerX >= (Game.GAME_WIDTH - Gameplay.PLAYER_WIDTH)){
                    playerX = Game.GAME_WIDTH - Gameplay.PLAYER_WIDTH;
                }else {
                    dir = 1;
                }
                break;
        }
        playerX += dir * PLAYER_SPEED;
        player.setPlayerRect(playerX);
    }


}
