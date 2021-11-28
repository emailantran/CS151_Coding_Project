package obstacleAvoidanceGame.model;

public class PlayerModel {
	private int xPos;
    private int yPos;
    private int width;
    private int height;
    private int score;
    
    // part of Singleton Pattern
    private static PlayerModel pm = new PlayerModel(230,100,100,100,10);
    
    

    /**
     * Private Constructor for the PlayerModel class (part of Singleton Pattern)
     * @param xPos X position for the Player Model
     * @param yPos Y position for the Player Model
     * @param width Width of the Player Model
     * @param height Height of the Player Model
     */
    private PlayerModel (int xPos, int yPos, int width, int height, int score) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.score = score;
        
    }
    
    /**
     * Returns the already constructed PlayerModel (part of Singleton Pattern)
     */
    public static PlayerModel getPM() {
    	return pm;
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