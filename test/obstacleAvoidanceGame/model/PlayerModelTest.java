package obstacleAvoidanceGame.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerModelTest {

	@Test
    void testSetScore() {
        PlayerModel testModel = PlayerModel.getPM();
        testModel.setScore(100);
        assertEquals(testModel.getScore(),100,"Score Should be 100");
    }

    @Test
    void testYPos(){
        PlayerModel testModel = PlayerModel.getPM();
        testModel.setyPos(100);
        assertEquals(testModel.getyPos(),200,"Should Increase Y pos by 100 making it 200");
    }

}
