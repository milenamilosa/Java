import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a>0)
            System.out.println("s=" + a*a + "\np=" + a*4);
        else
            System.out.println("Error");
        sc.close();
    }
}