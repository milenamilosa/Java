// problems with floating points and close to 0 values uncovered
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x, y, start, end, step;

        try {
            System.out.print("from: ");
            start= sc.nextDouble();
            System.out.print("to: ");
            end = sc.nextDouble();
            System.out.print("step: ");
            step = sc.nextDouble();
            sc.close();
        }
        catch(Exception ex) {
            System.out.println("input-output error");
            sc.close();
            return;
        }

        for (double i=start; i<=end; i+=step  ) {
            i = Math.round(i*1000)*0.001;
            x=i;
            if (Math.abs(3*x-6) == 0 || x < 0) {
                y = 0.0;
                System.out.printf("%.2f\tnot defined%n", x);
            }
            else {
                y = Math.sqrt(x)/(3*x-6);
                System.out.printf("%.2f\t%.2f%n", x, y);
            }
        }
    }
}