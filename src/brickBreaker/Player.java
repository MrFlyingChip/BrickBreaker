package brickBreaker;

import java.awt.*;

/**
 * Created by MrFlyingChip on 25.02.2017.
 */
public class Player {
    private Rectangle playerRect;
    private int playerX;
    private int playerY;
    private int playerWidth;
    private int playerHeight;

    public Player(int playerX, int playerY, int playerWidth, int playerHeight) {
        this.playerX = playerX;
        this.playerY = playerY;
        this.playerWidth = playerWidth;
        this.playerHeight = playerHeight;
        playerRect = new Rectangle(playerX, playerY, playerWidth, playerHeight);
    }

    public Rectangle getPlayerRect() {
        return playerRect;
    }

    public int getPlayerY() {
        return playerY;
    }

    public int getPlayerWidth() {
        return playerWidth;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerRect(int newX) {
        playerX = newX;
        this.playerRect = new Rectangle(playerX, playerY, playerWidth, playerHeight);
    }
}
