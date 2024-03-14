import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        String apliecibasNmrs = "231RDB016 ";
        String vardsUzvards = "Milena Miloša ";
        int grupa = 11;
        System.out.println(apliecibasNmrs + vardsUzvards + grupa);

        Scanner sc = new Scanner(System.in);
        double a = Math.toRadians(50), g = 23.95, t = 0, x, y;
        boolean isGround = false, isTarget = false;  // isGround = false;

        try {
            System.out.print("v₀ = ");
            int v0 = sc.nextInt();

            if (v0 > 0) {
                System.out.println("----------------------------");
                System.out.println(" t\t\t\tx\t\t\ty");
                System.out.println("----------------------------");

                while (!isGround && !isTarget) {   // isTarget (== true); !isTarget (==false) while cikla nosacījumā bool skaitās true vienmēr
                    t += 0.05;
                    x = v0 * t * Math.cos(a);
                    y = v0 * t * Math.sin(a) - (g * Math.pow(t, 2)) / 2;
                    isGround = x <= 11 && y <= 0 || x > 11 && y <= -7;      // zaļo bloku salīdzinam ar koordinatem kuras tam pieder
                    isTarget = x >= 17 && x <= 20 && y <= -2 && y >= -7;    // sakano bloku salidzinam ar koordinatem

                    if (isGround) {
                        System.out.println("----------------------------");
                        System.out.println("shot off the target");
                    }
                    else if (isTarget) {
                        System.out.println("----------------------------");
                        System.out.println("target destroyed");
                    }
                    else
                        System.out.printf("| %.2f | | %.3f | | %.3f |\n", t, x, y);
                }

            }
            else
                System.out.println("v₀ must be greater than 0");
        }
        catch (Exception ex) {
            System.out.println("input-output error");
        }

    }
}