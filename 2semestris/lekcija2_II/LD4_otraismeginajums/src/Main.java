
//Users/milos/Desktop/Students.txt
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Print student information
        System.out.println("231RDB016 Milena Miloša 10. grupa");

        Scanner sc = new Scanner(System.in);

        String fileName;
        System.out.println("input file name:");
        fileName = sc.nextLine();
        sc.close();

        // Read the file
        FileReader fileReader = new FileReader(fileName);
        Scanner fileScanner = new Scanner(fileReader);

        // Process each line in the file
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            // Split the line into words
            String[] words = line.split(" ");

            // Iterate through each word and check if it's a name or a grade
            for (String word : words) {
                try {
                    // Try to parse the word as an integer (grade)
                    int grade = Integer.parseInt(word);

                    // Check if the grade is equal or lower than 5
                    if (grade <= 5) {
                        // Print the student name and grade
                        System.out.println(words[0] + " " + words[1] + " " + grade);
                        break; // Exit the loop after printing the information
                    }
                } catch (NumberFormatException e) {
                    // If the word is not a number, it is a part of the name
                    // Continue to the next iteration
                }
            }
        }

        // Close the file scanner
        fileScanner.close();

        System.out.println("result:");
        // Result is printed within the loop above, so no need for additional printing here
    }
}
