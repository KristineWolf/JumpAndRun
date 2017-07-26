import de.ur.mi.graphics.Image;
import de.ur.mi.graphics.Rect;


/**
 * Created by Kristine on 28.11.2015.
 */
public class Player {

    /*
     * this class defines the player of the "Jump and Run"-game
     * ´isJumping` and `topReached` are both instance variables which represent the characteristics or the condition of the player.
     * ´isJumping`: stands for the condition if player is jumping. if ´isJumping´ is true, player jumps. If ´isJumping´ is false, player does nothing or moves forward or moves back.
     * ´topReached´: if it´s true, player has reached the top of his jump-movement or moves back to his initial condition. if it is false, player is at his initial condition or on his way to the top or moves forward or moves back.
     * the instance Image represents the player.
     * the used Image was croped.
     * the original image: (http://img01.deviantart.net/bd32/i/2014/071/b/0/mulan__mushu_and_crikee_by_vgafanatic-d2c2d9r.jpg)
     */

    boolean isJumping;
    boolean topReached;

    Image playerRect;


    /*
     * constructor of the class Player.
     * the constructor creates the object player.
     * all instance variables and the image are initialize.
     * both instance variables are false because in the initial condition the player doesn´t jump or had reached the top.
     */

    public Player() {
        isJumping = false;
        topReached = false;
        playerRect = new Image(Constants.PLAYER_X_POS, Constants.PLAYER_Y_Pos, Constants.FIGURE_ADDRESS);
    }

    /*
     * this public method represents the jump.
     * this method starts if ´isJumping´ is true in update().
     */

    public void jump() {

        /*
         * ´topReached´ is false till playerRect has reached a specific point
         * playerRect jumps.
         */

        if (topReached == false) {
            if (playerRect.getY() > Constants.PLAYER_JUMP_Y_MIN) {
                playerRect.move(Constants.PLAYER_JUMP_X_POS, Constants.PLAYER_JUMP_Y_SPEED);
            } else {
                topReached = true;
            }
        }

        /*
         * ´topReached` is true. So playerRect moves back to his initial position.
         * and then both instance variables are again false.
         */

        if (topReached == true) {
            if (playerRect.getY() < Constants.PLAYER_Y_Pos) {
                playerRect.move(Constants.PLAYER_JUMP_X_POS, -Constants.PLAYER_JUMP_Y_SPEED);
            } else {
                topReached = false;
                isJumping = false;
            }
        }
    }

    /*
     * with this method you can let playerRect sink after he roams a pit.
     * playerRect sinks down on the left side of the pit.
     * but at first he changes his x position, so that pit and playerRect have the same x value.
     */

    public void sink(Rect pit) {
        if (playerRect.getLeftBorder() != pit.getLeftBorder()){
            playerRect.setPosition(pit.getLeftBorder(), playerRect.getY());
        }
        if (playerRect.getTopBorder() < Constants.CANVAS_HEIGHT){
            playerRect.move(Constants.PLAYER_JUMP_X_POS, Constants.PLAYER_FALL_Y_POS );
        }
    }

    /*
     * with this public method you can draw the object playerRect which represents the player.
     */

    public void draw() {
        playerRect.draw();
    }

    /*
     * with this public method playerRect updates his position.
     * only if `isJumping` is true player has to jump and performs the public method jump().
     */

    public void update() {
        if (isJumping == true) {
            jump();
        }
    }

    /*
     * with this public method playerRect moves back in x direction.
     */

    public void moveLeft(){
        playerRect.move(Constants.PLAYER_MOVE_BACK, Constants.PLAYER_MOVE_Y_POS);
    }

    /*
     * with this public method playerRect moves forward in x direction.
     */

    public void moveRight(){
        playerRect.move(Constants.PLAYER_MOVE_FORWARD, Constants.PLAYER_MOVE_Y_POS);
    }
}
