package ca.mcmaster.se2aa4.mazerunner;

/**
 * 
 * The Direction enum provides a straightforward and workable way to keep track of the orientation of a Runner.
 * It also helps determine the Runner's new position in the maze after a forward movement. 
 */
public enum Direction {
    NORTH(0, -1), // Move up (-row)
    EAST(1, 0), // Move right (+col)
    SOUTH(0, 1),  // Move down (+row)
    WEST(-1, 0); // Move left (-col)

    private final int dx;
    private final int dy;

    // Constructor to initialize movement values.
    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    // Getters for dx and dy
    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    // Methods to turn 90 degrees right or left.
    public Direction turnRight() {
        // Shift to the next position in the enum declaration. Need modulo to wrap around.
        return values()[(this.ordinal() + 1) % 4]; 
    }

    public Direction turnLeft() {
        // Shift to the previous position in the enum declaration.
        return values()[(this.ordinal() + 3) % 4];
    }


}
