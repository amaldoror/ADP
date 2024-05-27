package abgabe02;

import edu.princeton.cs.algs4.QuickUnionUF;

public class QuickUnionWithPathCompression extends QuickUnionUF {
    private int[] parent;
    private int count;

    public QuickUnionWithPathCompression(int n) {
        super(n);
        count = n;
        parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Find mit Pfadkompression: Zeigt immer auf den Wurzelknoten von p.
     * @param p an element
     * @return Root
     */
    public int find(int p) {
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

/*
    public int count() {
        return count;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        // Make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }
*/

    public static void main(String[] args) {
        int n = 10;
        QuickUnionWithPathCompression uf = new QuickUnionWithPathCompression(n);

        int[] pArray = new int[]{0, 2, 1, 6, 4, 5, 1, 1, 9, 8, 8, 8};
        int[] qArray = new int[]{1, 1, 3, 9, 7, 8, 5, 8, 1, 2, 3, 4};

        for (int i = 0; i < pArray.length; i++) {
            uf.union(pArray[i], qArray[i]);
            System.out.println("After union(" + pArray[i] + ", " + qArray[i] + "):");
            for (int j = 0; j < n; j++) {
                System.out.print(uf.find(j) + " ");
            }
            System.out.println();
        }
    }
}

