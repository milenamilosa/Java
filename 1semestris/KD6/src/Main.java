public class Main {
    public static void main(String[] args) {
        int s=0;
        for (int i=1, f=1; i<=16; i++){
            f = f*i;
            s = s+f*f;
            System.out.println(f + "  " + s);
        }
        System.out.println(s);
    }
}