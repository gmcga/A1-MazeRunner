import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.MazeCell;

class MazeParseTest {
    /**
     * Test the parsing of a maze from a file.
     * The test checks if the maze is correctly parsed into a 2D array of MazeCell.
     * It verifies the dimensions and specific cell values in the maze.
     * The test uses a sample maze file located at src/test/resources/test.maze1.txt.
     */

    @Test
    void testMazeParsingFromFile() throws IOException {

        String TEST_MAZE_FILE_PATH = "src/test/resources/test.maze1.txt";

        // The test maze looks like this:
        /**
         * ###
         * 
         * ###
         */

        Maze maze = new Maze(TEST_MAZE_FILE_PATH);
        MazeCell[][] maze_array = maze.getMaze();

        // Check if the maze array is not null and has the expected dimensions.
        assertNotNull(maze_array, "The maze array should not be null.");
        assertEquals(3, maze_array.length, "The maze should have 3 rows.");
        assertEquals(3, maze_array[0].length, "The maze should have 3 columns.");
        assertEquals(MazeCell.WALL, maze_array[0][0], "The cell at (0, 0) should be a wall.");
        assertEquals(MazeCell.WALL, maze_array[0][1], "The cell at (0, 1) should be a wall.");  
        assertEquals(MazeCell.WALL, maze_array[0][2], "The cell at (0, 2) should be a wall.");  
        assertEquals(MazeCell.PASS, maze_array[1][0], "The cell at (1, 0) should be an empty space.");
        assertEquals(MazeCell.PASS, maze_array[1][1], "The cell at (1, 1) should be an empty space.");
        assertEquals(MazeCell.PASS, maze_array[1][2], "The cell at (1, 2) should be an empty space.");
        assertEquals(MazeCell.WALL, maze_array[2][0], "The cell at (2, 0) should be a wall.");
        assertEquals(MazeCell.WALL, maze_array[2][1], "The cell at (2, 1) should be a wall.");
        assertEquals(MazeCell.WALL, maze_array[2][2], "The cell at (2, 2) should be a wall.");
    }
}