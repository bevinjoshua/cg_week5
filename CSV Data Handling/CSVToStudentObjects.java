import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String toString() {
        return "Student {id = " + id + ", name = '" + name + "', age = " + age + ", marks = " + marks + "}";
    }
}

public class CSVToStudentObjects {
    public static void main(String[] args) {
        String fileName = "students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String header = br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int age = Integer.parseInt(parts[2].trim());
                double marks = Double.parseDouble(parts[3].trim());
                students.add(new Student(id, name, age, marks));
            }

            students.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
