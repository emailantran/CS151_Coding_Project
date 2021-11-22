import java.util.concurrent.BlockingQueue;

/**
 *  This class will act as the Controller class between the screens (view) and the game logic (model)
 *
 *  WORK IN PROGRESS CLASS... NEEDS REWORK OF SCREEN CLASSES
 */
public class ScreenController {
    BlockingQueue<Message> queue;
    //View view;
    PlayerModel playerModel;
    Wall wall;

    // constructor that initializes all the view and model classes for the controller to work with
   /* public ScreenController(BlockingQueue<> queue, View view, PlayerModel playerModel, Wall wall) {
        this.queue = queue;
        //this.view = view;
        this.playerModel = playerModel;
        this.wall = wall;
    }*/

    //method stub for mainLoop which will actively check what is happening to update the model / view
    public void mainLoop() {
        //while () {

        //}
    }
}
