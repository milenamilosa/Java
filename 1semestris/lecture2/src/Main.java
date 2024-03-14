import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.printf("x=%f", 1.234);
        //% ir vadītājs, kurā vietā tiek ievietots norādītājs mainīgais
        System.out.printf("%n%4d%n%4d%n%4d%n", 333, 22, 1);
        // 4 ir atvēlēto vietu skaits
        // %-10.5  mīnuss nozīmē izlīdzināšanu pa kreiso malu, .5 ir 5 zīmes aiz punkta

        //kvadratvienadojumu rēķināšana
        Scanner sc = new Scanner(System.in); //pirms izmantot skaneri ir jāpaprasa useram inputs
        int a, b, c;
        System.out.print("a = "); // koeficientu ievadīšana no klav.
        if (sc.hasNextInt()) {
            a = sc.nextInt();
        }
        else {
            System.out.print("Error");
        }

        System.out.print("b = ");
        b = sc.nextInt();
        System.out.print("c = ");
        c = sc.nextInt();
        int d; //ievadīt mainīgos ieteicams tieši tad kad tie ir vajadzīgi
        d = b*b - 4*a*c;

        if (d < 0) {
            System.out.println("Atrisinājuma nav");
        }
        else if (d == 0) {
            System.out.println("x = " + -(double)b/(2.0*a)); // 2.0 lai būtu pieejamas atbildē daļveida skaitļi VAI pierakstīt iekavās double/float
        }
        else {
            float x1 = (float)((-b + Math.sqrt(d)) / (2*a));
            float x2 = (float)((-b - Math.sqrt(d)) / (2*a));
            System.out.printf("x1=%f\t x2=%f", x1, x2);
        }


        sc.close(); //ieteicams aizvērt skaneri
    }
}