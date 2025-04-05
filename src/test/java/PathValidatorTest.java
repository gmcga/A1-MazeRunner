import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.MazeCell;
import ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.PathValidator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class PathValidatorTest {
    /**
     * Test the PathValidator class, particularly its validatePath method.
     * This test checks if the method correctly validates a path through the maze.
     */

    @Test
    void testValidPath() throws IOException {
        // Load a test maze
        String TEST_MAZE_FILE_PATH = "src/test/resources/test.tiny.maz.txt";
        Maze maze = new Maze(TEST_MAZE_FILE_PATH);
        MazeCell[][] maze_array = maze.getMaze();
        int[] exits = maze.getExits();
        Path path = new Path("5F 2L 2F R 2F R 2F 2L 2F R 2F R 3F");

        // Validate the path
        boolean is_valid = PathValidator.validatePath(maze_array, exits, path.getCanonicalizedPath());

        // Assert that the path is valid
        assertTrue(is_valid, "The path should be valid for the given maze.");
    }
}