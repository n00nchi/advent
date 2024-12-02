import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Template {
    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new FileReader("src/year2024/data/input1.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {







            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
