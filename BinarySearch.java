public class BinarySearch {
    public static void main(String[] args) {
        int[] a = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
        int key = 23;
        long start = System.nanoTime();
        int low = 0, high = a.length - 1, pos = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == key) {
                pos = mid;
                break;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        long end = System.nanoTime();
        System.out.println("Array: " + java.util.Arrays.toString(a));
        System.out.println("Key: " + key);
        if (pos == -1)
            System.out.println("Key not found");
        else
            System.out.println("Key found at index " + pos);
        System.out.println("Execution Time: " + (end - start) + " ns");
        System.out.println("Time Complexity: O(log n)");
        System.out.println("Space Complexity: O(1)");
    }
}
