import java.io.BufferedReader;
import java.io.FileReader;

public class DecryptCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("encrypted.csv"));
        String line;
        boolean header = true;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (header) {
                System.out.println(String.join(", ", parts));
                header = false;
            } else {
                String decryptedEmail = AESUtil.decrypt(parts[2]);
                String decryptedSalary = AESUtil.decrypt(parts[3]);
                System.out.println(parts[0] + ", " + parts[1] + ", " + decryptedEmail + ", " + decryptedSalary);
            }
        }
        reader.close();
    }
}
