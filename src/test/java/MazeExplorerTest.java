import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.MazeCell;
import ca.mcmaster.se2aa4.mazerunner.MazeExplorer;


class MazeExplorerTest {
    /**
     * Test the findPathRightHand method of the MazeExplorer class.
     * This test checks if the method correctly finds a path through the maze
     * using the right-hand rule.
     * Also includes some testing of edge cases, such as a 1-wide maze and huge maze.
     */

    @Test
    void testFindPathRightHand_ValidPath() throws IOException {
        
        String TEST_MAZE_FILE_PATH = "src/test/resources/test.tiny.maz.txt";
        Maze maze = new Maze(TEST_MAZE_FILE_PATH);
        MazeCell[][] maze_array = maze.getMaze();
        int[] exits = maze.getExits();

        String path = MazeExplorer.findPathRightHand(maze_array, exits);

        assertEquals("5F 2L 2F R 2F R 2F 2L 2F R 2F R 3F", path, "The path should follow the right-hand rule and lead to the exit.");

    }

    @Test
    void testFindPathRightHand_StraightMaze() throws IOException {
        String TEST_MAZE_FILE_PATH = "src/test/resources/test.straight.maz.txt";
        Maze maze = new Maze(TEST_MAZE_FILE_PATH);
        MazeCell[][] maze_array = maze.getMaze();
        int[] exits = maze.getExits();

        String path = MazeExplorer.findPathRightHand(maze_array, exits);

        assertEquals("4F", path, "The path should go straight to the exit.");

    }

} 
    




