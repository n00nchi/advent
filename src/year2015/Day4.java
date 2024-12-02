package year2015;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {

    public static void main(String[] args) {
        String secretKey = "ckczppom";
        int number = 1;
        String hash = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            while (true) {
                String input = secretKey + number;
                byte[] digest = md.digest(input.getBytes());

                StringBuilder hexString = new StringBuilder();
                for (byte b : digest) {
                    String hex = Integer.toHexString(0xFF & b);
                    if (hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                hash = hexString.toString();

                if (hash.startsWith("000000")) {
                    break;
                }
                number++;
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.println("The lowest number that produces an MD5 hash starting with '00000' is : " + number);
    }
}
