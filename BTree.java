class Node {
   int[] keys = new int[3];
   Node[] child = new Node[4];
   int n = 0;
   boolean leaf = true;
}

public class BTree {
   static Node root = new Node();

   static void splitChild(Node p, int i) {
       Node y = p.child[i];
       Node z = new Node();
       z.leaf = y.leaf;
       z.n = 1;
       z.keys[0] = y.keys[2];
       if (!y.leaf) {
           z.child[0] = y.child[2];
           z.child[1] = y.child[3];
       }
       y.n = 1;
       for (int j = p.n; j > i; j--) p.child[j + 1] = p.child[j];
       p.child[i + 1] = z;
       for (int j = p.n - 1; j >= i; j--) p.keys[j + 1] = p.keys[j];
       p.keys[i] = y.keys[1];
       p.n++;
   }

   static void insertNonFull(Node x, int k) {
       int i = x.n - 1;
       if (x.leaf) {
           while (i >= 0 && x.keys[i] > k) {
               x.keys[i + 1] = x.keys[i];
               i--;
           }
           x.keys[i + 1] = k;
           x.n++;
       } else {
           while (i >= 0 && x.keys[i] > k) i--;
           i++;
           if (x.child[i].n == 3) {
               splitChild(x, i);
               if (k > x.keys[i]) i++;
           }
           insertNonFull(x.child[i], k);
       }
   }

   static void insert(int k) {
       if (root.n == 3) {
           Node s = new Node();
           s.leaf = false;
           s.child[0] = root;
           root = s;
           splitChild(s, 0);
           insertNonFull(s, k);
       } else {
           insertNonFull(root, k);
       }
   }

   static void traverse(Node x) {
       for (int i = 0; i < x.n; i++) {
           if (!x.leaf) traverse(x.child[i]);
           System.out.print(x.keys[i] + " ");
       }
       if (!x.leaf) traverse(x.child[x.n]);
   }

   static boolean search(Node x, int k) {
       int i = 0;
       while (i < x.n && k > x.keys[i]) i++;
       if (i < x.n && x.keys[i] == k) return true;
       if (x.leaf) return false;
       return search(x.child[i], k);
   }

   public static void main(String[] args) {
       int[] keys = {10, 20, 5, 6, 12, 30, 7, 17};
       long start = System.nanoTime();
       for (int k : keys) insert(k);
       System.out.print("B-Tree inorder: ");
       traverse(root);
       System.out.println();
       System.out.println("Search 6: " + search(root, 6));
       System.out.println("Search 15: " + search(root, 15));
       long end = System.nanoTime();
       System.out.println("Execution Time: " + (end - start) + " ns");
       System.out.println("Time Complexity: O(log n) per insert/search");
       System.out.println("Space Complexity: O(n)");
   }
}
