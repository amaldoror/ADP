package abgabe02;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;


public class Main {
    private static final int MAX = 1000000;

    public static void main(String[] args){

        for (int N = 250; true; N+=N){
            if (N>=MAX) break;
            // Zeit für Problemgröße N
            double time = trialTime(N);
            StdOut.printf("%10d %5.1f\n",N,time);
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
    private static double trialTime(int N) {
        int MAX = 1000000;
        Integer integer;
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();


        for (int i = 0; i < N; i++){
            integer = StdRandom.uniformInt(-MAX, +MAX);
            list.add(i, integer);
            //System.out.println("i: " + i + " integer: " + integer);
        }


        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < N; i++){
            System.out.println(i);
            System.out.println(list.get(i).toString());
        }

        return timer.elapsedTime();
    }

}
