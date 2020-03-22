import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Board board;
    private Engine engine;
    private GraphicsContext context;


    private final int windowWidth = 700;
    private final int windowHeight = 700;

    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();
        Canvas canvas = new Canvas(windowWidth, windowHeight);
        context = canvas.getGraphicsContext2D();

        canvas.setFocusTraversable(true);

        board = new Board(windowWidth, windowHeight);
        board.drawBoard(context);

        canvas.setOnKeyPressed(e -> {
            if (engine.isKeyAvailable()){
                Snake snake = board.getSnake();
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
                engine.setKeyAvailable(false);
            }
        });

        root.getChildren().add(canvas);
        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Marcin Bonisławski, 267955 - Snake");
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setScene(scene);
        primaryStage.show();

        engine.startGame();
    }

    public static void main(String[] args) {
        launch(args);
    }
}