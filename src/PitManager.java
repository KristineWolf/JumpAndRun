import de.ur.mi.graphics.Image;
import de.ur.mi.graphics.Rect;
import de.ur.mi.sound.Sound;
import de.ur.mi.util.RandomGenerator;
import world.PitListener;

/**
 * Created by Kristine on 28.11.2015.
 */
public class PitManager implements PitListener {

    /*
     * this class defines the pit of the game and implements the PitListener - Interface and all his method.
     * pit consists of a moving rect.
     * the instance variable ´speed` represents how fast the pit moves.
     */

    int speed;

    Sound fall;
    Rect hole;

    private RandomGenerator random;

    /*
     * constructor of the class PitManager.
     * the width of the pit will be selected arbitrary by the RandomGenerator in the public method createNewPit.
     * and the instance variable speed will be initialize by giving the constructor a value from the outside.
     */

    public PitManager(int speed) {
        this.speed = speed;
        int holeWidth = createNewPit();
        hole = new Rect(Constants.HOLE_X_POS, Constants.HOLE_Y_POS, holeWidth, Constants.HOLE_HEIGHT, Constants.HOLE_COLOR);
    }

    /*
     * this public method returns the next random integer in the specified range and the method passes this value to the outside.
     */

    public int createNewPit() {
        random = RandomGenerator.getInstance();
        int width = random.nextInt(Constants.HOLE_MIN_WIDTH, Constants.HOLE__MAX_WIDTH);
        return width;
    }

    /*
     * this public method moves the pit from the right side to the left side of the screen.
     */

    public void updatePit() {
        hole.move(speed, Constants.HOLE_VELOCITY_Y_POS);
    }

    /*
     * this public method draws the pit.
     */

    public void drawPit() {
        hole.draw();
    }

    /*
     * this public method commits an Image from the outside.
     * afterwards the method checks if the Image and the pit are cutting each other.
     * if they do player falls in pit and the game has to stop. so the method returns the boolean true.
     * otherwise player passes pit and the game moves on.
     */

    public boolean checkIfPlayerFallsInPit(Image playerBounds){

        if (playerBounds.getRightBorder() < hole.getLeftBorder() || playerBounds.getLeftBorder() > hole.getRightBorder() ){
            onPlayerPassesPit();
            return false;
        }
        else{
            onPlayerFallsInPit();
            return true;
        }
    }

    /*
     * this method are from PitListener.
     * on the public method onPlayerFallsInPit: the sound fall.wav will be played.
     */
        @Override
        public void onPlayerFallsInPit () {
            fall = new Sound(Constants.FALL_ADDRESS);
            fall.play();
        }

        @Override
        public void onPlayerPassesPit () {

        }


    }
