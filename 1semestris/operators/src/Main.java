import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*int s, i, x;
        s=0;
        i=1;
        while (i <= 4) {
            x = sc.nextInt();
            if (x >= 0) {
                s = s + x;
            }
            i=i+1;
        }

        System.out.println(s);*/

        double j = 1;
        double su = 0;
        do {
            su = su + Math.sin(j/10.0);
            j = j+1;
        }
        while (j<=20);

        System.out.println("Summa = " + su);

        sc.close();

        /*s = 0;
        for (i=1; i<=10; i++){
        s = s + i;
        }*/
    }
}