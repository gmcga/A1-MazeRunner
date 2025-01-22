package ca.mcmaster.se2aa4.mazerunner;

public class Path {

    private StringBuilder path;

    public Path(String provided_path) {
        this.path = new StringBuilder(provided_path);
    }

    private void canonicalizePath() {
        // Convert a path to canonical form for ease of use in other classes/methods.
        this.path = this.path; // Not implementing this logic right now.
    }

    private String factorizePath() {
        // Convert a path to factorized form to display, if needed.
        String factorized_path = "";
        return factorized_path;
    }

    public String getPath() {
        return path.toString();
    }

}
