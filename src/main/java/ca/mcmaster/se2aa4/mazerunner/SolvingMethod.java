package ca.mcmaster.se2aa4.mazerunner;

/**
 * 
 * The SolvingMethod enum provides a clear way for an expansion of the possible solving methods used by MazeExplorer.
 * This avoids having to use specific Strings (e.g. String solving_method == RightHand can be replaced by SolvingMethod method = SolvingMethod.RightHand).
 */
public enum SolvingMethod {
    RightHand,
}
