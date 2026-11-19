public class LongestCommonSubsequence {
   public static void main(String[] args) {
       String a = "AGGTAB";
       String b = "GXTXAYB";
       int m = a.length(), n = b.length();
       long start = System.nanoTime();
       int[][] dp = new int[m + 1][n + 1];
       for (int i = 1; i <= m; i++) {
           for (int j = 1; j <= n; j++) {
               if (a.charAt(i - 1) == b.charAt(j - 1))
                   dp[i][j] = dp[i - 1][j - 1] + 1;
               else
                   dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
           }
       }
       StringBuilder sb = new StringBuilder();
       int i = m, j = n;
       while (i > 0 && j > 0) {
           if (a.charAt(i - 1) == b.charAt(j - 1)) {
               sb.append(a.charAt(i - 1));
               i--;
               j--;
           } else if (dp[i - 1][j] >= dp[i][j - 1]) {
               i--;
           } else {
               j--;
           }
       }
       long end = System.nanoTime();
       System.out.println("String 1: " + a);
       System.out.println("String 2: " + b);
       System.out.println("LCS Length: " + dp[m][n]);
       System.out.println("LCS: " + sb.reverse());
       System.out.println("Execution Time: " + (end - start) + " ns");
       System.out.println("Time Complexity: O(m * n)");
       System.out.println("Space Complexity: O(m * n)");
   }
}
