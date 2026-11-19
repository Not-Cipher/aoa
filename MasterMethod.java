public class MasterMethod {
   public static void main(String[] args) {
       int a = 2, b = 2, d = 1;
       long start = System.nanoTime();
       double c = Math.log(a) / Math.log(b);
       System.out.println("Recurrence: T(n) = " + a + "T(n/" + b + ") + n^" + d);
       System.out.println("log_b(a) = " + c);
       if (Math.abs(d - c) < 1e-9)
           System.out.println("Case 2: T(n) = Theta(n^" + d + " log n)");
       else if (d < c)
           System.out.println("Case 1: T(n) = Theta(n^" + c + ")");
       else
           System.out.println("Case 3: T(n) = Theta(n^" + d + ")");
       long end = System.nanoTime();
       System.out.println("Execution Time: " + (end - start) + " ns");
       System.out.println("Time Complexity: O(1)");
       System.out.println("Space Complexity: O(1)");
   }
}
