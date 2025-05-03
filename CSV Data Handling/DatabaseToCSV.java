import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class DatabaseToCSV {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employees";
        String user = "ruchi";
        String password = "2233";

        String query = "SELECT employee_id, name, department, salary FROM employees";

        String csvFile = "employees_report.csv";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            writer.write("Employee ID, Name, Department, Salary");
            writer.newLine();

            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                writer.write(employeeId + "," + name + "," + department + "," + salary);
                writer.newLine();
            }

            System.out.println("CSV report generated successfully.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
