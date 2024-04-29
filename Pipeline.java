package adp

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Pipeline {
    public static void main(String[] args) {
        int N = 10; // Anzahl der zu generierenden Zufallszahlen
        double min = 1.0; // Mindestwert für Zufallszahlen
        double max = 100.0; // Maximalwert für Zufallszahlen

        // Schritt 1: Zufallszahlen generieren
        String numbers = generateRandomNumbers(N, min, max);

        // Schritt 2: Filtern der geraden Zahlen
        String evenNumbers = filterEvenNumbers(numbers);

        // Schritt 3: Aggregieren und Anzeigen der Daten
        aggregateAndDisplay(evenNumbers);
    }

    private static String generateRandomNumbers(int N, double min, double max) {
        StringBuilder builder = new StringBuilder();
        NumberGenerator generator = new NumberGenerator(N, min, max);
        generator.generateNumbers();
        return builder.toString();
    }

    private static String filterEvenNumbers(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        NPlusEvenFilter filter = new NPlusEvenFilter();
        filter.filter(inputStream);
        return input;
    }

    private static void aggregateAndDisplay(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        AccumulatorClient client = new AccumulatorClient();
        client.main(new String[]{"0"}); // Verwende SimpleAccumulator
        client.main(new String[]{input}); // Nutze die Eingabe von stdin
    }
}
