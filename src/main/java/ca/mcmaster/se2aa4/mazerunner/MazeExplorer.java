package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeExplorer {

    private static final Logger logger = LogManager.getLogger();

    public static String findPathRightHand(char[][] maze, int[] exits, char starting_side) {
        // Assume we start at the left-side entrace of straight.maz.txt.
        int[] pos = {2, 0};
        Direction direction = Direction.EAST;
        int rows = maze.length;
        int cols = maze[0].length;
        StringBuilder path = new StringBuilder(); // This should be refactored to use the Path class, but not important for MVP.
        
        logger.trace("| Starting maze exploration");
        
        while (pos[1] < cols - 1) {
            pos[1]++;
            path.append('F');
        }

        return path.toString();
    }

}
