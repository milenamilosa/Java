import java.util.Scanner;

class Main {

    public static int i, b;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("231RDB016 Milena Miloša");

        int a;

        System.out.print("count:");
        a = sc.nextInt();
        int arr[] = new int[a];

        System.out.println("numbers:");

        int n = printArray(arr, i, b);

        System.out.print("result: ");
        System.out.println(n);
    }

    private static int printArray(int[] arr, int i, int b) {
        if (i < arr.length) {
            arr[i] = sc.nextInt();
            if (arr[i] == 0) {
                b = i + 1;
            }
            return printArray(arr, i + 1, b);
        }
        return b;
    }
}