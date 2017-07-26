import de.ur.mi.graphics.Image;
import de.ur.mi.graphics.Label;
import de.ur.mi.graphicsapp.GraphicsApp;
import de.ur.mi.sound.Sound;

import java.awt.event.KeyEvent;

/**
 * Created by Alexander Bazo on 06/11/15.
 *
 * Sounds in data.assets:
 *  Jump-Sound by Mike Koenig (http://soundbible.com/1601-Mario-Jumping.html)
 *  Fall-Sound by mind_noise (https://archive.org/details/WilhelmScreamSample)
 */
public class JumpAndRun extends GraphicsApp {

    /*
     * in this class will be the whole game arranged.
     * at first the declaration of the other classes, the background Image and Sound and the two instance variables.
     */

    Image landscape;
    Ground ground;
    Player player;
    PitManager pitManager;

    Sound playMusic;
    int speed;
    boolean isRunning;


    @Override
    public void setup() {
        setupCanvas();
        startGame();
    }

    /*
     * this method defines the playing area.
     */

    private void setupCanvas() {
        size(Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT);
        frameRate(Constants.FRAME_RATE);
        smooth(Constants.SMOOTH_NUM);
    }

    /*
     * this method initializes the instance variables and the objects.
     */

    private void startGame() {
        isRunning = true;
        ground = new Ground();
        player = new Player();
        speed = Constants.HOLE_VELOCITY_X_POS;
        pitManager = new PitManager(speed);
        landscape = new Image(Constants.IMAGE_X_POS, Constants.IMAGE_Y_POS, Constants.IMAGE_ADDRESS);
        playMusic = new Sound(Constants.PLAY_MUSIC);
        playMusic.loop();

    }

    public void draw() {
        /*
         * this has to be drawn every time.
         */

        landscape.draw();
        ground.draw();
        pitManager.drawPit();
        player.draw();
        drawLabel();

        /*
         * this method will only be executed if the game is running.
         */

        gameIsRunning();

        /*
         * this method will only be executed if the game is over.
         */

        gameIsOver();
    }


    private void gameIsRunning(){
        /*
         * till the game is running the pit is moving from right to left.
         * and with player.update() the runtime is checking if ´isJumping` is true. ´isJumping´ is true if someone presses the Space-button.
         * and if ´isJumping` is true player starts to jump.
         * if pit has left the display an new pitManager will be created with an higher speed.
         * when player is not jumping the runtime always checks if pit and player are cutting each other and if this happens the game stops and is over.
         */

        if(isRunning == true) {
            pitManager.updatePit();
            player.update();
            if (pitManager.hole.getRightBorder() < Constants.LEFT_END_OF_GAME) {
                speed--;
                pitManager = new PitManager(speed);
            }
            if (player.isJumping == false) {
                if (pitManager.checkIfPlayerFallsInPit(player.playerRect) == true) {
                    isRunning = false;
                }
            }
        }
    }

    /*
     * if the game is over player sinks.
     * and after player has left the display the runtime ´draws´ gameOver();
     */

    private void gameIsOver(){
        if (isRunning == false) {
            player.sink(pitManager.hole);
            if (player.playerRect.getY() > Constants.BOTTOM_END_OF_GAME){
                gameOver();
            }
        }
    }

    /*
     * this method defines the Level display.
     */

    private void drawLabel() {
        Label label = new Label(Constants.LABEL_X_POS, Constants.LABEL_Y_POS, Constants.LABEL, Constants.GREY, Constants.LABEL_THICKNESS);
        label.draw();
        Label level = new Label(Constants.LEVEL_X_POS, Constants.LEVEL_Y_POS, Constants.LEVEL + (-(speed + Constants.MINUS_TWO_LEVEL) ), Constants.GREY, Constants.LEVEL_THICKNESS);
        level.draw();
    }

    /*
     * this method will be selected if the game is over.
     * after this you can press Enter to start a new game.
     */

    private void gameOver() {
        background(Constants.GAME_OVER_BACKGROUND_COLOR);
        Label gameOver = new Label(Constants.GAME_OVER_X_POS, Constants.GAME_OVER_Y_POS, Constants.GAME_OVER, Constants.GAME_OVER_COLOR, Constants.GAME_OVER_THICKNESS);
        Label pressEnter = new Label(Constants.PRESS_ENTER_X_POS, Constants.PRESS_ENTER_Y_POS, Constants.PRESS_ENTER, Constants.PRESS_ENTER_COLOR, Constants.PRESS_ENTER_THICKNESS);
        gameOver.draw();
        pressEnter.draw();
        playMusic.stop();

    }


    @Override
    public void keyPressed(KeyEvent e) {
        /*
         * this only happens if the game is running and if player is not Jumping.
         */
        if (isRunning == true) {
            if (e.getKeyCode() == Constants.KEY_SPACE) {
                if (player.isJumping == false) {
                    Sound jump = new Sound(Constants.JUMP_ADDRESS);
                    jump.play();
                    player.isJumping = true;
                }
            }
            if(e.getKeyCode() == Constants.KEY_LEFT){
                if(player.isJumping == false){
                    player.moveLeft();
                }
            }
            if(e.getKeyCode() == Constants.KEY_RIGHT){
                if(player.isJumping == false){
                    player.moveRight();
                }
            }
        /*
         * if the game is over you can start a new game with pressing Enter.
         */
            
        } else {
            if (e.getKeyCode() == Constants.KEY_ENTER) {
                pitManager.hole.setPosition(Constants.HOLE_X_POS, Constants.HOLE_Y_POS);
                setup();
            }
        }

    }
}
