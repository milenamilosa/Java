public class Main {
    public static void main(String[] args) {
        int[][] a = {
                {1,-2,-3,-4,5},
                {6,7,-8,-9,0},
                {2,4,-6,8,0},
                {1,-3,5,-7,-9}
        };
        int s = 0;
        for (int[]i:a) {
            for (int j : i) {
                if (j>=0)
                    s = s+j;

            }

        }
        System.out.println(s);
    }
}