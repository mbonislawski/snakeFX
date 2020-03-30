import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameEngine{

    private Board board;
    private GraphicsContext context;
    private AnimationTimer animator;
    private long lastRefreshTime;
    private boolean keyAvailable = true;

    /***
     * Constructor for class GameEngine
     *
     * @param board Board class object
     * @param context GraphicsContext class object
     */
    public GameEngine(Board board, GraphicsContext context){
        this.board = board;
        this.context = context;
    }

    /***
     * Starting game
     */
    public void startGame(){
        lastRefreshTime = System.currentTimeMillis();
        AnimationTimer animator = new AnimationTimer(){
            @Override
            public void handle(long l) {
                long currentTime = System.currentTimeMillis();
                if ((currentTime-lastRefreshTime)>100){
                    board.drawBoard(context);
                    lastRefreshTime = System.currentTimeMillis();
                    keyAvailable = true;
                }
            }
        };
        animator.start();
    }

    /***
     * Checking if new pressed key can change snake movement direction
     *
     * @return Is key available to press
     */
    public boolean isKeyAvailable(){
        return keyAvailable;
    }

    /***
     * Setting if its possible to use new pressed key
     *
     * @param isAvailable Is available
     */
    public void setKeyAvailable(boolean isAvailable){
        keyAvailable = isAvailable;
    }
}