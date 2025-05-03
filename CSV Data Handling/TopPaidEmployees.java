import java.io.*;
import java.util.*;

public class TopPaidEmployees {
    public static void main(String[] args) {
        String fileName = "employees.csv";
        List<String[]> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String header = reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                records.add(parts);
            }

            records.sort((a, b) -> Double.compare(Double.parseDouble(b[3].trim()), Double.parseDouble(a[3].trim())));

            System.out.println(header);
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                System.out.println(String.join(",", records.get(i)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
