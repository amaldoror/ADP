package ad_1_5;

/**
 * Factory für folgende Algorithmen: <br>
 * type 1: QuickFind(n) <br>
 * type 2: QuickUnion(n) <br>
 * type 3: WeightedQuickUnion(n) <br>
 * type 4: QuickUnionWithPathCompression(n) <br>
 */
public class UnionFindFactory {

    /**
     * Get an Instance of specified type: <br>
     * type 1: QuickFind(n) <br>
     * type 2: QuickUnion(n) <br>
     * type 3: WeightedQuickUnion(n) <br>
     * type 4: QuickUnionWithPathCompression(n) <br>
     */
    public static UF getInstance(int type, int n) {
        switch (type) {
            case 1:
                return new QuickFind(n);
            case 2:
                return new QuickUnion(n);
            case 3:
                return new WeightedQuickUnion(n);
           // case 4:
           //     return new QuickUnionWithPathCompression(n);
            default:
                throw new IllegalArgumentException("unbekannter UF Algorithmus");
        }
    }
}
