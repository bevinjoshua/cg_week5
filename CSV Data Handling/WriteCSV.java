import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Name,Department,Salary\n");
            writer.append("E101,Ruchi,HR,55000\n");
            writer.append("E102,Vandit,IT,72000\n");
            writer.append("E103,Ami,Finance,68000\n");
            writer.append("E104,Bhadrik,Marketing,64000\n");
            writer.append("E105,Yash,Operations,60000\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
