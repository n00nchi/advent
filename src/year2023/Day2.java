package year2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {
    public static void main(String[] args) {
        int maxRed = 12;
        int maxGreen = 13;
        int maxBlue = 14;

        int sumOfValidGameIds = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/year2023/data/input2.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int power = calculatePower(line, maxRed, maxGreen, maxBlue);
                sumOfValidGameIds += power;
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.println("Sum of valid game IDs: " + sumOfValidGameIds);
    }

    private static int calculatePower(String game, int maxRed, int maxGreen, int maxBlue) {
        Pattern pattern = Pattern.compile("(\\d+) (red|green|blue)");
        Matcher matcher = pattern.matcher(game);

        int maxRedRequired = 0;
        int maxGreenRequired = 0;
        int maxBlueRequired = 0;

        while (matcher.find()) {
            int count = Integer.parseInt(matcher.group(1));
            String color = matcher.group(2);

            switch (color) {
                case "red":
                    maxRedRequired = Math.max(maxRedRequired, count);
                    break;
                case "green":
                    maxGreenRequired = Math.max(maxGreenRequired, count);
                    break;
                case "blue":
                    maxBlueRequired = Math.max(maxBlueRequired, count);
                    break;
            }
        }
        return maxRedRequired * maxGreenRequired * maxBlueRequired;
    }
}
