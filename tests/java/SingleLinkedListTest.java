import app.SingleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SingleLinkedListTest {

    private SingleLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SingleLinkedList<>();
    }

    @Test
    void verifyNewListIsEmpty() {
        assertTrue(list.isEmpty(), "New list should be empty");
    }

    @Test
    void verifyAddIncreasesSize() {
        list.add(1);
        assertEquals(1, list.size(), "Size should be 1 after adding one element");
    }

    @Test
    void verifyGetLastReturnsLastAdded() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.getLast(), "getLast should return the last added element");
    }

    @Test
    void verifyRemoveLastReturnsAndRemoves() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.removeLast(), "removeLast should return last element");
        assertEquals(1, list.size(), "Size should decrease after removeLast");
    }

    @Test
    void verifyRemoveLastOnSingleElement() {
        list.add(5);
        assertEquals(5, list.removeLast());
        assertTrue(list.isEmpty(), "List should be empty after removing only element");
    }

    @Test
    void verifyGetLastOnEmptyThrowsException() {
        assertThrows(NoSuchElementException.class, () -> list.getLast(), "getLast on empty list should throw exception");
    }

    @Test
    void verifyRemoveLastOnEmptyThrowsException() {
        assertThrows(NoSuchElementException.class, () -> list.removeLast(), "removeLast on empty list should throw exception");
    }
}
