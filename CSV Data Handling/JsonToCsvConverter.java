import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

public class JsonToCsvConverter {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> students = mapper.readValue(new File("students.json"), new TypeReference<List<Map<String, Object>>>() {});

        try (CSVWriter writer = new CSVWriter(new FileWriter("students.csv"))) {
            if (!students.isEmpty()) {
                Set<String> headers = students.get(0).keySet();
                writer.writeNext(headers.toArray(new String[0]));
                for (Map<String, Object> student : students) {
                    List<String> row = new ArrayList<>();
                    for (String key : headers) {
                        row.add(String.valueOf(student.get(key)));
                    }
                    writer.writeNext(row.toArray(new String[0]));
                }
            }
        }
    }
}
