package year2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Day2 {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/year2024/data/input2.txt"))) {
            String line;
            int safe = 0;

            ArrayList<Integer> nums = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                nums.clear();
                String[] parts = line.split(" ");
                for (String part : parts) {
                    nums.add(Integer.valueOf(part));
                }

                // Check if the report is safe
                if (isSafe(nums)) {
                    safe++;
                } else {
                    // Check if it can be made safe by removing one level
                    boolean canBeSafe = false;
                    for (int i = 0; i < nums.size(); i++) {
                        ArrayList<Integer> modified = new ArrayList<>(nums);
                        modified.remove(i);
                        if (isSafe(modified)) {
                            canBeSafe = true;
                            break;
                        }
                    }
                    if (canBeSafe) {
                        safe++;
                    }
                }
            }
            System.out.println(safe);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static boolean isSafe(ArrayList<Integer> nums) {
        if (nums.isEmpty()) {
            return false;
        }

        String order = checkOrder(nums);
        if (order.equals("Increasing")) {
            for (int i = 0; i < nums.size() - 1; i++) {
                if (nums.get(i + 1) - nums.get(i) > 3 || Objects.equals(nums.get(i + 1), nums.get(i))) {
                    return false;
                }
            }
            return true;
        } else if (order.equals("Decreasing")) {
            for (int i = 0; i < nums.size() - 1; i++) {
                if (nums.get(i) - nums.get(i + 1) > 3 || Objects.equals(nums.get(i + 1), nums.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static String checkOrder(ArrayList<Integer> arr) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(i - 1)) {
                dec = false;
            } else if (arr.get(i) < arr.get(i - 1)) {
                inc = false;
            }
            if (!inc && !dec) {
                return "Neither";
            }
        }
        if (inc) {
            return "Increasing";
        } else {
            return "Decreasing";
        }
    }
}
