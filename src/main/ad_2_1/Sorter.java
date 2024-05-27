package ad_2_1;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;

public enum Sorter {
    SELECTION, INSERTION, SHELL,
    MERGE, MERGEBU,
    QUICK, QUICKINSERTION, QUICKMEDIAN3,QUICKMEDIAN3INSERTION,
    QUICK3WAY, QUICK3WAYINSERTION,
    HEAP;

    public Class<?> getSorterClass() {
        switch (this) {
            case SELECTION:
                return Selection.class;
            case INSERTION:
                return Insertion.class;
            case SHELL:
                return Shell.class;
            case MERGE:
                return Merge.class;
            case MERGEBU:
                return MergeBU.class;
            case QUICK:
                return Quick.class;
            case QUICKINSERTION:
                return null;
            case QUICKMEDIAN3:
                return null;
            case QUICKMEDIAN3INSERTION:
                return null;
            case QUICK3WAY:
                return Quick3way.class;
            case QUICK3WAYINSERTION:
                return null;
            case HEAP:
                return Heap.class;
            default:
                return null;
        }
    }
}
