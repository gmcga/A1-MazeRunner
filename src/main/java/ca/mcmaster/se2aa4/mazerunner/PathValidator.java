package ca.mcmaster.se2aa4.mazerunner;

/**
 * 
 * The PathValidator class handles the necessary functionality 
 * for validating a path provided by a user.
 */
public class PathValidator {
    
    // Method to validate a path provided by a user.
    public static boolean validatePath(MazeCell[][] maze, int[] exits, String path) {
        // Try starting from the left side, and if that doesn't work try from the right.
        if (!validatePathL(maze, exits, path)) {

            return validatePathR(maze, exits, path);
        }
        else {
            return true;
        }
    }

    // Validate path starting from the left side.
    private static boolean validatePathL(MazeCell[][] maze, int[] exits, String path) {
        int starting_exit_row = exits[0];
        int ending_exit_row = exits[1];
        // Start from the left side of the maze (facing East).
        Runner runner = new Runner(maze, starting_exit_row, 0, starting_exit_row, ending_exit_row, Direction.EAST);
        
        // Execute all the path instructions.
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'F' -> {
                    if (!runner.moveForward()) {
                        // Stop if the runner hits a wall.
                        return false;
                    }
                }
                case 'R' -> runner.turnRight();
                case 'L' -> runner.turnLeft();
                default -> {
                    return false;
                }
            }   
        }
        
        return runner.atExit('R');
    }

    // Validate path starting from the right side.
    private static boolean validatePathR(MazeCell[][] maze, int[] exits, String path) {
        // Flip the start/end row
        int ending_exit_row = exits[0];
        int starting_exit_row = exits[1];
        // Start from the right side of the maze (facing West).
        Runner runner = new Runner(maze, starting_exit_row, maze.length-1, starting_exit_row, ending_exit_row, Direction.WEST);
        
        // Execute all the path instructions.
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'F' -> {
                    if (!runner.moveForward()) {
                        // Stop if the runner hits a wall.
                        return false;
                    }
                }
                case 'R' -> runner.turnRight();
                case 'L' -> runner.turnLeft();
                default -> {
                    return false;
                }
            }   
        }
        
        return runner.atExit('L');
    }
}

