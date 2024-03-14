import java.util.Scanner;

// Abstraktā klase Figura
abstract class Figura {
    public abstract double area();
    public abstract double perimeter();
}

// Klase Rectangle, kas ir klases Figura pēctecis
class Rectangle extends Figura {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Implementētas metodes no klases Figura
    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ievadiet taisnstūru skaitu: ");
        int n = sc.nextInt();

        // Izveido masīvu no elementiem tipa Figura
        Figura[] f = new Figura[n];

        // Aizpildīt masīvu ar Rectangle objektiem
        for (int i = 0; i < n; i++) {
            System.out.printf("Ievadiet %d. taisnstūra platumu: ", i + 1);
            double width = sc.nextDouble();

            System.out.printf("Ievadiet %d. taisnstūra garumu: ", i + 1);
            double height = sc.nextDouble();

            f[i] = new Rectangle(width, height);
        }

        // Izvade
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f %.2f%n", f[i].area(), f[i].perimeter());
        }
    }
}
