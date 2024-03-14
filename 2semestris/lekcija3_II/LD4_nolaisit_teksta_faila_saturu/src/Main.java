///Users/milos/Desktop/Students.txt
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    String vards;
    String uzvards;
    List<Integer> atzime;

    public Student(String vards, String uzvards, List<Integer> atzime) {
        this.vards = vards;
        this.uzvards = uzvards;
        this.atzime = atzime;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int atzime : atzime) {
            sum += atzime;
        }
        return (double) sum / atzime.size();
    }

    public int countLowGrades() {
        int count = 0;
        for (int atzime : atzime) {
            if (atzime < 4) {
                count++;
            }
        }
        return count;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("231RDB016 Milena Miloša 10. grupa");
//        System.out.println(System.getProperty("user.home"));
        Scanner sc = new Scanner(System.in);
        System.out.println("input file name:");
        String fileName = sc.nextLine();
        sc.close();

        List<Student> students = readStudentsFromFile(fileName);
        System.out.println("result:");
        for (Student student : students) {
            if (student.calculateAverage() <= 5) {
                System.out.println(student.vards + " " + student.uzvards + " " + student.countLowGrades());
            }
        }
    }

    private static List<Student> readStudentsFromFile(String fileName) throws IOException {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = br.readLine()) != null) {
                String[] parts = str.split(" ");
                String name = parts[0];
                String surname = parts[1];
                List<Integer> grades = new ArrayList<>();
                for (int i = 2; i < parts.length; i++) {
                    grades.add(Integer.parseInt(parts[i]));
                }
                students.add(new Student(name, surname, grades));
            }
        }
        return students;
    }
}
