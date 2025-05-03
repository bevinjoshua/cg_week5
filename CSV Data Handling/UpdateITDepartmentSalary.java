import java.io.*;
import java.util.*;

public class UpdateITDepartmentSalary {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line = reader.readLine();
            writer.write(line);
            writer.newLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String department = parts[2].trim();

                if (department.equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(parts[3].trim());
                    salary = salary * 1.10;
                    parts[3] = String.format("%.2f", salary);
                }

                writer.write(String.join(",", parts));
                writer.newLine();
            }

            System.out.println("Salaries updated and saved to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
