public class Point {

    private int pos_x;
    private int pos_y;

    /***
     * Constructor for Point class
     *
     * @param x X position of point
     * @param y Y position of point
     */
    Point(int x, int y) {
        this.pos_x = x;
        this.pos_y = y;
    }

    /***
     * Get X position of point
     *
     * @return X position value
     */
    public int getPosX() {
        return pos_x;
    }

    /***
     * Get Y position of point
     *
     * @return Y position value
     */
    public int getPosY() {
        return pos_y;
    }

    /***
     * Update point with a new Point object
     *
     * @param point New point
     */
    public void setPoint(Point point) {
        pos_x = point.getPosX();
        pos_y = point.getPosY();
    }

    /***
     * Change point position by value
     *
     * @param dx Shift in X
     * @param dy Shift in Y
     */
    public void movePoint(int dx, int dy) {
        pos_x = pos_x + dx;
        pos_y = pos_y + dy;
    }

    /***
     * Checking if points coordinates are the same
     *
     * @param point Point to compare
     * @return Has the same cords
     */
    public boolean isEqual(Point point) {
        return (point.getPosX() == this.pos_x) && (point.getPosY() == this.pos_y);
    }

    /***
     * Checking if point position is in range
     *
     * @param fromX Min X position
     * @param fromY Min Y position
     * @param toX Max X position
     * @param toY Max Y position
     * @return Is in window
     */
    public boolean inWindow(int fromX, int fromY, int toX, int toY) {
        return pos_x >= fromX && pos_x <= toX && pos_y >= fromY && pos_y <= toY;
    }
}