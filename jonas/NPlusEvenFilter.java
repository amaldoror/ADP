package adp.jonas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Filtert einen Eingabe-Stream und sortiert alle ungeraden und nicht-Ganzzahlen aus.
 */
public class NPlusEvenFilter {
    public static void filterAndPrint(List<Integer> list)  {
        //Filter alle ungeraden Objekte heraus.
        list = list.stream().filter(n -> n > 0 && n % 2 == 0)
                .toList();
        for (Integer n : list) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> integers = Helper.getIntegersListFromStdIn();
        filterAndPrint(integers);
    }
}
