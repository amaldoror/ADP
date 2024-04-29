package adp

public class LocalMaximumFinder {
    
    public static int[] findLocalMaximum(int[] a, int r) {
        return findLocalMaximum(a, 0, a.length - 1, r);
    }

    private static int[] findLocalMaximum(int[] a, int lo, int hi, int r) {
        int mid = lo + (hi - lo) / 2;

        // Check if mid is local maximum
        if (isLocalMaximum(a, mid, r)) {
            return new int[]{mid - r, mid + r};
        }

        // If not, check the half containing the larger neighbor
        if (a[mid - 1] > a[mid + 1]) {
            return findLocalMaximum(a, lo, mid - 1, r);
        } else {
            return findLocalMaximum(a, mid + 1, hi, r);
        }
    }

    private static boolean isLocalMaximum(int[] a, int index, int r) {
        int n = a.length;
        if (index - r < 0 || index + r >= n) {
            return false;
        }
        for (int i = index - r; i < index; i++) {
            if (a[i] >= a[i + 1]) {
                return false;
            }
        }
        for (int i = index; i < index + r; i++) {
            if (a[i] <= a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
		
        int[] ary1 = {1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] ary2 = {1, 61, 16, 75, 89, 133, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] ary3 = {99, 1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};


        int[] result1 = findLocalMaximum(ary1, 2);
        System.out.println("Local maximum found in range [" + result1[0] + ", " + result1[1] + "]");
		
		int[] result2 = findLocalMaximum(ary2, 3);
        System.out.println("Local maximum found in range [" + result1[0] + ", " + result1[1] + "]");
		
		int[] result3 = findLocalMaximum(ary3, 1);
        System.out.println("Local maximum found in range [" + result1[0] + ", " + result1[1] + "]");
    }
}
