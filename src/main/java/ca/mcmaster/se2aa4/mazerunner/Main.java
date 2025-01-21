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
        options.addOption("i", true, "Path to a maze file");
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
            Maze maze = new Maze();
            maze.readMazeFromFile(maze_path);

        } catch(IOException | ParseException e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("| Computing path");
        logger.warn("| PATH NOT COMPUTED");
        logger.info("| End of MazeRunner");
    }
}
