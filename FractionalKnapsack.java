import java.util.Arrays;
import java.util.Scanner;

class Product {
    double weight;
    double profit;
    double ratio;

    Product(double weight, double profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = profit / weight;
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Vehicle capacity
        double capacity = 50;
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        Product[] products = new Product[n];

        // Input weights
        System.out.print("Enter weights: ");
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextDouble();
        }

        // Input profits
        System.out.print("Enter profits of products: ");
        double[] profits = new double[n];
        for (int i = 0; i < n; i++) {
            profits[i] = sc.nextDouble();
        }

        for (int i = 0; i < n; i++) {
            products[i] = new Product(weights[i], profits[i]);
        }

        Arrays.sort(products, (a, b) ->
                Double.compare(b.ratio, a.ratio));

        double remainingCapacity = capacity;
        double totalProfit = 0;
        double weightTaken = 0;

        System.out.println("Products:");

        for (int i = 0; i < n; i++) {
            if (remainingCapacity == 0) {
                break;
            }

            double fraction;

            if (products[i].weight <= remainingCapacity) {
                // Take complete product
                weightTaken = products[i].weight;
                fraction = 1.0;
                remainingCapacity -= weightTaken;
                totalProfit += products[i].profit;
            } else {
                weightTaken = remainingCapacity;
                fraction = weightTaken / products[i].weight;
                totalProfit += products[i].profit * fraction;
                remainingCapacity = 0;
            }

            System.out.printf(
                    "Weight: %.2f kg | Fraction: %.2f | Profit: %.2f\n",
                    weightTaken, fraction, products[i].profit * fraction);
        }

        System.out.printf("Total Weight Used: %.2f kg%n",
                capacity - remainingCapacity);

        System.out.printf("Remaining Capacity: %.2f kg%n",
                remainingCapacity);

        System.out.printf("Maximum Profit: %.2f%n",
                totalProfit);

        sc.close();
    }
}
