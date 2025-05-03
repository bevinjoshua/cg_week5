import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectCSVDuplicates {
    public static void main(String[] args) {
        String csvFile = "students.csv"; // Replace with your CSV file path
        String line;
        String delimiter = ",";
        Set<String> seenIds = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read the header
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(delimiter);
                String id = columns[0]; // Assuming ID is in the first column

                if (seenIds.contains(id)) {
                    // Duplicate found
                    System.out.println("Duplicate record =  " + line);
                } else {
                    seenIds.add(id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
