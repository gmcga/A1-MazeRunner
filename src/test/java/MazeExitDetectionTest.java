import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Maze;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class MazeExitDetectionTest {
    // This class tests the exit detection functionality of the Maze class.

    @Test
    void testValidExits() throws IOException {
        // Load a test maze file
        String test_maze_file_path = "src/test/resources/test.tiny.maz.txt";
        Maze maze = new Maze(test_maze_file_path);
        int[] exits = maze.getExits();
        int[] expected_exits = {5, 1};

        // Assert that the exits match the expected values
        assertArrayEquals(expected_exits, exits, "The maze exits should match the expected values.");
    }
}
