import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ievadiet matricas rindu skaitu (rinda): ");
        int rinda = sc.nextInt();
        System.out.print("Ievadiet matricas kolonu skaitu (kolonna): ");
        int kolonna = sc.nextInt();

        int[][] matrica = new int[rinda][kolonna];

        int num = 1;
        int augša = 0;
        int apakša = rinda - 1;
        int paKreisi = 0;
        int paLabi = kolonna - 1;

        while (num <= rinda * kolonna) {
            for (int kol = paKreisi; kol <= paLabi; kol++) {
                matrica[augša][kol] = num++;
            } augša++;        // robežas noteikšana spirālei, lai skaitļi neietu pa apli

            for (int rind = augša; rind <= apakša; rind++) {
                matrica[rind][paLabi] = num++;
            } paLabi--;

            for (int kol = paLabi; kol >= paKreisi; kol--) {
                matrica[apakša][kol] = num++;
            } apakša--;

            for (int rind = apakša; rind >= augša; rind--) {
                matrica[rind][paKreisi] = num++;
            } paKreisi++;
        }

        for (int[] row : matrica) {
            for (int elem : row)
                System.out.print(elem + "\t");
            System.out.println();
        }
        sc.close();
    }
}