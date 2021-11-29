package obstacleAvoidanceGame.controller;

import obstacleAvoidanceGame.message.*;

import obstacleAvoidanceGame.model.PlayerModel;
import obstacleAvoidanceGame.model.Wall;
import obstacleAvoidanceGame.view.ScreenView;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 *  This class will act as the Controller class between the screens (view) and the game logic (model)
 *
 *  WORK IN PROGRESS CLASS... NEEDS REWORK OF SCREEN CLASSES
 */
public class ScreenController {
    BlockingQueue<Message> queue;
    PlayerModel playerModel;
    ArrayList<Wall> walls;
    ScreenView screenView;

    int[] wallsX;
    int[] wallsY;
    int[] wallsWidth;
    int[] wallsHeight;

    int score = 0;

    // constructor that initializes all the view and model classes for the controller to work with
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
            } else if (message.getClass() == PowerupScreenMessage.class) {
                screenView.goToPowerupScreen();
            } else if (message.getClass() == GameOverScreenMessage.class) {
                screenView.goToGameOverScreen();
            } else if (message.getClass() == QuitGameMessage.class) {
                screenView.quitGame();
            } else if (message.getClass() == RestartGameScreenMessage.class) {
            	resetWalls();
                screenView.goToStartGameScreen();
            } else if (message.getClass() == QuitPowerupScreenMessage.class) {
                screenView.returnToStartScreen();
            } else if (message.getClass() == Powerup1Message.class) {
                screenView.activatePowerup1();
            } else if (message.getClass() == Powerup2Message.class) {
                screenView.activatePowerup2();
            } else if (message.getClass() == Powerup3Message.class) {
                screenView.activatePowerup3();
            } else if (message.getClass() == Powerup4Message.class) {
                screenView.activatePowerup4();
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
    
    private void resetWalls() {
    	walls.removeAll(walls);
    	for (int i = 0; i < 1000; i++) {
            walls.add(new Wall(i * 600));
        }
    }
}
