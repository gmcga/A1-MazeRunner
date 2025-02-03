package ca.mcmaster.se2aa4.mazerunner;

public class Path {

    private StringBuilder path;

    public Path(String provided_path) {
        this.path = new StringBuilder(provided_path);
    }

    // Convert a path to canonical form for ease of use in other classes/methods.
    private void canonicalizePath() {
        this.path = this.path; // Not implementing this logic right now.
    }

    // Convert a path to factorized form to display, if needed.
    private String factorizePath() {
        String factorized_path = "";
        return factorized_path;
    }

    // Add a movement ('F', 'L', 'R') to the path.
    public void addMovement(String movement) {
        path.append(movement);
    }

    public String getPath() {
        return path.toString();
    }



}
