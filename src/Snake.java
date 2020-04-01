import java.util.LinkedList;
import java.util.List;

public class Snake {

    Point point;
    private List<Point> points_list;
    private int x_direction;
    private int y_direction;

    public Snake(Point point) {
        points_list = new LinkedList<>();
        points_list.add(point);
        this.point = point;
    }

    /***
     * Get current score
     *
     * @return Current score
     */
    public int getScore() {
        int score = points_list.size() - 1;
        return score;
    }

    /***
     * Get list of Points in the snake
     *
     * @return list of points in the snake
     */
    public List<Point> getPointsList() {
        return points_list;
    }

    /***
     * Snake move UP
     */
    public void setDirUp() {
        if (y_direction == 1 && points_list.size() > 1) {
            return;
        }
        x_direction = 0;
        y_direction = -1;
    }

    /***
     * Snake move DOWN
     */
    public void setDirDown() {
        if (y_direction == -1 && points_list.size() > 1) {
            return;
        }
        x_direction = 0;
        y_direction = 1;
    }

    /***
     * Snake move LEFT
     */
    public void setDirLeft() {
        if (x_direction == 1 && points_list.size() > 1) {
            return;
        }
        x_direction = -1;
        y_direction = 0;
    }

    /***
     * Snake move RIGHT
     */
    public void setDirRight() {
        if (x_direction == -1 && points_list.size() > 1) {
            return;
        }
        x_direction = 1;
        y_direction = 0;
    }

    /***
     * Move snake towards next point based on directions
     */
    public void moveSnake() {
        for (int i = points_list.size() - 1; i >= 1; i--) {
            points_list.get(i).setPoint(points_list.get(i - 1));
        }
        points_list.get(0).movePoint(x_direction, y_direction);
    }

    /***
     * Add point to the Snake
     *
     * @param point Point
     */
    public void growSnake(Point point) {
        points_list.add(point);
    }

    /***
     * Checking snake's points collision
     *
     * @return has collision
     */
    public boolean checkItselfCollision() {
        for (int i = 0; i < points_list.size(); i++) {
            for (int j = i + 1; j < points_list.size(); j++) {
                if (points_list.get(i).getPosX() == points_list.get(j).getPosX() && points_list.get(i).getPosY() == points_list.get(j).getPosY()) {
                    return true;
                }
            }
        }
        return false;
    }
}