import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x, y;
        try {
            x = sc.nextDouble();
            y = sc.nextDouble();
            sc.close();
        }

        catch(Exception ex) {
            System.out.println("input-output error");
            sc.close();
            return;
        }

        boolean square1, square2, halfcircle, triangle;

        square1 =  x>=3 && x<=7 && y>=3 && y<7;
        square2 =  x<6 && x>4 && y>4 && y<6;
        halfcircle = (x-5)*(x-5)+(y-8)*(y-8)<1 && y>8;
        triangle = y<=x+5 && y<=15-x && y >= 7;

        if (square1)
            System.out.println("red");
        if (square2)
            System.out.println("white");
        if (halfcircle)
            System.out.println("green");
        if (triangle)
            System.out.println("blue");
        else
            System.out.println("white");

    }

}