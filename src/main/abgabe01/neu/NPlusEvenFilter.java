package abgabe01.neu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NPlusEvenFilter {
    public static void filterAndPrint(List<Integer> list)  {
        list = list.stream().filter(n -> n > 0 && n % 2 == 0)
                .toList();
        for (Integer n : list) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        List<Integer> integers = new ArrayList<>();

        integers = Helper.getIntegersListFromStdIn();
        filterAndPrint(integers);
    }
}
