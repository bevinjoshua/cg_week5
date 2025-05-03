import java.io.*;

public class ChunkedCSVReader {
    public static void main(String[] args) {
        String filePath = "large_file.csv";
        int chunkSize = 100;
        int count = 0;
        int totalRecords = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                System.out.println("Header: " + line);
            }

            while ((line = reader.readLine()) != null) {
                count++;
                totalRecords++;

                if (count == chunkSize) {
                    System.out.println("Processed " + totalRecords + " records");
                    count = 0;
                }
            }

            if (count > 0) {
                System.out.println("Processed " + totalRecords + " records");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
