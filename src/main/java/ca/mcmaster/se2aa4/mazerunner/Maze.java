package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    private char[][] maze;
    private int[] exits;

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
    }

    public char[][] getMaze() {
        return maze;
    }

    public int[] getExits() {
        return exits;
    }
}
