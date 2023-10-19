import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s, i, u;
        int a = 5;      // max power
        int b = 2;      // the base

        for (s = 0, i=1; i <= a; i++) {
            u = (int)(Math.pow(b, i));
            s += u;
            System.out.println(u);
        }
        System.out.println(s);
    }
}