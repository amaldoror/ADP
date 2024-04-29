import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.InplaceMSD;

public class LocalMaximum {
	
	public static void main(String[] args) {
        int[] ary1 = {1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] ary2 = {1, 61, 16, 75, 89, 133, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] ary3 = {99, 1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        
		int[] result1 = localMax(ary1, 2);
        int[] result2 = localMax(ary2, 3);
        int[] result3 = localMax(ary3, 1);

        printArray(result1);
        printArray(result2);
        printArray(result3);
    }

    public static int[] localMax(int[] a, int radius) {
		
		// Sortierung mittels InplaceMSD
		// InplaceMSD.sort(a);
		
        int n = a.length;
        int lo = (n / 2) - radius;
        int hi = (n / 2) + radius;

        if (lo < 0 || hi >= n) {
            return null; // Radius out of bounds
        }

        // Prüfen, ob das mittlere Element das lokale Maximum ist
        boolean isLocalMax = true;

        for (int i = lo; i < (n/2); i++) {
            if (a[i] >= a[i + 1]) {
                isLocalMax = false;
                break;
            }
        }
        if (isLocalMax) {
            for (int i = (n/2); i < hi; i++) {
                if (a[i] <= a[i + 1]) {
                    isLocalMax = false;
                    break;
                }
            }
        }
        if (isLocalMax) {
            return new int[]{lo, hi};
        }

        // Rekursion: Hälfte mit kleinerem nachbarn
        if (a[(n/2) - 1] < a[(n/2) + 1]) {
            return localMax(a, radius, (n / 2), hi);
        } else {
            return localMax(a, radius, lo, (n/2));
        }
    }

    private static int[] localMax(int[] a, int radius, int lo, int hi) {
        int n = a.length;

        if (lo < 0 || hi >= a.length) {
            return null; // Radius out of bounds
        }

        // Prüfen, ob das mittlere Element das lokale Maximum ist
        boolean isLocalMax = true;
        for (int i = lo; i < (n/2); i++) {
            if (a[i] >= a[i + 1]) {
                isLocalMax = false;
                break;
            }
        }
        if (isLocalMax) {
            for (int i = (n/2); i < hi; i++) {
                if (a[i] <= a[i + 1]) {
                    isLocalMax = false;
                    break;
                }
            }
        }
        if (isLocalMax) {
            return new int[]{lo, hi};
        }

        // Rekursion: Hälfte mit kleinerem nachbarn
        if (a[n / 2 - 1] < a[n / 2 + 1]) {
            return localMax(a, radius, n / 2, hi);
        } else {
            return localMax(a, radius, lo, n / 2);
        }
    }

    private static void printArray(int[] a) {
        if (a == null) {
            StdOut.println("null");
            return;
        }
        StdOut.print("[");
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i]);
            if (i < a.length - 1) {
                StdOut.print(", ");
            }
        }
        StdOut.println("]");
    }
}
