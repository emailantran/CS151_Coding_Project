package obstacleAvoidanceGame;

import obstacleAvoidanceGame.message.Message;
import obstacleAvoidanceGame.model.PlayerModel;
import obstacleAvoidanceGame.model.Wall;
import obstacleAvoidanceGame.controller.ScreenController;
import obstacleAvoidanceGame.view.ScreenView;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Game {
    public final static int DISTANCE_APART = 600;

    public static void main(String[] args) {

        BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();

        PlayerModel playerModel = new PlayerModel(230,100,100,100);
        ArrayList<Wall> walls = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            walls.add(new Wall(i * DISTANCE_APART));
        }

        ScreenView screenView = new ScreenView(queue);
        ScreenController screenController = new ScreenController(queue, screenView, playerModel, walls);

        screenController.mainLoop();
    }
}
