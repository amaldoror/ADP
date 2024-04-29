import edu.princeton.cs.algs4.StdOut;

public class LocalMaximum2 {
    private static int N; // Klassenattribut

    public static void main(String[] args) {
        int[] ary1 = {1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] ary2 = {1, 61, 16, 75, 89, 133, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] ary3 = {99, 1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};

        N = ary1.length;

        int[] result1 = localMax(ary1, 2);
        int[] result2 = localMax(ary2, 3);
        int[] result3 = localMax(ary3, 1);

        printArray(result1);
        printArray(result2);
        printArray(result3);
    }

    public static int[] localMax(int[] a, int radius) {
        N = a.length;
        return localMax(a, radius, N / 2 - radius, N / 2 + radius);
    }

    private static int[] localMax(int[] a, int radius, int lo, int hi) {
        if (lo < 0 || hi >= a.length) {
            return null; // Radius out of bounds
        }

        boolean isLocalMax = true;
        for (int i = lo; i < hi; i++) {
            if (a[i] >= a[i + 1]) {
                isLocalMax = false;
                break;
            }
        }
        if (isLocalMax) {
            return new int[]{lo, hi};
        }

        if (a[lo] < a[hi]) {
            return localMax(a, radius, N / 2, hi);
        } else {
            return localMax(a, radius, lo, N / 2);
        }
    }

    private static void printArray(int[] arr) {
        if (arr == null) {
            StdOut.println("null");
            return;
        }
        StdOut.print("[");
        for (int i = 0; i < arr.length; i++) {
            StdOut.print(arr[i]);
            if (i < arr.length - 1) {
                StdOut.print(", ");
            }
        }
        StdOut.println("]");
    }
}
