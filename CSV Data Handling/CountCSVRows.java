import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        int rowCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            while (reader.readLine() != null) {
                rowCount++;
            }
            System.out.println("Number of data records = " + rowCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
