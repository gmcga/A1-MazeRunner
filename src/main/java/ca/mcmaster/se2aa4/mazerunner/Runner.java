package ca.mcmaster.se2aa4.mazerunner;

// Runner class: used by MazeExplorer and PathValidator to move through the maze.
public class Runner {
    
    private final MazeCell[][] maze;
    private Direction current_dir;
    private int current_row;
    private int current_col;

    
    public Runner(MazeCell[][] maze, int start_row, int start_col, Direction start_dir) {
        this.maze = maze;
        this.current_row = start_row;
        this.current_col = start_col;
        this.current_dir = start_dir;
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
    private boolean isPassable(int row, int col) {
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

}

