package ad_1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Automatisieren des Experiments <br>
 * In jedem Schritt: <br>
 * - Verdoppeln der Problemgröße N <br>
 * - Zeitmessung für Problemgröße N <br>
 */
public class DoublingTest {
    public static void main(String[] args){

        for (int N = 250; true; N+=N){
            // Zeit für Problemgröße N
            double time = trialTime(N);
            StdOut.printf("%7d %5.1f\n",N,time);
        }
    }

    /**
     * - Erzeugen von N Daten (hier 6-stellige Integer) <br>
     * - Stoppuhr starten <br>
     * - Drei-Summen-Problem für N lösen <br>
     * - Zeit messen <br>
     * @param N Anzahl Datenpunkte
     * @return Rückgabewert
     */
    private static double trialTime(int N){
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniformInt(-MAX, +MAX);
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }
}
