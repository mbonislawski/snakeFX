import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private Board gameBoard;
    private GameEngine gameEngine;
    private GraphicsContext context;

    private final int screenWidth = 600;
    private final int screenHeight = 600;


    public static void main(String[] args) {
        launch(args);
    }

    /***
     * Overriding JavaFx method (start)
     *
     * @param primaryStage stage
     */
    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        context = canvas.getGraphicsContext2D();

        canvas.setFocusTraversable(true);

        gameBoard = new Board(screenWidth,screenHeight);
        gameEngine = new GameEngine(gameBoard,context);
        gameBoard.drawBoard(context);

        canvas.setOnKeyPressed(e -> {
            if (gameEngine.canMove()){
                Snake snake = gameBoard.getSnake();
                switch (e.getCode()) {
                    case UP:
                        snake.setDirUp();
                        break;
                    case DOWN:
                        snake.setDirDown();
                        break;
                    case LEFT:
                        snake.setDirLeft();
                        break;
                    case RIGHT:
                        snake.setDirRight();
                        break;
                }
                gameEngine.setCanMove(false);
            }
        });

        root.getChildren().add(canvas);
        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Snake - 267955");
        primaryStage.setOnCloseRequest(e -> System.exit(0));

        // draw placeholder screen with button to start the game
        VBox mainLayout = new VBox(175);
        Scene menuScene = new Scene(mainLayout, screenWidth, screenHeight);
        String style = "-fx-background-color: rgb(0, 0, 0);";
        mainLayout.setStyle(style);

        Button startBtn = new Button("START");
        startBtn.setMaxSize(100, 200);
        startBtn.setOnAction(event -> primaryStage.setScene(scene));

        mainLayout.getChildren().add(startBtn);
        mainLayout.setAlignment(Pos.CENTER);

        primaryStage.setScene(menuScene);
        primaryStage.show();

        gameEngine.startGame();
    }
}