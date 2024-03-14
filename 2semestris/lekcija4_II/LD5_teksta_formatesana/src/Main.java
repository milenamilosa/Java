// 231RDB016 Milena Miloša 10.grupa
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
    public static Scanner sc;

    public static void main(String[] args) throws IOException{

        sc = new Scanner(System.in);
        String fileName;
        String s;

        String cmd = "";
        boolean exit = false;
        while (!exit) {
            cmd = sc.nextLine();


            switch (cmd.split(" ")[0]) {
                case "print":
                    fileName = cmd.split(" ")[1];
                    Scanner scan=new Scanner(new File(fileName));
                    while(scan.hasNextLine()) {
                        System.out.println(scan.nextLine());
                    }
                    scan.close();
                    break;

                case "format":
                    fileName = cmd.split(" ")[1];
                    int strLength = 0;
                    scan=new Scanner(new File(fileName));
                    PrintWriter out = new PrintWriter(new FileWriter("temp.txt"));
                    ArrayList<String> lines = new ArrayList<String>();
                    while (scan.hasNextLine()) {
                        s = scan.nextLine();

                        if (s == null || s.isEmpty() || s.equals("")) {
                            lines.remove(s);
                        }
                        else {
                            s=s.trim();
//                            s = s.toLowerCase();
                            String firstLetter = s.substring(0, 1);
                            String remainingLetters = s.substring(1);
                            firstLetter = firstLetter.toUpperCase();
                            s = firstLetter + remainingLetters;
                            lines.add(s);
                            if (s.length()>strLength){
                                strLength=s.length();
                            }
                        }
                    }
                    scan.close();

                    for (int i = 0; i < lines.size(); i++) {
                        s = lines.get(i);
                        int spaces = (strLength-s.length())/2;
                        // if there is a remainder , we should add 1 space to the start of the line
                        if ((strLength-s.length())%2>0) {
                            s=" ".repeat(spaces+1) + s + " ".repeat(spaces);
                        }
                        else {
                            s=" ".repeat(spaces) + s + " ".repeat(spaces);
                        }

                        if (i%2 == 0 && i!=0) {
                            out.println();
                        }
                        out.println(s);
                    }

                    out.close();
                    File sourceFile = new File(fileName);
                    File tempFile = new File("temp.txt");
                    sourceFile.delete();
                    tempFile.renameTo(sourceFile);

                    break;

                case "exit":
                    exit = true;
                    break;
            }
        }
    }
}