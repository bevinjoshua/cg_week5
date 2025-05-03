import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;

import java.io.*;
import java.util.*;

public class CsvToJsonConverter {
    public static void main(String[] args) throws Exception {
        List<Map<String, String>> students = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("students.csv"))) {
            String[] headers = reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                Map<String, String> student = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    student.put(headers[i], line[i]);
                }
                students.add(student);
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("students_from_csv.json"), students);
    }
}
