public class Square {
    private int posX;
    private int posY;

    /*** Konstruktor klasy Square
     * @param x - współrzędna x punktu
     * @param y - współrzędna y punktu
     */
    Square(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    /***
     * Getting X value of point
     *
     * @return X point value
     */
    public int getX() {
        return posX;
    }

    /***
     * Getting Y value of point
     *
     * @return Y point value
     */
    public int getY() {
        return posY;
    }

    /***
     * Updating point by new Point object
     *
     * @param square New point
     */
    public void setPosition(Square square) {
        posX = square.getX();
        posY = square.getY();
    }

    /***
     * Shifting point position by dx and dy value
     *
     * @param changeX Shift in X
     * @param changeY Shift in Y
     */
    public void shiftPosition(int changeX, int changeY) {
        posX = posX + changeX;
        posY = posY + changeY;
    }
}
