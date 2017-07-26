import de.ur.mi.graphics.Line;
import de.ur.mi.graphics.Rect;

/**
 * Created by Kristine on 26.11.2015.
 */
public class Ground {

    /*
     * this class defines the ground of the game.
     * the ground consists of a rect and a line.
     */

    private Rect rect;
    private Line line;

    /*
     * the objects are initialized in the constructor.
     */

    public Ground(){
        rect = new Rect( Constants.GROUND_RECT_X_POS, Constants.GROUND_RECT_Y_POS, Constants.GROUND_RECT_WIDTH, Constants.GROUND_RECT_HEIGHT, Constants.GROUND_RECT_COLOR);
        line = new Line ( Constants.GROUND_LINE_FIRST_X_POS, Constants.GROUND_LINE_FIRST_Y_POS, Constants.GROUND_LINE_SECOND_X_POS, Constants.GROUND_LINE_SECOND_Y_POS, Constants.GROUND_LINE_COLOR);
    }

    /*
     * with this public method you can draw the ground.
     */

    public void draw(){
        line.setBorderWeight(Constants.LINE_BORDER_WEIGHT);
        rect.draw();
        line.draw();
    }

}
