import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Longest Common Subsequence (LCS): ");
        System.out.println();

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int length = dp[m][n];
        char[] lcs = new char[length];

        int i = m, j = n, index = length - 1;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs[index] = s1.charAt(i - 1);
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        String result = new String(lcs);

        System.out.println("============================================");
        System.out.println("RESULT:");
        System.out.println("First String   : " + s1);
        System.out.println("Second String  : " + s2);
        System.out.println("Longest Common Subsequence (length = " + length + "):");
        System.out.println("LCS            : " + result);
        System.out.println("Length of LCS  : " + length);
        System.out.println("============================================");

        sc.close();
    }
}
