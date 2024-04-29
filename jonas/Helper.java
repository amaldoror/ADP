package adp.jonas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    public static ArrayList<Integer> getIntegersListFromStdIn() {
        ArrayList<Integer> integers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(line);
                // Extrahiere Zahlen und konvertiere sie in Integer
                while (matcher.find()) {
                    String match = matcher.group();
                    integers.add(Integer.parseInt(match));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integers;
    }
}
