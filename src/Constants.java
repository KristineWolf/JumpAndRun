import de.ur.mi.graphics.Color;

/**
 * Created by Kristine on 28.11.2015.
 */
public class Constants {

    /*
     * this constants comprise important values to create the canvas.
     */

    public static final int CANVAS_WIDTH = 1421;
    public static final int CANVAS_HEIGHT = 800;
    public static final int FRAME_RATE = 60;
    public static final int SMOOTH_NUM = 4;

    /*
     * this is the background image which is used in `JumpAndRun`- class.
     * Image: (http://hdhintergrundbilder.net/image/fantasie/666/klippen-wasserfalle-baume-fluss-sonne-sonnenuntergang-650x366.jpg)
     */

    public static final int IMAGE_X_POS = 0;
    public static final int IMAGE_Y_POS = 0;
    public static final String IMAGE_ADDRESS = "data/assets/background.png";

    /*
     * this is the background sound which was formed and cut.
     * original Sound: (https://www.youtube.com/watch?v=rqZbR16Qs1o).
     */

    public static final String PLAY_MUSIC = "/data/assets/playmusic.wav";

    /*
     * this constants comprise important values for the Ground-class.
     * the first ones for the rect and the last ones for the line.
     * both colors were found on an internet-site: (http://www.farb-tabelle.de/de/farbtabelle.htm#brown)
     */

    public static final int GROUND_RECT_WIDTH = CANVAS_WIDTH;
    public static final int GROUND_RECT_HEIGHT = 280;
    private static final Color KAHAKI = new Color (139, 134, 78);
    public static final Color GROUND_RECT_COLOR = KAHAKI;
    public static final int GROUND_RECT_X_POS = 0;
    public static final int GROUND_RECT_Y_POS = 520;

    public static final int GROUND_LINE_FIRST_X_POS = 0;
    public static final int GROUND_LINE_FIRST_Y_POS = 520;
    private static final Color DARK_OLIVE_GREEN = new Color (85, 107, 47);
    public static final Color GROUND_LINE_COLOR = DARK_OLIVE_GREEN;
    public static final int GROUND_LINE_SECOND_X_POS = 1421;
    public static final int GROUND_LINE_SECOND_Y_POS = 520;
    public static final int LINE_BORDER_WEIGHT = 5;

    /*
     * this constants comprise important values for the Player-class.
     */

    public static final String FIGURE_ADDRESS = "data/assets/figure.png";
    public static final int PLAYER_X_POS = 200;
    public static final int PLAYER_Y_Pos = 370;
    public static final double PLAYER_JUMP_X_POS = 0;
    public static final double PLAYER_JUMP_Y_MIN = 170;
    public static final double PLAYER_JUMP_Y_SPEED = -2;
    public static final int PLAYER_FALL_Y_POS = 3;
    public static final int PLAYER_MOVE_BACK = -10;
    public static final int PLAYER_MOVE_Y_POS = 0;
    public static final int PLAYER_MOVE_FORWARD = 10;

    /*
     * this constants comprise important values for the PitManager-class.
     * the Color Grey was found on an internet-site: (http://www.farb-tabelle.de/de/farbtabelle.htm#brown).
     */

    public static final int HOLE__MAX_WIDTH = 100;
    public static final int HOLE_MIN_WIDTH = 50;
    public static final int HOLE_HEIGHT = 300;
    public static final Color GREY = new Color(33, 33, 33);
    public static final Color HOLE_COLOR = GREY;
    public static final int HOLE_X_POS = 1421;
    public static final int HOLE_Y_POS = 518;
    public static final int HOLE_VELOCITY_X_POS = -2;
    public static final double HOLE_VELOCITY_Y_POS = 0;
    public static final String FALL_ADDRESS = "/data/assets/fall.wav";

    /*
     * this constants comprise important values for the keyPressed-Event.
     */

    public static final int KEY_SPACE = 32;
    public static final int KEY_ENTER = 10;
    public static final int KEY_RIGHT = 39;
    public static final int KEY_LEFT = 37;

    /*
     * this constants comprise important values for the game display.
     */

    public static final int LABEL_X_POS = 100;
    public static final int LABEL_Y_POS = 50;
    public static final String LABEL = "JumpAndRun";
    public static final int LABEL_THICKNESS = 50;
    public static final int LEVEL_X_POS = 1150;
    public static final int LEVEL_Y_POS = 50;
    public static final String LEVEL = "Level: ";
    public static final int MINUS_TWO_LEVEL = 2;
    public static final int LEVEL_THICKNESS = 30;

    /*
     * this constants comprise important values for the end of the game: Game Over!.
     */

    public static final int LEFT_END_OF_GAME = 0;
    public static final int BOTTOM_END_OF_GAME = 800;

    public static final Color GAME_OVER_BACKGROUND_COLOR = Color.BLACK;
    public static final Color GAME_OVER_COLOR = Color.RED;
    public static final Color PRESS_ENTER_COLOR = Color.WHITE;
    public static final int GAME_OVER_X_POS = 480;
    public static final int GAME_OVER_Y_POS = 300;
    public static final int GAME_OVER_THICKNESS = 70;
    public static final String GAME_OVER = "Game Over!";
    public static final int PRESS_ENTER_X_POS = 550;
    public static final int PRESS_ENTER_Y_POS = 350;
    public static final int PRESS_ENTER_THICKNESS = 20;
    public static final String PRESS_ENTER = "Press ENTER for new Game";

    /*
     * this constant comprise the address of the jump sound.
     */

    public static final String JUMP_ADDRESS = "/data/assets/jump.wav";


}
