import java.util.Arrays;

public class QuickSort {
   static void sort(int[] a, int low, int high) {
       if (low < high) {
           int p = partition(a, low, high);
           sort(a, low, p - 1);
           sort(a, p + 1, high);
       }
   }

   static int partition(int[] a, int low, int high) {
       int pivot = a[high];
       int i = low - 1;
       for (int j = low; j < high; j++) {
           if (a[j] < pivot) {
               i++;
               int t = a[i];
               a[i] = a[j];
               a[j] = t;
           }
       }
       int t = a[i + 1];
       a[i + 1] = a[high];
       a[high] = t;
       return i + 1;
   }

   public static void main(String[] args) {
       int[] a = {10, 7, 8, 9, 1, 5, 3};
       System.out.println("Before: " + Arrays.toString(a));
       long start = System.nanoTime();
       sort(a, 0, a.length - 1);
       long end = System.nanoTime();
       System.out.println("After: " + Arrays.toString(a));
       System.out.println("Execution Time: " + (end - start) + " ns");
       System.out.println("Time Complexity: Best/Average O(n log n), Worst O(n^2)");
       System.out.println("Space Complexity: O(log n)");
   }
}
