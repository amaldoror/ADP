import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccumulatorClient {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java AccumulatorClient <accumulatorType> [N] [maxValue]");
            return;
        }

        String accumulatorType = args[0];
        int N = 0;
        double maxValue = 0.0;

        if (accumulatorType.equals("0")) {
            if (args.length != 3) {
                System.err.println("Usage: java AccumulatorClient 0 <N> <maxValue>");
                return;
            }
            N = Integer.parseInt(args[1]);
            maxValue = Double.parseDouble(args[2]);
        } else {
            if (args.length != 1) {
                System.err.println("Usage: java AccumulatorClient <N>");
                return;
            }
            N = Integer.parseInt(accumulatorType);
            List<Double> values = readValuesFromStdIn(N);
            maxValue = calculateMaxValue(values);
        }

        if (accumulatorType.equals("0")) {
            SimpleAccumulator accumulator = new SimpleAccumulator(N, maxValue);
            readDataToAccumulator(accumulator);
            System.out.println("Mean: " + accumulator.mean());
        } else {
            VisualAccumulator accumulator = new VisualAccumulator(N, maxValue);
            readDataToAccumulator(accumulator);
            accumulator.draw();
            System.out.println("Mean: " + accumulator.mean());
        }
    }

    private static List<Double> readValuesFromStdIn(int N) {
        List<Double> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextDouble()) {
                values.add(scanner.nextDouble());
            } else {
                System.err.println("Invalid input, expecting double values.");
                return null;
            }
        }
        scanner.close();
        return values;
    }

    private static void readDataToAccumulator(Accumulator accumulator) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextDouble()) {
            double value = scanner.nextDouble();
            accumulator.addDataValue(value);
        }
        scanner.close();
    }

    private static double calculateMaxValue(List<Double> values) {
        double maxValue = Double.MIN_VALUE;
        for (double value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
