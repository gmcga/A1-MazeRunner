import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.MazeCell;
import ca.mcmaster.se2aa4.mazerunner.MazeExplorer;
import ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.PathValidator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class MazeExplorerGiantMazeTest {
    

    @Test
    void testGiantMaze() throws IOException {
        // Load a giant maze file
        String test_maze_file_path = "src/test/resources/test.giant.maz.txt";
        Maze maze = new Maze(test_maze_file_path);
        MazeCell[][] maze_array = maze.getMaze();
        int[] exits = maze.getExits();

        // Solve the maze
        // In the future, would likely be a good idea to store the valid path in a text file, and use that instead of relying on the MazeExplorer to find the path.
        String computed_path = MazeExplorer.findPathRightHand(maze_array, exits);
        Path path = new Path(computed_path);

        // Validate the solution
        assertNotNull(computed_path, "The computed path for a giant maze should not be null.");
        assertFalse(computed_path.isEmpty(), "The computed path for a giant maze should not be empty.");

        // Validate the path using the PathValidator
        boolean is_valid = PathValidator.validatePath(maze_array, exits, path.getCanonicalizedPath());
        assertTrue(is_valid, "The computed path for a giant maze should be valid.");
    }
}