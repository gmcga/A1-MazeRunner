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

    // Convert a path to factorized form to display to the user.
    private String factorizePath() {
        StringBuilder factorized_path = new StringBuilder();
        // Keep a count of the number of the same character that is seen in a row.
        int count = 1;
        for (int i = 0; i < path.length(); i++) {
            if (i < path.length() - 1 && path.charAt(i) == path.charAt(i + 1)) {
                count++;
            // Found a different char, so append the previous char(s) to the factorized path.
            } else {
                if (count > 1) {
                    factorized_path.append(count);
                }
                factorized_path.append(path.charAt(i));
                factorized_path.append(' ');
                count = 1;
            }
        }
        return factorized_path.toString().trim();
    }

    // Add a movement ('F', 'L', 'R') to the path.
    public void addMovement(String movement) {
        path.append(movement);
    }

    // Getters for the path or its factorized version.
    public String getPath() {
        return path.toString();
    }

    public String getFactorizedPath() {
        return this.factorizePath();
    }



}
