public class LocalMax {
    public static void main(String[] args) {
        int[] ary1 = {1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] ary2 = {1, 61, 16, 75, 89, 133, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] ary3 = {99, 1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};

        int[] result1 = localMax(ary1, 2);
        int[] result2 = localMax(ary2, 3);
        int[] result3 = localMax(ary3, 1);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static int[] localMax(int[] a, int radius) {
        return localMaxHelper(a, 0, a.length - 1, radius);
    }

    private static int[] localMaxHelper(int[] a, int lo, int hi, int radius) {
        if (lo > hi || lo<0 || hi>a.length || radius<=0) {
            return null;
        }

        int mid = lo + (hi - lo) / 2;
        boolean isLocalMax = true;

        // Überprüfe linke Seite
        for (int i = Math.max(lo, mid - radius); i < mid; i++) {
            if (a[i] >= a[mid]) {
                isLocalMax = false;
                break;
            }
        }

        // Überprüfe rechte Seite
        if (isLocalMax) {
            for (int i = mid + 1; i <= Math.min(hi, mid + radius); i++) {
                if (a[i] >= a[mid]) {
                    isLocalMax = false;
                    break;
                }
            }
        }

        if (isLocalMax) {
            int left = Math.max(lo, mid - radius);
            int right = Math.min(hi, mid + radius);
            int[] result = new int[right - left + 1];
            for (int i = left; i <= right; i++) {
                result[i - left] = a[i];
            }
            return result;
        } else {
            int[] leftResult = localMaxHelper(a, lo, mid - 1, radius);
            if (leftResult != null) {
                return leftResult;
            }
            return localMaxHelper(a, mid + 1, hi, radius);
        }
    }
}
