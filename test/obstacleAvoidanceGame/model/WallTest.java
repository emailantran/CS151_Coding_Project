package obstacleAvoidanceGame.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WallTest {

	@Test
    void testMove() {
        Wall testWall = new Wall(30);
        testWall.move();
        assertEquals(testWall.getX(), 1946, "Moves the wall over 4 left from the original 1950 so it should equal 1946");
        testWall.setSpeed(2);
        testWall.move();
        assertEquals(testWall.getX(), 1944, "Moves the wall over 2 left from the previous 1946 so it should equal 1944");
        for(int i = 0; i < 100; i++){
            testWall.move();
        }
        assertEquals(testWall.getX(), 1744, "Moves the wall over 2 left 100 times from the previous 1944 so it should equal 1944");
    }

}
