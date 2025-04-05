package ca.mcmaster.se2aa4.mazerunner;

/** 
 * 
 * The MazeExplorer class provides functionality for finding a valid path through a maze.
 * Currently, the only solving method is the right-hand exploration method.
 */
public class MazeExplorer {
    /*  Public method that calls the method that corresponds to the one provided by the user.
    Currently, only the right-hand exploration method is supported, but this can be expanded easily. */
    public static String findPath(MazeCell[][] maze, int[] exits, SolvingMethod method, char starting_side) {
        if (method == SolvingMethod.RightHand) {
            return findPathRightHand(maze, exits);
        } 
        else {
            return null;
        }
    }

    // Method to find the solution to a maze using the right-hand exploration method.
    public static String findPathRightHand(MazeCell[][] maze, int[] exits) {
        
        Path path = new Path("");
        int left_exit_row = exits[0];
        int right_exit_row = exits[1];
        // Start from the left side of the maze (facing East).
        Runner runner = new Runner(maze, left_exit_row, 0, left_exit_row, right_exit_row, Direction.EAST);
        
        while (!runner.atExit('R')) {
            // Determine the relative directions without changing orientation yet.
            Direction right_dir = runner.getCurrentDir().turnRight();
            Direction front_dir = runner.getCurrentDir(); 
            Direction left_dir = runner.getCurrentDir().turnLeft(); // Alternatively, you might compute this without modifying getCurrentDir().
        
            // Check the cell to the right.
            if (runner.isPassable(runner.getCurrentRow() + right_dir.getDy(), runner.getCurrentCol() + right_dir.getDx())) {
                runner.turnRight();  // Commit to the right turn.
                runner.moveForward();
                path.addMovement("RF");
            }
            // Else: check the front cell.
            else if (runner.isPassable(runner.getCurrentRow() + front_dir.getDy(), runner.getCurrentCol() + front_dir.getDx())) {
                runner.moveForward();
                path.addMovement("F");
            }
            // Else: check the cell to the left.
            else if (runner.isPassable(runner.getCurrentRow() + left_dir.getDy(), runner.getCurrentCol() + left_dir.getDx())) {
                runner.turnLeft(); // Commit to the left turn.
                runner.moveForward();
                path.addMovement("LF");
            }
            // Else (dead end): U-turn and move forward.
            else {
                runner.turnLeft();
                runner.turnLeft(); 
                runner.moveForward();
                path.addMovement("LLF");
            }
        }
        
        return path.getFactorizedPath();
    }

}
