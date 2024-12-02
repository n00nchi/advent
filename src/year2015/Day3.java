package year2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class Day3 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/year2015.data/input3.txt"));

            HashSet<String> visited = new HashSet<>();
            int santaX = 0, santaY = 0;
            int roboSantaX = 0, roboSantaY = 0;
            visited.add(santaX + "," + santaY);
            String line;
            boolean santaTurn = true;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (santaTurn) {
                        switch (c) {
                            case '^':
                                santaY += 1;
                                break;
                            case 'v':
                                santaY -= 1;
                                break;
                            case '<':
                                santaX -= 1;
                                break;
                            case '>':
                                santaX += 1;
                                break;
                        }
                        visited.add(santaX + "," + santaY);
                    } else {
                        switch (c) {
                            case '^':
                                roboSantaY += 1;
                                break;
                            case 'v':
                                roboSantaY -= 1;
                                break;
                            case '>':
                                roboSantaX += 1;
                                break;
                            case '<':
                                roboSantaX -= 1;
                                break;
                        }
                        visited.add(roboSantaX + "," + roboSantaY);
                    }
                    santaTurn = !santaTurn;
                }
            }
            System.out.println("Number of unique houses visited: " + visited.size());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}