import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, s, x;
        int i;
        x = sc.nextInt();
        s = 1 - 0.5*x*x;
        a = -0.5*x*x;
        i = 3;
        while(Math.abs(a) > 0.001) {
            a = -a*(i-1)*x/(i*(i-2));
            s += a;
            i += 1;
        }
        System.out.printf("function=%.4f", (1+x) * Math.exp(-x));
        System.out.printf("\nsumma=%.4f", s);
    }
}