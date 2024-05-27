package abgabe02;

import ad_1_5.UnionFindFactory;
import ad_1_5.UF;

public class Client {

    private static final int[] pArray = new int[]{0,2,1,6,4,5,1,1,9,8,8,8};
    private static final int[] qArray = new int[]{1,1,3,9,7,8,5,8,1,2,3,4};

    private static final int n = 10;

    private static int step;
    private static int p;
    private static int q;

    private static final UF quickfind = UnionFindFactory.getInstance(1, n);
    private static final UF weightedQuickUnion = UnionFindFactory.getInstance(3, n);
    // private static final QuickUnionUF quickUnionUF = new QuickUnionUF(n);
    // private static final WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(n);

    public static void main(String[] args) {
        printInitialId();
        printInitialCount();
        printEmptyLine();

        doQuickUnionUF();

        printSeparatorLine();

        //doWeightedQuickUnionUF();
    }

    // Zeichnen Sie für den Quick-Union-Algorithmus nach jedem union-Schritt den Inhalt des
    // id[] Arrays. Zeichnen Sie auch den entsprechenden Wald von Bäumen.
    public static void doQuickUnionUF() {
        for (int i = 0; i < pArray.length; i++) {
            p = pArray[i];
            q = qArray[i];
            quickfind.union(p, q);
            step = i+1;
            printStep();
            printQunion();
            printCount();
            printId();
            printEmptyLine();
        }
    }

    // Zeichnen Sie für den Weighted-Quick-Union-Algorithmus nach jedem union Schritt den
    // Inhalt des id[] und des sz[] Arrays.
    private static void doWeightedQuickUnionUF() {
        for (int i = 0; i < pArray.length; i++) {
            p = pArray[i];
            q = qArray[i];
            weightedQuickUnion.union(pArray[i], qArray[i]);
            step = i + 1;
            printStep();
            printWQunion();
            printWeightedCount();
            printWeightedId();
            printWeightedSize();
            printEmptyLine();
        }
    }

    private static void printQunion(){
        System.out.println("Quick Union [" + p + ", " + q + "]");
    }

    private static void printWQunion() {
        System.out.println("Weighted Quick Union [" + p + ", " + q + "]");
    }

    private static void printId(){
        StringBuilder sb = new StringBuilder("ID: ");
        int x;
        for (int i = 0; i < n; i++) {
            x = quickfind.find(i);
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    private static void printWeightedId() {
        StringBuilder sb = new StringBuilder("ID: ");
        for (int i = 0; i < n; i++) {
            sb.append(weightedQuickUnion.find(i)).append(" ");
        }
        System.out.println(sb);
    }

    private static void printStep(){
        System.out.println("Step: " + step);
    }

    private static void printInitialId(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<10; i++){
            sb.append(i).append(" ");
        }
        System.out.println("Initial ID: " + sb);
    }

    private static void printCount(){
        System.out.println("Count: " + quickfind.count());
    }

    private static void printWeightedCount() {
        System.out.println("Count: " + weightedQuickUnion.count());
    }

    private static void printInitialCount(){
        System.out.println("Initial Count: " + quickfind.count());
    }

    private static void printWeightedSize() {
        StringBuilder sb = new StringBuilder("Size: ");
        int[] sizeArray = new int[n];
        for (int i = 0; i < n; i++) {
            sizeArray[weightedQuickUnion.find(i)]++;
        }
        for (int i = 0; i < n; i++) {
            if (sizeArray[i] > 0) {
                sb.append(sizeArray[i]).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void printSeparatorLine(){
        System.out.println("----------------------------\n");
    }

    private static void printEmptyLine(){
        System.out.print("\n");
    }
}
