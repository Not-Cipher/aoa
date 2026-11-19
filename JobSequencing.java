public class JobSequencing {
   public static void main(String[] args) {
       int[] id = {1, 2, 3, 4, 5};
       int[] d = {2, 1, 2, 1, 3};
       int[] p = {100, 19, 27, 25, 15};
       int n = id.length;
       long start = System.nanoTime();
       for (int i = 0; i < n - 1; i++)
           for (int j = 0; j < n - 1 - i; j++)
               if (p[j] < p[j + 1]) {
                   int t = p[j]; p[j] = p[j + 1]; p[j + 1] = t;
                   t = d[j]; d[j] = d[j + 1]; d[j + 1] = t;
                   t = id[j]; id[j] = id[j + 1]; id[j + 1] = t;
               }
       int[] slot = new int[n + 1];
       int total = 0;
       for (int i = 0; i < n; i++) {
           for (int j = Math.min(n, d[i]); j >= 1; j--) {
               if (slot[j] == 0) {
                   slot[j] = id[i];
                   total += p[i];
                   break;
               }
           }
       }
       long end = System.nanoTime();
       System.out.print("Job sequence: ");
       for (int j = 1; j <= n; j++)
           if (slot[j] != 0) System.out.print("J" + slot[j] + " ");
       System.out.println();
       System.out.println("Total Profit: " + total);
       System.out.println("Execution Time: " + (end - start) + " ns");
       System.out.println("Time Complexity: O(n^2)");
       System.out.println("Space Complexity: O(n)");
   }
}
