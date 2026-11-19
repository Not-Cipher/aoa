class Node {
   boolean leaf;
   int n;
   int[] keys = new int[4];
   Node[] child = new Node[5];
   Node next;

   Node(boolean leaf) {
       this.leaf = leaf;
   }
}

public class BPlusTree {
   static Node root = new Node(true);
   static int upKey;
   static Node upNode;

   static void insert(Node x, int k) {
       upNode = null;
       if (x.leaf) {
           int i = x.n - 1;
           while (i >= 0 && x.keys[i] > k) {
               x.keys[i + 1] = x.keys[i];
               i--;
           }
           x.keys[i + 1] = k;
           x.n++;
           if (x.n == 4) {
               Node r = new Node(true);
               r.keys[0] = x.keys[2];
               r.keys[1] = x.keys[3];
               r.n = 2;
               x.n = 2;
               r.next = x.next;
               x.next = r;
               upKey = r.keys[0];
               upNode = r;
           }
           return;
       }
       int i = 0;
       while (i < x.n && k >= x.keys[i]) i++;
       insert(x.child[i], k);
       if (upNode == null) return;
       for (int j = x.n; j > i; j--) {
           x.keys[j] = x.keys[j - 1];
           x.child[j + 1] = x.child[j];
       }
       x.keys[i] = upKey;
       x.child[i + 1] = upNode;
       x.n++;
       upNode = null;
       if (x.n == 4) {
           Node r = new Node(false);
           int mid = x.keys[2];
           r.keys[0] = x.keys[3];
           r.child[0] = x.child[3];
           r.child[1] = x.child[4];
           r.n = 1;
           x.n = 2;
           upKey = mid;
           upNode = r;
       }
   }

   static void add(int k) {
       insert(root, k);
       if (upNode != null) {
           Node r = new Node(false);
           r.keys[0] = upKey;
           r.child[0] = root;
           r.child[1] = upNode;
           r.n = 1;
           root = r;
       }
   }

   static boolean search(int k) {
       Node x = root;
       while (!x.leaf) {
           int i = 0;
           while (i < x.n && k >= x.keys[i]) i++;
           x = x.child[i];
       }
       for (int i = 0; i < x.n; i++)
           if (x.keys[i] == k) return true;
       return false;
   }

   public static void main(String[] args) {
       int[] keys = {10, 20, 5, 6, 12, 30, 7, 17, 25, 3};
       long start = System.nanoTime();
       for (int k : keys) add(k);
       Node x = root;
       while (!x.leaf) x = x.child[0];
       System.out.print("B+ Tree leaf level: ");
       while (x != null) {
           System.out.print("[");
           for (int i = 0; i < x.n; i++) System.out.print(x.keys[i] + (i < x.n - 1 ? " " : ""));
           System.out.print("] ");
           x = x.next;
       }
       System.out.println();
       System.out.println("Search 17: " + search(17));
       System.out.println("Search 15: " + search(15));
       long end = System.nanoTime();
       System.out.println("Execution Time: " + (end - start) + " ns");
       System.out.println("Time Complexity: O(log n) per insert/search");
       System.out.println("Space Complexity: O(n)");
   }
}
