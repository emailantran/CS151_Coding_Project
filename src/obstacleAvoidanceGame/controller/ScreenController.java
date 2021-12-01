package obstacleAvoidanceGame.controller;

import obstacleAvoidanceGame.DifficultyLevel;
import obstacleAvoidanceGame.message.*;

import obstacleAvoidanceGame.model.PlayerModel;
import obstacleAvoidanceGame.model.Wall;
import obstacleAvoidanceGame.view.ScreenView;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 *  This class will act as the Controller class between the screens (view) and the game logic (model)
 *
 *  Aggregates queue, playerModel, walls in a ArrayList, and ScreenView
 *  	-reads messages from queue to proccess and change ScreenView
 *  	-playerModel and walls used to display and check for collision between the two
 */
public class ScreenController {
    BlockingQueue<Message> queue;
    PlayerModel playerModel;
    ArrayList<Wall> walls;
    ScreenView screenView;
    private DifficultyLevel difficulty = DifficultyLevel.NORMAL;


    /*
     * Arrays of dimensions of walls to check with player's position
     */
    int[] wallsX;
    int[] wallsY;
    int[] wallsWidth;
    int[] wallsHeight;

    /*
     * set score to 0 at start
     */
    int score = 0;

    /*
     *  constructor that initializes all the view and model classes for the controller to work with
     */
    public ScreenController(BlockingQueue<Message> queue, ScreenView screenView, PlayerModel playerModel, ArrayList<Wall> walls) {
        this.queue = queue;
        this.playerModel = playerModel;
        this.walls = walls;
        this.screenView = screenView;

        this.wallsX = new int[walls.size()];
        this.wallsY = new int[walls.size()];
        this.wallsWidth = new int[walls.size()];
        this.wallsHeight = new int[walls.size()];
    }

    /*
     * mainLoop to initialize game
     */
    public void mainLoop() {

        while (screenView.isDisplayable()) {
            Message message = null;
            try {
                message = queue.take();
            } catch (InterruptedException exception) {
                //nothing
            }

            if (message.getClass() == StartGameMessage.class) {
                for (int i = 0; i < walls.size(); i++) {
                    wallsX[i] = walls.get(i).getX();
                    wallsY[i] = walls.get(i).getY();
                    wallsWidth[i] = walls.get(i).getWidth();
                    wallsHeight[i] = walls.get(i).getHeight();
                }

                screenView.startGame(playerModel.getxPos(), playerModel.getyPos(), wallsX, wallsY, wallsWidth, wallsHeight, walls.get(0).getGAP_SIZE());
            } else if (message.getClass() == DifficultyScreenMessage.class) {
                screenView.goToPowerupScreen();
            } else if (message.getClass() == GameOverScreenMessage.class) {
                screenView.goToGameOverScreen();
            } else if (message.getClass() == QuitGameMessage.class) {
                screenView.quitGame();
            } else if (message.getClass() == RestartGameScreenMessage.class) {
            	resetWalls();
                screenView.goToStartGameScreen();
            } else if (message.getClass() == QuitDifficultyScreenMessage.class) {
                screenView.returnToStartScreen();
            } else if (message.getClass() == EasyDifficultyMessage.class) {
            	setDifficulty(DifficultyLevel.EASY);
            	resetWalls();
                screenView.activatePowerup1();
            } else if (message.getClass() == NormalDifficultyMessage.class) {
            	setDifficulty(DifficultyLevel.NORMAL);
            	resetWalls();
                screenView.activatePowerup2();
            } else if (message.getClass() == HardDifficultyMessage.class) {
            	setDifficulty(DifficultyLevel.HARD);
            	resetWalls();
                screenView.activatePowerup3();
            } else if (message.getClass() == MoveUpMessage.class) {
                if (playerModel.getyPos() - 20 > 0) {
                    playerModel.setyPos(-10);
                }
                screenView.movePlayer(playerModel.getxPos(), playerModel.getyPos());
            } else if (message.getClass() == MoveDownMessage.class) {
                if (playerModel.getyPos() + 100 < 1000){
                    playerModel.setyPos(10);
                }
                screenView.movePlayer(playerModel.getxPos(), playerModel.getyPos());
            } else if (message.getClass() == UpdateWallMessage.class) {

                for (int i = 0; i < walls.size(); i++) {
                    walls.get(i).move();

                    wallsX[i] = walls.get(i).getX();
                    wallsY[i] = walls.get(i).getY();
                    wallsWidth[i] = walls.get(i).getWidth();
                    wallsHeight[i] = walls.get(i).getHeight();
                }

                screenView.updateWalls(wallsX, wallsY, wallsWidth, wallsHeight, walls.get(0).getGAP_SIZE());
            } else if (message.getClass() == CollisionCheckMessage.class) {
                for (int i = 0; i < walls.size(); i++) {
                    if ((walls.get(i).getX() > 230 && walls.get(i).getX() < 330) || (walls.get(i).getX() + 100 > 230 && walls.get(i).getX() + 100 < 331)) {
                        if (walls.get(i).getHeight() > playerModel.getyPos() - 20 || (walls.get(i).getHeight() + walls.get(i).getGAP_SIZE()) < playerModel.getyPos() + 80) {
                            screenView.goToGameOverScreen();
                            screenView.stopTimer();
                        }
                    }
                }
            } else if (message.getClass() == ScoreCheckMessage.class){
                int count = 0;
                for (int i = 0; i < walls.size(); i++) {
                    if (walls.get(i).getX() < 330) {
                        count++;
                    }
                    playerModel.setScore(count);
                    screenView.updateScore(playerModel.getScore());
                    screenView.updateGameOverScore(playerModel.getScore());
                }
            }
        }
    }
    
    /**
     * returns the current difficulty of the game
     * @return difficulty
     */
    private DifficultyLevel getDifficulty() {
		return difficulty;
	}
	
    /**
     * sets the difficulty of the game
     * @param difficulty
     */
	private void setDifficulty(DifficultyLevel difficulty) {
		this.difficulty = difficulty;
	}
    
    /*
     * resets walls in order to reset dimensions and positions
     */
    private void resetWalls() {
    	walls.removeAll(walls);
    	for (int i = 0; i < 1000; i++) {
            walls.add(new Wall(i * 600));
        }
    	for (Wall w: walls) {
    		if (getDifficulty() == DifficultyLevel.NORMAL) {
    			w.setSpeed(4);
    		} else if (getDifficulty() == DifficultyLevel.EASY) {
    			w.setSpeed(2);
    		} else if (getDifficulty() == DifficultyLevel.HARD) {
    			w.setSpeed(8);
    		}
    	}
    }
}
