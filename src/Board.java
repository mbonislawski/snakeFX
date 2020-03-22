import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Board {
    private int colsNr;
    private int rowsNr;

    private int mapHeight;
    private int mapWidth;

    private int pointSize = 10;

    private Food food;
    private Snake snake;

    /*** Konstruktor klasy Board
    * @param width - szerokosc okna gry
    * @param height - wysokosc okna gry
    */
    public Board(int width, int height) {
        // ustawienie parametrow
        this.mapHeight = height;
        this.mapWidth = width;

        // stworzenie siatki planszy
        colsNr = width / pointSize;
        rowsNr = height / pointSize;

        // utworzenie węża
        snake = new Snake(new Square(colsNr / 2, rowsNr / 2));

        // utworzenie elementu do zjedzenia
        food = new Food(new Square(getRandomPointPosition(colsNr), getRandomPointPosition(rowsNr)));
    }

    public void drawBoard(GraphicsContext context) {

        updateBoard();

        // ustawienie parametrów tła
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, this.mapWidth, this.mapHeight);

        // rysowanie znacznika jedzenia
        context.setFill(Color.GREEN);
        int foodPosX = food.getSquare().getX();
        int foodPosY = food.getSquare().getY();
        context.fillRect(foodPosX, foodPosY, this.pointSize, this.pointSize);

        // rysowanie węża
        context.setFill(Color.WHITE);

        for (Square point : snake.getSquaresList()) {
            int topLeftX = point.getX() * pointSize;
            int topLeftY = point.getY() * pointSize;
            context.fillRect(topLeftX, topLeftY, pointSize, pointSize);
        }
        context.setFill(Color.WHITE);
    }

    private Integer getRandomPointPosition(int max) {
        Random random = new Random();
        // numer z przedzialu 0 - wys/szer mapy z uwzględnieniem że nie może być poza pierwszą kolumną
        int i = random.nextInt(max - 1) * pointSize;
        return i;
    }

    public Snake getSnake() {
        return snake;
    }

    /***
     * Method updates snake position and checks if snake didn't collide with a wall or collide with itself
     */
    public void updateBoard() {
        snake.moveSnake();
    }
}
