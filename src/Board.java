import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Board {
    private int rows_nr;
    private int cols_nr;
    private int windowWidth;
    private int windowHeight;
    private int dot_size = 20;

    private Snake snake;
    private Food food;

    /***
     * Constructor for Board class
     *
     * @param width Width of window screen
     * @param height Height of window screen
     */
    public Board(int width, int height) {
        // Setting board size
        this.windowWidth = width;
        this.windowHeight = height;

        // Getting number of rows and columns needed to create board
        rows_nr = height / dot_size;
        cols_nr = width / dot_size;

        // Add snake in the center of the map
        snake = new Snake(new Point(rows_nr / 2, cols_nr / 2));

        // Add Food in random position
        food = new Food(new Point(getRandomInt(cols_nr), getRandomInt(rows_nr)));
    }

    /***
     * Draw board with objects
     *
     * @param context JavaFX GraphicsContext object
     */
    public void drawBoard(GraphicsContext context) {

        refreshBoard();

        // Draw window
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, this.windowWidth, this.windowHeight);

        // Draw food
        context.setFill(Color.RED);
        int paint_food_x = food.getPoint().getPosX() * dot_size;
        int paint_food_y = food.getPoint().getPosY() * dot_size;
        context.fillRect(paint_food_x, paint_food_y, dot_size, dot_size);

        // Draw snake
        context.setFill(Color.GREEN);
        for (Point point : snake.getPointsList()) {
            int paint_snake_x = point.getPosX() * dot_size;
            int paint_snake_y = point.getPosY() * dot_size;
            context.fillRect(paint_snake_x, paint_snake_y, dot_size, dot_size);
        }
        context.setFill(Color.WHITE);
        context.fillText("Score : " + snake.getScore(), windowWidth - 80, dot_size * 1.5);
    }

    /***
     * Reset Snake and Food object to start a new game
     */
    public void resetBoard() {
        // create Snake
        snake = new Snake(new Point(cols_nr / 2, rows_nr / 2));

        // Create Food
        food = new Food(new Point(getRandomInt(cols_nr), getRandomInt(rows_nr)));
    }

    /***
     * Get Snake object
     *
     * @return Snake object
     */
    public Snake getSnake() {
        return snake;
    }


    /***
     * Update snake position and look for collision
     */
    public void refreshBoard() {
        snake.moveSnake();
        if (snake.getPointsList().get(0).isEqual(food.getPoint())) {
            snake.growSnake(food.getPoint());
            food.setPoint(createPoint());
        } else if (!snake.getPointsList().get(0).inWindow(0, 0, rows_nr - 1, cols_nr - 1)) {
            resetBoard();
        } else if (snake.checkItselfCollision()) {
            resetBoard();
        }
    }

    /***
     * Create random Point object which is not part of the snake
     *
     * @return Point with random cords
     */
    private Point createPoint() {
        outerLoop:
        while (true) {
            int randX = getRandomInt(rows_nr);
            int randY = getRandomInt(cols_nr);

            for (Point point : snake.getPointsList()) {
                if (randX == point.getPosX() && randY == point.getPosY()) {
                    continue outerLoop;
                }
            }
            return new Point(randX, randY);
        }
    }

    /***
     * Get random number
     *
     * @param max number
     * @return Random number from 0 to max
     */
    private Integer getRandomInt(int max) {
        Random random = new Random();
        int i = random.nextInt(max);
        return i;
    }
}