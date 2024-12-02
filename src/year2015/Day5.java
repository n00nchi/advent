package year2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day5 {
    static int nice = 0;
    static String vowels = "aeiou";
    int vowelCount = 0;
    static boolean firstCheck = false;
    static boolean secondCheck = false;
    static boolean thirdCheck = false;
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("src/year2015/data/input5.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                firstCheck = false;
                secondCheck = false;
                thirdCheck = false;

                evaluateLine(line);
                evaluateLine2(line);
//                evaluateLine3(line);
                if (firstCheck && secondCheck) {
                    nice++;
                }
            }
            System.out.println("nice str: " + nice);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private  static void evaluateLine(String line) {
       for (int i = 0; i < line.length() - 3; i ++) {
           String pair = line.substring(i, i + 2);
           if (line.substring(i + 2).contains(pair)) {
               firstCheck = true;
               break;
           }
       }
    }

    private static void evaluateLine2(String line) {
       for (int i = 0; i < line.length() - 2; i++) {
           if (line.charAt(i) == line.charAt(i + 2)) {
               secondCheck = true;
               break;
           }
       }
    }

//    private static void evaluateLine(String line) {
//        int count = 0;
//        for (char c : line.toCharArray()){
//            if (vowels.contains(String.valueOf(c))){
//               count += 1;
//            }
//        }
//        if (count >= 3) {
//            firstCheck = true;
//        }
//    }
//
//    private static void evaluateLine2(String line) {
//        for (int i = 0; i < line.length() -1; i++) {
//            if (line.charAt(i) == line.charAt(i + 1)) {
//                secondCheck = true;
//                break;
//            }
//        }
//    }
//
//    private static void evaluateLine3(String line) {
//        String[] invalidSeq = {"ab", "cd", "pq", "xy"};
//        for (String seq : invalidSeq) {
//            if (line.contains(seq)) {
////                System.out.println("Line contains invalid sequence of chars: " + seq);
//                thirdCheck = false;
//                return;
//            }
//        }
//        thirdCheck = true;
//    }
}
