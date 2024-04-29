package adp;

import java.io.InputStream;
import java.util.Scanner;

public class NPlusEvenFilter {
    public void filter(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num > 0 && num % 2 == 0) {
                System.out.println(num);
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        NPlusEvenFilter filter = new NPlusEvenFilter();
        filter.filter(System.in);
    }
}
