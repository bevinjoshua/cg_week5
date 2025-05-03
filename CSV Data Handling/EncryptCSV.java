import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class EncryptCSV {
    public static void main(String[] args) throws Exception {
        List<String[]> records = Arrays.asList(
                new String[]{"ID", "Name", "Email", "Salary"},
                new String[]{"101", "Ruchi", AESUtil.encrypt("ruchi@example.com"), AESUtil.encrypt("70000")},
                new String[]{"102", "Yash", AESUtil.encrypt("yash@example.com"), AESUtil.encrypt("65000")}
        );

        FileWriter writer = new FileWriter("encrypted.csv");
        for (String[] record : records) {
            writer.write(String.join(",", record));
            writer.write("\n");
        }
        writer.close();
    }
}
