import java.util.Scanner;

public class MasterMethod {
    public static void m(int a, int b, int f) {
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a: ");
        int a = sc.nextInt();
        System.out.println("Enter the value of b: ");
        int b = sc.nextInt();
        System.out.println("Enter the value of k in f(n): cn^k");
        double k = sc.nextDouble();
        int c = 1;
        double logBA = Math.log(a) / Math.log(b);

        System.out.println("\nRecurrence");
        System.out.println("T(n) = " + a + " * " + "T(n/ " + b + ") + n^" + k);

        System.out.println("\nStep 1: Standard Form");
        System.out.println("T(n) = aT(n/b) + f(n)");

        System.out.println("\nStep 2: Values");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("f(n) = n^" + k);

        System.out.println("\nStep 3: Calculate n^(log b a)");
        System.out.println("n^" + k + " = n^" + logBA);

        System.out.println("\nStep 4: Comparison");
        if (k < logBA) {
            System.out.println("\nStep 5: Master's Theorem Case 1 applies.");
            System.out.println("T(n) = Theta(n^" + logBA + ")");
        } else if (k == logBA) {
            System.out.println("\nStep 5: Master's Theorem Case 2 applies.");
            System.out.println("T(n) = Theta(n^" + logBA + " . log n)");
        } else {
            if (c > 1) {
                System.out.println("\nStep 5: Master's Theorem Case 3 applies.");
                System.out.println("T(n) = Theta(n^" + k + ")");
            } else {
                System.out.println("Can't be solved by Master's Theorem");
            }
        }
    }
}
