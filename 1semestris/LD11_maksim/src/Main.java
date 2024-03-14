package dip107;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Milena Miloša, 11.grupa, 231RDB016");
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.print("Ievadiet uzdevuma numuru (1 vai 2): ");
        try {
            a = sc.nextInt();
            if (a!=1 && a!=2) {
                System.out.println("input-output error");
            }
            sc.close();
        }
        catch(Exception ex) {
            System.out.println("input-output error");
            sc.close();
            return;
        }

        int[][]arr = new int[10][10];

        switch (a) {
            case 1 -> {
                int n = 1;
                for (int j = 2; j <= 6; j++) {
                    for (int i = 6 - j; i <= 11 - j; i++) {
                            arr[i][j] = n++;
                    }
                }
                for (int i = 0; i <10; i++) {
                    for (int j = 0; j<10; j++) {
                        System.out.print(arr[i][j]+"\t");
                    }
                    System.out.println();
                }
            }

            case 2 -> {
                int n = 1;
                for (int i = 7; i >=3; i--) {
                    for (int j = 8-i; j <= 7; j++) {
                        arr[j][i] = n++;
                    }
                }
                for (int i = 0; i <10; i++) {
                    for (int j = 0; j<10; j++) {
                        System.out.print(arr[i][j]+"\t");
                    }
                    System.out.println();
                }
            }
        }
    }
}