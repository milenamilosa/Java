// path to copy: /Users/milos/Desktop/Students.txt

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("231RDB016 Milena Miloša 10. grupa");

        String fileName;
        System.out.println("Input file name:");
        fileName = sc.nextLine();
        sc.close();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        System.out.println("Result:");

        String str;
        while ((str = br.readLine()) != null) {
            String[] word = str.split(" ");
            String studentaVards = "";
            int atzimeZem4 = 0;

            for (String vards : word) {
                try {
                    int grade = Integer.parseInt(vards);
                    if (grade < 4) {
                        atzimeZem4++;
                    }
                } catch (NumberFormatException e) {
                    studentaVards += vards + " ";
                }
            }
            if (atzimeZem4 > 0) {
                System.out.println(studentaVards.trim() + " " + atzimeZem4);
            }
        }
        br.close();
    }
}
