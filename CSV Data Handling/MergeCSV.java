import java.io.*;
import java.util.*;

class MergedStudent {
    int id;
    String name;
    int age;
    double marks;
    String grade;

    public MergedStudent(int id, String name, int age, double marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    public String toCSV() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        Map<Integer, String[]> map1 = new HashMap<>();
        Map<Integer, String[]> map2 = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            br1.readLine();
            String line;
            while ((line = br1.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                map1.put(id, new String[]{parts[1].trim(), parts[2].trim()});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
            br2.readLine();
            String line;
            while ((line = br2.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                map2.put(id, new String[]{parts[1].trim(), parts[2].trim()});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("ID,Name,Age,Marks,Grade\n");

            for (int id : map1.keySet()) {
                if (map2.containsKey(id)) {
                    String[] data1 = map1.get(id);
                    String[] data2 = map2.get(id);
                    MergedStudent student = new MergedStudent(
                            id,
                            data1[0],
                            Integer.parseInt(data1[1]),
                            Double.parseDouble(data2[0]),
                            data2[1]
                    );
                    writer.write(student.toCSV() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
