public class Food {

    private Point point;

    /***
     * Constructor for Food class
     *
     * @param point Point object
     */
    public Food(Point point){
        this.point = point;
    }

    /***
     * Get Food position
     *
     * @return Food Point position
     */
    public Point getPoint() {
        return point;
    }

    /***
     * Setting Food position
     *
     * @param point Point object
     */
    public void setPoint(Point point){
        this.point = point;
    }
}