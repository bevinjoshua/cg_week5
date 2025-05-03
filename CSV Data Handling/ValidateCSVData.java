import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String fileName = "data.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "\\d{10}";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String header = reader.readLine();
            System.out.println("Header = " + header);

            String line;
            int lineNumber = 2;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String email = fields[2].trim();
                String phone = fields[3].trim();

                boolean validEmail = emailPattern.matcher(email).matches();
                boolean validPhone = phonePattern.matcher(phone).matches();

                if (!validEmail || !validPhone) {
                    System.out.println("Invalid data at line " + lineNumber + " = " + line);
                    if (!validEmail) System.out.println("  → Invalid email format");
                    if (!validPhone) System.out.println("  → Invalid phone number");
                }

                lineNumber++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
