package edu.sdccd.cisc191;

import edu.sdccd.cisc191.generics.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class TestCollections {

    @Test
    void testArray()
    {
        // Initial array
        String[] initialArray = {"A", "B", "C"};

        // Test ArrayProducer: insert "X" at index 1
        ArrayProducer producer = new ArrayProducer(initialArray);
        producer.produce(1, "X");
        String[] producedArray = producer.getArray();
        assertArrayEquals(new String[]{"A", "X", "B", "C"}, producedArray, "Element should be inserted at index 1");

        // Test ArrayConsumer: consume (remove) the first element
        ArrayConsumer consumer = new ArrayConsumer(producedArray);
        String consumed = consumer.consume();
        assertEquals("A", consumed, "First element should be consumed");
        assertArrayEquals(new String[]{"X", "B", "C"}, consumer.getArray(), "Array should have first element removed");

        // Test consuming all elements
        consumer.consume(); // removes "X"
        consumer.consume(); // removes "B"
        String last = consumer.consume(); // removes "C"
        assertEquals("C", last, "Last element should be 'C'");
        assertArrayEquals(new String[]{}, consumer.getArray(), "Array should be empty");

        // Test consuming from empty array
        assertNull(consumer.consume(), null);// Check if consumer still works
    }

    @Test
    void testArrayList()
    {
        ArrayList<String> list = new ArrayList<>();

        ArrayListProducer producer = new ArrayListProducer(list);
        ArrayListConsumer consumer = new ArrayListConsumer(list);

        producer.produce(0, "1st");
        producer.produce(1, "3rd");
        producer.produce(1, "2nd");

        assertEquals("1st", consumer.consume());

        producer.produce(1, "4th");

        assertEquals("2nd", consumer.consume());
        assertEquals("4th", consumer.consume());
        assertEquals("3rd", consumer.consume());
    }

    @Test
    void testHashMap()
    {
        HashMap<String, String> map = new HashMap<>();

        HashMapProducer producer = new HashMapProducer(map);
        HashMapConsumer consumer = new HashMapConsumer(map);

        producer.produce("Java", ".java");
        producer.produce("C", ".c");
        producer.produce("C++", ".cpp");

        assertEquals(".java", consumer.consume("Java"));

        producer.produce("Python", ".pyc");
        producer.produce("Python", ".py");

        assertEquals(".py", consumer.consume("Python"));
    }

    @Test
    void testHashSet()
    {
        HashSet<String> set = new HashSet<>();

        HashSetProducer producer = new HashSetProducer(set);
        HashSetConsumer consumer = new HashSetConsumer(set);

        producer.produce(".java");
        producer.produce(".c");
        producer.produce(".cpp");

        assertEquals(3, set.size());
        assertTrue(consumer.consume(".java"));
        assertEquals(2, set.size());

        producer.produce(".py");
        assertFalse(producer.produce(".py"));
        assertEquals(3, set.size());
    }
}