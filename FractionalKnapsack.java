public class FractionalKnapsack {
   public static void main(String[] args) {
       int[] v = {60, 100, 120};
       int[] w = {10, 20, 30};
       int cap = 50;
       int n = v.length;
       long start = System.nanoTime();
       for (int i = 0; i < n - 1; i++)
           for (int j = 0; j < n - 1 - i; j++)
               if (v[j] * w[j + 1] < v[j + 1] * w[j]) {
                   int t = v[j]; v[j] = v[j + 1]; v[j + 1] = t;
                   t = w[j]; w[j] = w[j + 1]; w[j + 1] = t;
               }
       double total = 0;
       int rem = cap;
       for (int i = 0; i < n && rem > 0; i++) {
           if (w[i] <= rem) {
               rem -= w[i];
               total += v[i];
               System.out.println("Took full item: weight " + w[i] + ", value " + v[i]);
           } else {
               double part = (double) rem / w[i];
               total += v[i] * part;
               System.out.println("Took " + part + " of item: weight " + w[i] + ", value " + v[i]);
               rem = 0;
           }
       }
       long end = System.nanoTime();
       System.out.println("Capacity: " + cap);
       System.out.println("Maximum Value: " + total);
       System.out.println("Execution Time: " + (end - start) + " ns");
       System.out.println("Time Complexity: O(n log n) with efficient sort (O(n^2) with the bubble sort used here)");
       System.out.println("Space Complexity: O(1)");
   }
}
