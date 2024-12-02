package year2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;

public class Day6 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("src/year2015/data/input6.txt")
            );
            String line;

            boolean[][] grid = new boolean[1000][1000];

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                String action = parts[0];

                int x1, y1, x2, y2;

                if (Objects.equals(action, "toggle")) {
                    String[] startCoords = parts[1].split(",");
                    x1 = Integer.parseInt(startCoords[0]);
                    y1 = Integer.parseInt(startCoords[1]);

                    String[] endCoords = parts[3].split(",");
                    x2 = Integer.parseInt(endCoords[0]);
                    y2 = Integer.parseInt(endCoords[1]);
                } else {
                    String[] startCoords = parts[2].split(",");
                    x1 = Integer.parseInt(startCoords[0]);
                    y1 = Integer.parseInt(startCoords[1]);

                    String[] endCoords = parts[4].split(",");
                    x2 = Integer.parseInt(endCoords[0]);
                    y2 = Integer.parseInt(endCoords[1]);
                }

                                // apply the action to the grid within the specified range
                for (int i = x1; i <= x2; i++) {
                    for (int j = y1; j <= y2; j++) {
                        switch (action) {
                            case "turn":
                            if (parts[1].equals("on")) {
                                grid[i][j] = true; // turn on
                            } else if(parts[1].equals("off")) {
                                grid[i][j] = false; // turn off
                            }
                            break;
                            case "toggle":
                                grid[i][j] = !grid[i][j]; // toggle the light
                                break;
                        }
                    }

                }
            }

            // count lights that are on
            int lightsOn = 0;
            for (int i = 0; i < grid.length; i ++) {
                for (int j = 0; j < grid[i].length; j ++) {
                    if (grid[i][j]) {
                        lightsOn++;
                    }
                }
            }

            System.out.println("Total lights on: " + lightsOn);


        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
