// break; izmanto ar ieliktiem cikliem

//  outer: for (...) {
//      for (...) {
//          if (...) break outer;
//      }
// }
// šajā gsdījumā break pārtrauc ārējo ciklu

// continiue pārtrauc tekošo informāciju un nodod vadību cikla blokam (no piemēra)

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s, i, x;
        for (s=0, i=1; i<=10; i++){
            x = sc.nextInt();
            if (x<=0) continue;
            s += x;
        }
        System.out.println(s);
        sc.close();
    }
}