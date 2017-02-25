package brickBreaker;

import java.awt.*;

/**
 * Created by MrFlyingChip on 25.02.2017.
 */
public class Ball {
    private Rectangle ballRect;
    private int ballXpos;
    private int ballYpos;
    private int ballXdir;
    private int ballYdir;
    private int ballDiameter;

    public int getBallXpos() {
        return ballXpos;
    }

    public int getBallYpos() {
        return ballYpos;
    }

    public int getBallXdir() {
        return ballXdir;
    }

    public int getBallYdir() {
        return ballYdir;
    }

    public int getBallDiameter() {
        return ballDiameter;
    }

    public Ball(int diameter, int positionX, int positionY, int Xdir, int Ydir){
        ballRect = new Rectangle(positionX, positionY, diameter, diameter);
        ballDiameter = diameter;
        ballXpos = positionX;
        ballYpos = positionY;
        ballXdir = Xdir;
        ballYdir = Ydir;
    }

    public void setBallRect(int newX, int newY){
        ballRect = new Rectangle(newX, newY, ballRect.width, ballRect.height);
        ballXpos = newX;
        ballYpos = newY;
    }

    public Rectangle getBallRect(){
        return ballRect;
    }

    public void setNewDirection(int newXdir, int newYdir){
        ballXdir = newXdir;
        ballYdir = newYdir;
    }

    public void ballMotion(){
        ballXpos += ballXdir;
        ballYpos += ballYdir;
        setBallRect(ballXpos, ballYpos);
    }


}
