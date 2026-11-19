import java.util.Arrays;

public class MergeSort {
   static void sort(int[] a, int l, int r) {
       if (l >= r) return;
       int m = (l + r) / 2;
       sort(a, l, m);
       sort(a, m + 1, r);
       merge(a, l, m, r);
   }

   static void merge(int[] a, int l, int m, int r) {
       int[] t = new int[r - l + 1];
       int i = l, j = m + 1, k = 0;
       while (i <= m && j <= r) t[k++] = a[i] <= a[j] ? a[i++] : a[j++];
       while (i <= m) t[k++] = a[i++];
       while (j <= r) t[k++] = a[j++];
       for (k = 0; k < t.length; k++) a[l + k] = t[k];
   }

   public static void main(String[] args) {
       int[] a = {38, 27, 43, 3, 9, 82, 10};
       System.out.println("Before: " + Arrays.toString(a));
       long start = System.nanoTime();
       sort(a, 0, a.length - 1);
       long end = System.nanoTime();
       System.out.println("After: " + Arrays.toString(a));
       System.out.println("Execution Time: " + (end - start) + " ns");
       System.out.println("Time Complexity: O(n log n)");
       System.out.println("Space Complexity: O(n)");
   }
}
