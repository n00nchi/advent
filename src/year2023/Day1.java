package year2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day1 {
    public static void main(String[] args) throws IOException {
        int total = 0; // Variable to store the sum of calibration values

        HashMap<String, Character> validNum = new HashMap<>();
        validNum.put("one", '1' );
        validNum.put("two", '2');
        validNum.put("three", '3');
        validNum.put("four", '4');
        validNum.put("five", '5');
        validNum.put("six", '6');
        validNum.put("seven", '7');
        validNum.put("eight", '8');
        validNum.put("nine", '9');

        try (BufferedReader reader = new BufferedReader(new FileReader("src/year2023/data/input1.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Find the first and last digit in the line
                Character firstDigit = null;
                Character lastDigit = null;

                String extractedWord = null;

                StringBuilder currentWord = new StringBuilder();



                for (char ch : line.toCharArray()) {


                    if (Character.isLetter(ch)) {
                        currentWord.append(ch);
                        if (validNum.containsKey(currentWord.toString())) {
                            if (firstDigit == null){
                                firstDigit = validNum.get(currentWord.toString());
                            }



                        }

                        for (String word: validNum.keySet()) {
                            if (currentWord.toString().contains(word)) {
                                if (firstDigit == null) {
                                    firstDigit = validNum.get(word);
                                }
                                lastDigit = validNum.get(word);
                            }
                        }

                    } else if (Character.isDigit(ch)) {
                        if (firstDigit == null) {
                            firstDigit = ch;
                        }
                        lastDigit = ch;
                    } else {
                        if (!currentWord.isEmpty()) {
                            String word = currentWord.toString();
                            if (validNum.containsKey(word)) {
                                // if it's a valid word
                                if (firstDigit == null) {
                                    firstDigit = validNum.get(word);
                                }
                                lastDigit = validNum.get(word);
                            }
                            currentWord.setLength(0);
                        }
                    }
                }

                // After finishing the line, ensure we check the last word if it was a valid word
                if (currentWord.length() > 0) {
                    String word = currentWord.toString();
                    if (validNum.containsKey(word)) {
                        if (firstDigit == null) {
                            firstDigit = validNum.get(word);  // Set first digit from word
                        }
                        lastDigit = validNum.get(word);  // Update last digit from word
                    }
                }



                // If we have both first and last digits, combine them to form a two-digit number
                if (firstDigit != null && lastDigit != null) {
                    int calibrationValue = Integer.parseInt(firstDigit.toString() + lastDigit.toString());
                    total += calibrationValue;
                }
            }
        }

        System.out.println("Total: " + total);
    }
}
