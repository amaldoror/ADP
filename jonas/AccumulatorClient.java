package adp.jonas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AccumulatorClient {


    public static void main(String[] args) {
        int version,trials,maxValue;
        List<Integer> integers = new ArrayList<>();
        if (args.length == 3) {
            version = Integer.parseInt(args[0]);
            trials = Integer.parseInt(args[1]);
            maxValue = Integer.parseInt(args[2]);
            integers = Helper.getIntegersListFromStdIn();
        }
        else if (args.length == 1) {
            version = Integer.parseInt(args[0]);
            integers = Helper.getIntegersListFromStdIn();
            maxValue = Collections.max(integers);
            trials = integers.size();

        }
        else {
            System.out.println("""
                    Usage: java AccumulatorClient <version> <trials> <maxValue> \

                     OR \

                     java AccumulatorClient <version> <trials>""");
            return;
        }



        if(version == 0) {
            SimpleAccumulator simAccum = new SimpleAccumulator();
            for (Integer value : integers) {
                simAccum.addDataValue(value);
            }

        }
        else {
            VisualAccumulator visAccum = new VisualAccumulator(trials,maxValue);
            for (Integer value : integers) {
                visAccum.addDataValue(value);
            }
        }
    }
}
