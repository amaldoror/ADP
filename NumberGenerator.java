import java.util.Random;

public class NumberGenerator {
    private int N;
    private double min;
    private double max;
    private Random random;

    public NumberGenerator(int N, double min, double max) {
        this.N = N;
        this.min = min;
        this.max = max;
        this.random = new Random();
    }

    public void generateNumbers() {
        for (int i = 0; i < N; i++) {
            if (random.nextBoolean()) {
                int intValue = random.nextInt((int) (max - min + 1)) + (int) min;
                System.out.print(intValue + " ");
            } else {
                double doubleValue = min + (max - min) * random.nextDouble();
                System.out.print(doubleValue + " ");
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java NumberGenerator <N> <min> <max>");
            return;
        }

        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);

        NumberGenerator generator = new NumberGenerator(N, min, max);
        generator.generateNumbers();
    }
}
