import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mas[] = {1, 2, 3, 4, 5, 6};
        mas[0] = 10;
        System.out.println(mas[1]);
        // visus elementus no masīva nav iespējams izvadīt, jāizmanto cikls!
        final int count = 5;
        int m[] = new int[count];
        for (int i = 0; i<count; i++) {
            System.out.print("m[" + i + "]=");
            m[i] = sc.nextInt();
        }

        for (int i = 0; i<count; i++) {
            System.out.print(m[i] + " ");
        }
        int i = 2;
        int x = mas[i];
        mas[2*i]= 20;

        int a[] = new int[20];
        int[] b = new int[30];

        System.out.println(mas[2]);
    }
}