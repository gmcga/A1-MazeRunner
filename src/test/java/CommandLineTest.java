import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Main;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CommandLinePathValidationTest {
    /**
     * Test the command-line path validation functionality of the MazeExplorer program.
     * This test checks if the program correctly validates a path provided via command-line arguments.
     * The test uses a sample tiny maze.
     */
    // Note: The test assumes that the maze file and path are valid for the purpose of this test.

    @Test
    void testValidPathProvidedViaCommandLine() {
        // Redirect System.out to capture program output.
        ByteArrayOutputStream output_stream = new ByteArrayOutputStream(); // Use a ByteArrayOutputStream to capture output
        System.setOut(new PrintStream(output_stream));

        // Simulate command-line arguments
        String[] args = {
            "-i", "src/test/resources/test.tiny.maz.txt",
            "-p", "5F 2L 2F R 2F R 2F 2L 2F R 2F R 3F"
        };

        // Invoke the main method
        Main.main(args);

        // Capture the output and reset System.out
        String output = output_stream.toString();
        System.setOut(System.out);

        // Assert that the output indicates the path is valid
        assertTrue(output.contains("Path is valid"), "The program should indicate that the path is valid.");
    }

    @Test
    void testInvalidPathProvidedViaCommandLine() {
        // Redirect System.out to capture program output.
        ByteArrayOutputStream output_stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output_stream));

        // Simulate command-line arguments
        String[] args = {
            "-i", "src/test/resources/test.tiny.maz.txt",
            "-p", "5F 2L 2F" // Invalid path
        };

        // Invoke the main method
        Main.main(args);

        // Capture the output and reset System.out
        String output = output_stream.toString();
        System.setOut(System.out);

        // Assert that the output indicates the path is invalid
        assertTrue(output.contains("Path is invalid"), "The program should indicate that the path is invalid.");
    }
}
