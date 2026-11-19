public class RecurrenceTreeMethod {
   static int T(int n) {
       if (n <= 1) return 1;
       return 2 * T(n / 2) + n;
   }

   public static void main(String[] args) {
       int n = 16;
       long start = System.nanoTime();
       int total = 0;
       int size = n;
       int nodes = 1;
       int level = 0;
       System.out.println("Recurrence: T(n) = 2T(n/2) + n, n = " + n);
       while (size >= 1) {
           int cost = nodes * size;
           System.out.println("Level " + level + ": " + nodes + " nodes x " + size + " = " + cost);
           total += cost;
           nodes *= 2;
           size /= 2;
           level++;
       }
       int result = T(n);
       long end = System.nanoTime();
       System.out.println("Total cost from tree = " + total);
       System.out.println("T(" + n + ") by recursion = " + result);
       System.out.println("Execution Time: " + (end - start) + " ns");
       System.out.println("Time Complexity: O(n log n)");
       System.out.println("Space Complexity: O(log n)");
   }
}
