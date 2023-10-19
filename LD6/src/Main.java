import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = 0, res = 0, counter = 0, x;
        while (true) {
            x = sc.nextInt();
            if (x == 0) {
                break;
            }
            else if (x > 0) {
                r += x;
                counter += 1;
                res = r / counter;
            }
        }

        System.out.printf("%.1f", res);
        sc.close();
    }
}