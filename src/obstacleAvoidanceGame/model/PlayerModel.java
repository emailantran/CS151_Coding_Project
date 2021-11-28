package obstacleAvoidanceGame.model;

public class PlayerModel {
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private int score;

    /**
     * Constructor for the PlayerModel class
     * @param xPos X position for the Player Model
     * @param yPos Y position for the Player Model
     * @param width Width of the Player Model
     * @param height Height of the Player Model
     */
    public PlayerModel (int xPos, int yPos, int width, int height, int score) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.score = score;
        
    }

    /**
     * @return xPos
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * @return yPos
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * Changes the y position by change amount
     * @param change amount of y cordinates to move the blocks position up or down
     */
    public void setyPos(int change){
        yPos += change;
    }

    /**
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return height
     */
    public int getHeight() {
        return height;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }
    }