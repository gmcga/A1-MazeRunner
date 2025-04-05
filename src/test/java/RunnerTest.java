import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.MazeCell;
import ca.mcmaster.se2aa4.mazerunner.Runner;

import static org.junit.jupiter.api.Assertions.*;


class RunnerTest {
    /**
     * Test the Runner class, particularly its movement and turning methods.
     */

    @Test
    void testMoveForward() {
        // Create a simple 3x3 maze
        MazeCell[][] maze = {
            {MazeCell.WALL, MazeCell.WALL, MazeCell.WALL},
            {MazeCell.PASS, MazeCell.PASS, MazeCell.PASS},
            {MazeCell.WALL, MazeCell.WALL, MazeCell.WALL}
        };

        // Initialize the runner at (1, 0) facing right
        Runner runner = new Runner(maze, 1, 0, 1, 1, Direction.EAST);

        // Move forward
        boolean moved = runner.moveForward();

        // Assert the runner moved and updated its position
        assertTrue(moved, "Runner should move forward.");
        assertEquals(1, runner.getCurrentRow(), "Runner's row should remain the same.");
        assertEquals(1, runner.getCurrentCol(), "Runner's column should update to 1.");
    }

    @Test
    void testTurnRightAndTurnLeft() {
        // Create a simple 3x3 maze
        MazeCell[][] maze = {
            {MazeCell.WALL, MazeCell.WALL, MazeCell.WALL},
            {MazeCell.PASS, MazeCell.PASS, MazeCell.PASS},
            {MazeCell.WALL, MazeCell.WALL, MazeCell.WALL}
        };

        // Initialize the runner at (1, 0) facing up
        Runner runner = new Runner(maze, 1, 0, 1, 1, Direction.NORTH);

        // Turn right
        runner.turnRight();
        assertEquals(Direction.EAST, runner.getCurrentDir(), "Runner should now face right.");

        // Turn left
        runner.turnLeft();
        assertEquals(Direction.NORTH, runner.getCurrentDir(), "Runner should now face up again.");
    }

    @Test
    void testAtExit() {
        // Create a simple 3x3 maze
        MazeCell[][] maze = {
            {MazeCell.WALL, MazeCell.WALL, MazeCell.WALL},
            {MazeCell.PASS, MazeCell.PASS, MazeCell.PASS},
            {MazeCell.WALL, MazeCell.WALL, MazeCell.WALL}
        };

        // Initialize the runner at the left entrance (1, 0)
        Runner runner = new Runner(maze, 1, 0, 1, 1, Direction.EAST);

        // Assert the runner is at the left entrance
        assertTrue(runner.atExit('L'), "Runner should be at the left exit.");

        // Move the runner to the right exit (1, 2)
        runner.moveForward();
        runner.moveForward();

        // Assert the runner is at the right exit
        assertTrue(runner.atExit('R'), "Runner should be at the right exit.");
    }
}