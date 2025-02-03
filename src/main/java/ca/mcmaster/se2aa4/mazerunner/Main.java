package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {
    public static void main(String[] args) {
        // Setup possible command line arguments.
        Options options = new Options();
        options.addOption("i", true, "File path to a maze file");
        options.addOption("p", true, "Path to verify on the provided maze");
        CommandLineParser parser = new DefaultParser();

        try {
            // Get the maze path from the command line arguments.
            CommandLine cmd = parser.parse(options, args);
            String maze_path = cmd.getOptionValue("i");

            // Make sure there is a maze provided. If there isn't one, end the program.
            if (maze_path == null) {
                System.out.println(" No path to maze file provided (-i). Terminating program.");
                System.exit(1);
            }

            // Create an instance of the Maze class and read it from the file provided.
            Maze maze = new Maze(maze_path);

            // If a path is provided, verify it. Otherwise, find a valid path through the maze.
            if (cmd.hasOption("p")) {
                String provided_path = cmd.getOptionValue("p");
                Path path = new Path(provided_path);

                if (PathValidator.validatePath(maze.getMaze(), maze.getExits(), path.getCanonicalizedPath()) == true) {
                    System.out.println("Path is valid");
                } else {
                    System.out.println("Path is invalid");
                }

            } else {
                String found_path = MazeExplorer.findPath(
                    maze.getMaze(), maze.getExits(),
                    SolvingMethod.RightHand, 
                    'L'
                    );

                System.out.println(found_path);
            }

        } catch(IOException | ParseException e) {
            System.out.println("/!\\ An error has occured /!\\");
        }
    }
}
