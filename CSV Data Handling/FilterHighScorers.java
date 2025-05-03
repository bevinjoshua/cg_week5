import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterHighScorers {
    public static void main(String[] args) {
        String filePath = "students.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int marks = Integer.parseInt(parts[3].trim());

                if (marks > 80) {
                    System.out.println("ID = " + parts[0] + ", Name = " + parts[1] + ", Age = " + parts[2] + ", Marks = " + parts[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
