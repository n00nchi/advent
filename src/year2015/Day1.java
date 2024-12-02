package year2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
    public static void main(String[] args) {
        System.out.println("DAY ONE");
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("src/year2015.data/input1.txt"));
            String line;
            int floor = 0;
            int position = 0;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    position ++;
                    if (c == '(') {
                        floor++;
                    } else if (c == ')') {
                        floor--;
                    }
                    if (floor == -1) {
                        System.out.println("First time Santa enters the basement - " + position);
                        break;
                    }
                }
            }
            System.out.println("Final floor: " + floor);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
