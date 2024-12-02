package year2015;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {
    public static void main(String[] args) {
        System.out.println("Day 2");
        int total = 0;
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("src/year2015.data/input2.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dimensions = line.split("x");
                int l = Integer.parseInt(dimensions[0]);
                int w = Integer.parseInt(dimensions[1]);
                int h = Integer.parseInt(dimensions[2]);

//                int slack = Math.min(l * w, Math.min(w * h, h* l));
//                int surfaceArea = 2 * (l * w + w * h + h * l);

                int smallestPerimeter = Math.min(2 * (l + w), Math.min(2 * (w + h), 2 * (l + h)));

                int volume = l * w * h;

                total += smallestPerimeter + volume;
            }
            System.out.println("Total: " + total);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
