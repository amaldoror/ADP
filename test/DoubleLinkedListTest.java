import abgabe02.jonas.DoubleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {
    DoubleLinkedList<String> d = new DoubleLinkedList<>();
    @BeforeEach
    public void beforeEach() {
        d.clear();
    }


    //Fügen Sie Elemente am Ende, am Anfang und in der Mitte der Liste ein.
    @Test
    public void testeAdd() {
        d.add("A");
        assertEquals("A", d.get(0));
        d.add(0,"B");
        assertEquals("B", d.get(0));
        d.add(1,"C");
        assertEquals("C", d.get(1));
        assertEquals("B", d.get(0));
        assertEquals("A", d.get(2));
    }

    //Ändern Sie einen Wert an einem Index.
    @Test
    public void testeChangeValue() {
        d.add("Erster");
        assertEquals("Erster", d.get(0));

        d.set(0, "Anders");
        assertEquals("Anders", d.get(0));
    }

    //Löschen Sie Elemente am Anfang, am Ende und in der Mitte der Liste.
    @Test
    public void testeDelete() {
        d.add("A");
        d.add("B");
        d.add("C");
        d.add("D");

        d.remove(0);
        assertEquals("B", d.get(0));
        assertEquals("C", d.get(1));
        assertEquals("D", d.get(2));
        assertEquals(d.size(), 3);

        d.remove(1);
        assertEquals("B", d.get(0));
        assertEquals("D", d.get(1));
        assertEquals(2, d.size());

        d.remove(d.size() - 1);
        assertEquals("B", d.get(0));
        assertEquals(1, d.size());
    }

    //Löschen Sie die Liste vollständig (mit clear).
    @Test
    public void testeClear() {
        d.add("A");
        d.add("B");
        d.add("C");
        d.add("D");

        assertEquals("A", d.get(0));
        assertEquals("B", d.get(1));
        assertEquals("C", d.get(2));
        assertEquals("D", d.get(3));

        d.clear();
        assertEquals(0, d.size());
    }


    //Iterieren Sie über die Liste und geben Sie die enthaltenen Elemente aus.
    @Test
    public void testeIteration() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "A",
                "B",
                "C",
                "D"));

        d.addAll(list);

        for (String s : d) {
            assertTrue(list.contains(s));
            System.out.print(s + "|");
        }
        System.out.println();
    }

    //Erzeugen Sie einen Stream auf der Liste und geben Sie die enthaltenen Elemente aus.
    @Test
    public void testeStream() {
        d.stream().forEach(i -> System.out.print(i + "|"));
    }

    //Wandeln Sie den Inhalt der Liste in ein Array um
    @Test
    public void testeUmwandlungArray() {
        Object[] array = d.toArray();
    }

    //Wandeln Sie eine Menge und eine ArrayList in eine DoublyLinkedList um.
    // (Dazu benötigen wir den verallgemeinerten Kopier-Konstruktor!)
    @Test
    public void testeKopierKonstruktor() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        DoubleLinkedList<String> newD = new DoubleLinkedList<>(list);

        assertEquals("A", newD.get(0));
        assertEquals("B", newD.get(1));
        assertEquals("C", newD.get(2));
        assertEquals("D", newD.get(3));
        assertEquals(4, newD.size());
    }










}

