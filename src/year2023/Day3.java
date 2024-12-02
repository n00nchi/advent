package year2023;

import java.io.*;
import java.util.*;

public class Day3 {
    public static void main(String[] args) {
        // File path to your input file
        String filePath = "src/year2023/data/input3.txt";

        try {
            // Step 1: Read the file into a List of Strings
            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }

            // Step 2: Convert the List<String> to a 2D char grid
            char[][] grid = convertToGrid(lines);

            // Step 3: Example usage: Print the first 5 rows of the grid
            for (int i = 0; i < Math.min(140, grid.length); i++) {
                System.out.println(Arrays.toString(grid[i]));
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    // Helper method to convert a List of Strings to a 2D char array
    private static char[][] convertToGrid(List<String> lines) {
        int rows = lines.size();
        int cols = lines.get(0).length(); // Assuming all rows have the same length
        char[][] grid = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            grid[i] = lines.get(i).toCharArray();
        }

        return grid;
    }
}
