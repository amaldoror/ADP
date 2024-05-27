package abgabe02;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;



public class DoublyLinkedListTest {
    String[] arr = {"one", "two", "three"};
    DoublyLinkedList<String> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>(Arrays.stream(arr).toList());
    }

    @After
    public void tearDown() {
        list = null;
    }

    // Test insertion at the end, beginning, and middle of the list
    @Test
    public void testInsertion() {
        list.add(list.size(), "four");
        list.add(0, "zero");
        list.add(2, "middle");
        assertEquals("[zero, one, middle, two, three, four]", list.toString());
    }

    // Test modifying a value at a specific index
    @Test
    public void testModification() {
        list.set(1, "modified");
        assertEquals("[one, modified, three]", list.toString());
    }

    // TODO Cannot assign field "prev" because "current.next" is null
    // Test deletion from the beginning, end, and middle of the list
    @Test
    public void testDeletion() {
        list.remove(0);
        list.remove(list.size() - 1);
        list.remove(1);
        assertEquals("[]", list.toString());
    }

    // Test clearing the list
    @Test
    public void testClear() {
        list.clear();
        assertEquals("[]", list.toString());
    }

    // Test iterating over the list and printing its elements
    @Test
    public void testIteration() {
        StringBuilder sb = new StringBuilder();
        for (String element : list) {
            sb.append(element).append(" ");
        }
        assertEquals("one two three ", sb.toString());
    }

    // Test creating a stream from the list and printing its elements
    @Test
    public void testStream() {
        assertEquals("[one, two, three]", list.stream().toList().toString());
    }

    // Test converting the list to an array
    @Test
    public void testToArray() {
        String[] array = list.toArray(new String[0]);
        assertArrayEquals(new String[]{"one", "two", "three"}, array);
    }

    // Test converting a set to DoublyLinkedList
    @Test
    public void testConversionFromSet() {
        // Convert a set to DoublyLinkedList
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        List<Integer> listFromSet = new DoublyLinkedList<>(set.stream().toList());
        assertEquals("[1, 2, 3]", listFromSet.toString());
    }

    // Test converting an ArrayList to DoublyLinkedList
    @Test
    public void testConversionFromArrayList() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("cherry");
        List<String> listFromArrayList = new DoublyLinkedList<>(arrayList.stream().toList());
        assertEquals("[apple, banana, cherry]", listFromArrayList.toString());
    }
}
