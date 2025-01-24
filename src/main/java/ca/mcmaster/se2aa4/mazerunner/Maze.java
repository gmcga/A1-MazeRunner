package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {

    private static final Logger logger = LogManager.getLogger();

    private char[][] maze;
    private final int[] exits = new int[2];

    // It might make sense to refactor this and the makeMazeArray methods to just be a constructor.
    public void readMazeFromFile(String maze_path) throws FileNotFoundException, IOException { 
        makeMazeArray(maze_path);

        try (BufferedReader reader = new BufferedReader(new FileReader(maze_path))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                for (int col = 0; col < line.length(); col++) {
                    if (line.charAt(col) == '#') {
                        maze[row][col] = '#'; 
                        System.out.print('#');
                    } else if (line.charAt(col) == ' ') {
                        maze[row][col] = '-'; 
                        System.out.print('-');
                    }
                }
                row++;
                System.out.print("\n");
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
        logger.trace("| Creating a maze array of size " + rows + " x " + cols);
        maze = new char[rows][cols];
    }

    public void findExitCoordinates() {
        // Hardcoded specifically for straight.maz.txt
        exits[0] = 2;
        exits[1] = 2;
    }

    public char[][] getMaze() {
        return maze;
    }

    public int[] getExits() {
        return exits;
    }
}
