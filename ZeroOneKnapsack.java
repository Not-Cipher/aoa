public class ZeroOneKnapsack {
   public static void main(String[] args) {
       int[] w = {10, 20, 30};
       int[] v = {60, 100, 120};
       int W = 50;
       int n = w.length;
       long start = System.nanoTime();
       int[][] dp = new int[n + 1][W + 1];
       for (int i = 1; i <= n; i++) {
           for (int c = 0; c <= W; c++) {
               dp[i][c] = dp[i - 1][c];
               if (w[i - 1] <= c)
                   dp[i][c] = Math.max(dp[i][c], v[i - 1] + dp[i - 1][c - w[i - 1]]);
           }
       }
       long end = System.nanoTime();
       System.out.println("Maximum Value: " + dp[n][W]);
       int c = W;
       System.out.print("Items selected: ");
       for (int i = n; i > 0; i--) {
           if (dp[i][c] != dp[i - 1][c]) {
               System.out.print(i + " ");
               c -= w[i - 1];
           }
       }
       System.out.println();
       System.out.println("Execution Time: " + (end - start) + " ns");
       System.out.println("Time Complexity: O(n * W)");
       System.out.println("Space Complexity: O(n * W)");
   }
}
