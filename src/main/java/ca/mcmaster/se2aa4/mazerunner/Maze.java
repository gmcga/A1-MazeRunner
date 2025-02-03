package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Maze {

    private MazeCell[][] maze;
    private final int[] exits = new int[2];

    public Maze(String maze_path) throws IOException {
        readMazeFromFile(maze_path);
        findExitCoordinates();
    }

    // It might make sense to refactor this and the makeMazeArray methods to just be a constructor.
    private void readMazeFromFile(String maze_path) throws FileNotFoundException, IOException { 
        makeMazeArray(maze_path);

        try (BufferedReader reader = new BufferedReader(new FileReader(maze_path))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                for (int col = 0; col < line.length(); col++) {
                    char c = line.charAt(col);
                    maze[row][col] = MazeCell.fromChar(c);
                }
                row++;
                
            }
        }
    }

    private void makeMazeArray(String maze_path) throws FileNotFoundException, IOException {
        // Method to create a maze 2D array of the proper size.
        int rows = 0;
        int cols = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(maze_path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                cols = Math.max(cols, line.length());
                rows++;
            }
        }

        maze = new MazeCell[rows][cols];
    }

    private void findExitCoordinates() {
        // Find the row on which the left and right exits occur.
        int maze_length = maze.length;

        for (int row = 0; row < maze_length; row++) {
            if (maze[row][0] == MazeCell.PASS) {
                exits[0] = row;
                break;
            }
        }

        for (int row = 0; row < maze_length; row++) {
            if (maze[row][maze_length - 1] == MazeCell.PASS) {
                exits[1] = row;
                break;
            }
        }

    }

    public MazeCell[][] getMaze() {
        // Getter for the maze 2D array.
        return maze.clone();
    }

    public int[] getExits() {
        // Getter for the exit coordinates of the maze.
        return exits;
    }

}
