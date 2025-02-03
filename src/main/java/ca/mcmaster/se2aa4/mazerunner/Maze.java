package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * The Maze class provides functionality for reading in a maze from a text file and storing it as a 2D array.
 */
public class Maze {

    private MazeCell[][] maze;
    private final int[] exits = new int[2];

    public Maze(String maze_path) throws IOException {
        readMazeFromFile(maze_path);
        findExitCoordinates();
    }
    
    // Method to read in a maze from a .txt file create a 2D array as a maze representation
    private void readMazeFromFile(String maze_path) throws FileNotFoundException, IOException { 
        // First make an array of the correct size, then populate the array elements.
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

    // Method to create a maze 2D array of the proper size.
    private void makeMazeArray(String maze_path) throws FileNotFoundException, IOException {
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

    // Find the row on which the left and right exits occur.
    private void findExitCoordinates() {
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

    // Getters for the maze and its exits.
    public MazeCell[][] getMaze() {
        return maze.clone();
    }

    public int[] getExits() {
        return exits;
    }

}
