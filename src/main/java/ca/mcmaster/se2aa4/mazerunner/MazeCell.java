package ca.mcmaster.se2aa4.mazerunner;

public enum MazeCell {
    // Enum used to represent cells/items of a Maze.

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