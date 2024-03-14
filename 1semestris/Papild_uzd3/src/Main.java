import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("231RDB016; Milena Miloša; 11. grupa");

        int[] a = new int[3];
        System.out.println("Ievadiet veselus skaitļus augošā secībā masīvam a:");
        for (int i = 0; i < 3; i++) {
            a[i] = sc.nextInt();
        }

        int[] b = new int[3];
        System.out.println("Ievadiet veselus skaitļus augošā secībā masīvam b:");
        for (int i = 0; i < 3; i++) {
            b[i] = sc.nextInt();
        }
        sc.close();

        int[] c = new int[6];
        int i = 0, j = 0, k = 0;

        while (i < 3 && j < 3) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++]= b[j++];
            }
        }
        while (i < 3) {
            c[k] = a[i];
            k++;
            i++;
        }
        while (j < 3) {
            c[k] = b[j];
            k++;
            j++;
        }

        for (int n = 0; n < c.length; n++) {
            System.out.print(c[n] + " ");
        }
    }
}