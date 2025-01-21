package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    private char[][] maze;
    private final int[] exits = new int[2];

    public void readMazeFromFile(String maze_path) throws FileNotFoundException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(maze_path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.print(System.lineSeparator());
            }
        }
    }

    public void findExitCoordinates() {
        // Just set the values to template values for now
        exits[0] = -1;
        exits[1] = -1;
    }

    public char[][] getMaze() {
        return maze.clone();
    }

    public int[] getExits() {
        return exits.clone();
    }
}
