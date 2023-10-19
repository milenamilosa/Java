// no lekcijas prezentācijas uzdevuma
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double s, i, a, x;
        x = sc.nextDouble();
        s=1;
        a=1;
        i=1;
        while (Math.abs(a) >= 0.000001){
            a = a*x/i;
            s += a;
            i += 1;
        }
        System.out.println(s + "    " + Math.exp(x));
        sc.close();
    }
}