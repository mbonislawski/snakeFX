import java.util.LinkedList;
import java.util.List;

public class Snake {
    Square square;
    private List<Square> listOfSquares;

    // kierunki ruchów
    private int xDir;
    private int yDir;

    public Snake(Square square) {
        listOfSquares = new LinkedList<>();
        listOfSquares.add(square);
        this.square = square;
    }

    public List<Square> getSquaresList() {
        return listOfSquares;
    }

    /***
     * Setting snake direction to move UP
     */
    public void setDirUp() {
        if (yDir == 1 && listOfSquares.size() > 1) {
            return;
        }
        xDir = 0;
        yDir = -1;
    }

    /***
     * Setting snake direction to move DOWN
     */
    public void setDirDown() {
        if (yDir == -1 && listOfSquares.size() > 1) {
            return;
        }
        xDir = 0;
        yDir = 1;
    }

    /***
     * Setting snake direction to move LEFT
     */
    public void setDirLeft() {
        if (xDir == 1 && listOfSquares.size() > 1) {
            return;
        }
        xDir = -1;
        yDir = 0;
    }

    /***
     * Setting snake direction to move RIGHT
     */
    public void setDirRight() {
        if (xDir == -1 && listOfSquares.size() > 1) {
            return;
        }
        xDir = 1;
        yDir = 0;
    }

    /***
     * Move snake towards next point based on directions
     */
    public void moveSnake() {
        for (int i = listOfSquares.size() - 1; i >= 1; i--) {
            listOfSquares.get(i).setPosition(listOfSquares.get(i - 1));
        }
        listOfSquares.get(0).shiftPosition(xDir, yDir);
    }

    /***
     * Extending Snake points list by point
     *
     * @param square Point of extension
     */
    public void extendSnake(Square square) {
        listOfSquares.add(square);
    }
}
