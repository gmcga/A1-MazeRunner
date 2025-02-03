package ca.mcmaster.se2aa4.mazerunner;

/**
 * 
 * The MazeCell enum provides a useful and unambiguous type to be used in the Maze 2D array.
 * Instead of storing walls or gaps in the maze as chars or ints, MazeCell can be used which
 * avoids primitive obsession, making the code more flexible, understandable, and expandable.
 */
public enum MazeCell {

    WALL('#'),
    PASS(' ');

    private final char symbol;

    MazeCell(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static MazeCell fromChar(char c) {
        return (c == '#') ? WALL : PASS;
    }
}