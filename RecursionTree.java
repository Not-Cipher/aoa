
import java.util.Scanner;

public class RecursionTree {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        int level = 0;
        int totalCost = 0;
        int nodes = 1;

        while (n >= 1) {

            int cost = nodes * n;

            System.out.println("Level " + level +
                    " : Cost = " + cost);

            totalCost += cost;

            if (n == 1)
                break;

            n = n / 2;
            nodes = nodes * 2;
            level++;
        }

        System.out.println("Total Cost = " + totalCost);

        System.out.println("Time Complexity = O(n log n)");

        sc.close();
    }
}
