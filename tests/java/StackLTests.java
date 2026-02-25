import app.Stack;
import app.StackL;
import app.SingleLinkedList;
import app.DoubleLinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackLTests {
    public StackLTests() {}

    private Stack<Integer> stackSingle;
    private Stack<Integer> stackDouble;

    @BeforeEach
    void setUp() {
        stackSingle = new StackL<>(new SingleLinkedList<>());
        stackDouble = new StackL<>(new DoubleLinkedList<>());
    }

    // --- SingleLinkedList ---

    @Test
    void verifyStackPush_Singly() {
        stackSingle.push(1);
        assertEquals(1, stackSingle.peek(), "stack should be pushed and contain int 1");
    }

    @Test
    void verifyStackPop_Singly() {
        stackSingle.push(1);
        stackSingle.pop();
        stackSingle.push(2);
        assertEquals(2, stackSingle.peek(), "stack should be pushed and contain int 2");
    }

    @Test
    void verifyStackPopOnEmptyThrowsException_Singly() {
        assertThrows(EmptyStackException.class, () -> stackSingle.pop(), "stack should be empty and throw the EmptyStackException");
    }

    // --- DoubleLinkedList ---

    @Test
    void verifyStackPush_Doubly() {
        stackDouble.push(1);
        assertEquals(1, stackDouble.peek(), "stack should be pushed and contain int 1");
    }

    @Test
    void verifyStackPop_Doubly() {
        stackDouble.push(1);
        stackDouble.pop();
        stackDouble.push(2);
        assertEquals(2, stackDouble.peek(), "stack should be pushed and contain int 2");
    }

    @Test
    void verifyStackPopOnEmptyThrowsException_Doubly() {
        assertThrows(EmptyStackException.class, () -> stackDouble.pop(), "stack should be empty and throw the EmptyStackException");
    }
}
