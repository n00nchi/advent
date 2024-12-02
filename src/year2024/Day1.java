package year2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day1 {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("src/year2024/data/input1.txt"))) {
            String line;
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] arr = line.split("\\s+");
                left.add(Integer.parseInt(arr[0]));
                right.add(Integer.parseInt(arr[1]));
            }

            Collections.sort(left);
            Collections.sort(right);

            System.out.println(left);
            System.out.println(right);

            // part 1

//           ArrayList<Integer> diff = new ArrayList<>();
//
//           for (int i = 0; i <  left.size(); i++) {
//              if (right.get(i) > left.get(i)) {
//                  diff.add(right.get(i) - left.get(i));
//              } else if (left.get(i) > right.get(i)) {
//                  diff.add(left.get(i) - right.get(i));
//              }
//           }
//
//            System.out.println("DIFF: " + diff);
//
//          int sum = 0;
//          for (int dif : diff) {
//              sum += dif;
//          }
//            System.out.println("Sum " + sum);

            // part 2

// find how many times num appears in  right list
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < left.size(); i ++) {
                int countInRight = Collections.frequency(right, left.get(i));
                map.put(left.get(i), countInRight);
            }
// remove keys with value = 0
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() == 0) {
                    iterator.remove();
                }
            }
// add up the product of left times how many times it appears on the right
            int totalSum = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                totalSum += key * value;
            }
            System.out.println("TOTAL SUM: " + totalSum);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    }