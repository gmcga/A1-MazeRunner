package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    

    public static void main(String[] args) {
        // Allow all levels of logging severity to be shown in the terminal.
        Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.ALL);

        // Setup possible command line arguments.
        Options options = new Options();
        options.addOption("i", true, "File path to a maze file");
        options.addOption("p", true, "Path to verify on the provided maze");
        CommandLineParser parser = new DefaultParser();

        logger.info("| Starting Maze Runner");

        try {
            // Get the maze path from the command line arguments.
            CommandLine cmd = parser.parse(options, args);
            String maze_path = cmd.getOptionValue("i");

            // Make sure there is a maze provided. If there isn't one, end the program.
            if (maze_path == null) {
                logger.error(" | No path to maze file provided (-i). Terminating program.");
                System.exit(1);
            }

            logger.trace("| Reading the maze from file " + maze_path);
            
            // Create an instance of the Maze class and read it from the file provided.
            Maze maze = new Maze(maze_path);

            // If a path is provided, verify it. Otherwise, find a valid path through the maze.
            if (cmd.hasOption("p")) {
                String provided_path = cmd.getOptionValue("p");
                Path path = new Path(provided_path);

                logger.info("| Validating path");

                if (PathValidator.validatePath(maze.getMaze(), maze.getExits(), path.getPath()) == true) {
                    logger.info("| Path is valid");
                    System.exit(0);
                } else {
                    logger.info("| Path is invalid");
                }

            } else {
                logger.info("| Computing path");

                String found_path = MazeExplorer.findPathRightHand(maze.getMaze(), maze.getExits(), 'L');
                logger.info("| Path found: " + found_path);
            }

        } catch(IOException | ParseException e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        
        logger.info("| End of MazeRunner");
    }
}
