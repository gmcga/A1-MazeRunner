package ca.mcmaster.se2aa4.mazerunner;

public class PathValidator {

    public static boolean validatePath(char[][] maze, int[] exits, String path) {
        // Initialize the starting position at the entrance (row defined by exits[0], column 0)
        int[] pos = {exits[0], 0}; // Entrance position: row from exits, column 0. This is confusing to read and should be made more clear.
        Direction direction = Direction.EAST;
        int cols = maze[0].length; // Total columns in the maze.

        // Take the provided path.
        for (int i = 0; i < path.length(); i++) {
            char move = path.charAt(i);

            // Validate move.
            if (move == 'F') {
                pos[1]++; // Move one step forward (East).

                // Check if out of bounds.
                if (pos[1] >= cols) {
                    return false;
                }
            } else {
                // Invalid move for the straight-line maze.
                return false;
            }
        }

        // Check to make sure we ended at the exit of the maze (we are in the last column).
        return pos[1] == cols - 1;
    }
}

