import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameEngine {

    private Board board;
    private GraphicsContext context;
    private long lastRefreshTime;
    private boolean canMove = true;

    /***
     * Constructor for class GameEngine
     *
     * @param board Board class object
     * @param context GraphicsContext class object
     */
    public GameEngine(Board board, GraphicsContext context) {
        this.board = board;
        this.context = context;
    }

    /***
     * Start game
     */
    public void startGame() {
        lastRefreshTime = System.currentTimeMillis();
        AnimationTimer animator = new AnimationTimer(){
            @Override
            public void handle(long l) {
                long currentTime = System.currentTimeMillis();
                if ((currentTime-lastRefreshTime)>100){
                    board.drawBoard(context);
                    lastRefreshTime = System.currentTimeMillis();
                    canMove = true;
                }
            }
        };
        animator.start();
    }

    /***
     * Check if pressed key can change snake direction
     *
     * @return can press button
     */
    public boolean canMove() {
        return canMove;
    }

    /***
     * Switch canMove
     *
     * @param canSnakeMove Is available
     */
    public void setCanMove(boolean canSnakeMove) {
        canMove = canSnakeMove;
    }
}