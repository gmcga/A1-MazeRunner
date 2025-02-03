package ca.mcmaster.se2aa4.mazerunner;
public class Runner {
    
    private final MazeCell[][] maze;
    private Direction current_dir;
    private int current_row;
    private int current_col;
    private final int left_exit_row;
    private final int right_exit_row;

    
    public Runner(MazeCell[][] maze, int start_row, int start_col, int left_exit_row, int right_exit_row, Direction start_dir) {
        this.maze = maze;
        this.current_row = start_row;
        this.current_col = start_col;
        this.current_dir = start_dir;
        this.left_exit_row = left_exit_row;
        this.right_exit_row = right_exit_row;
    }
    // Moves the runner forward if possible.
    public boolean moveForward() {
        if (!canMoveForward()) {
            return false;
        }
        current_row += current_dir.getDy();
        current_col += current_dir.getDx();
        return true;
    }

    // Check if the cell in the direction we are moving is passable.
    private boolean canMoveForward() {
        int next_row = current_row + current_dir.getDy();
        int next_col = current_col + current_dir.getDx();
        return isPassable(next_row, next_col);
    }

    // Utility method to check if the given position is within bounds and not a wall.
    public boolean isPassable(int row, int col) {
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) {
            return false;
        }
        return maze[row][col] == MazeCell.PASS;
    }

    // Turns the runner to the right.
    public void turnRight() {
        current_dir = current_dir.turnRight();
    }

    // Turn left.
    public void turnLeft() {
        current_dir = current_dir.turnLeft();
    }

    // Checks if the runner is at the exit of the maze.
    public boolean atExit(char exit_side) {
        if (exit_side == 'R') {
            return (current_col == maze.length-1 && current_row == right_exit_row);
        }
        else {// (exit_side == 'L') 
            return (current_col == 0 && current_row == left_exit_row);
        }
    }

    // Getters
    public Direction getCurrentDir() {
        return current_dir;
    }

    public int getCurrentRow() {
        return current_row;
    }

    public int getCurrentCol() {
        return current_col;
    }

}

