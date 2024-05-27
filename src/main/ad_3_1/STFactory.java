package ad_3_1;

import edu.princeton.cs.algs4.BinarySearchST;

public class STFactory {

    public static STInterface<String, Integer> getSTInstance(int type) {
        switch (type) {
            case 1:
                return null;
            case 2:
                System.out.println("No implementation for type " + type);
                return null;
            default:
                return new SequentialSearchST<>();
        }
    }
}
