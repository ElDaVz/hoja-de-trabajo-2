package tests;
import app.Stack;
import app.StackO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTests {
    public StackTests() {}

    private Stack<Integer> stack;


    @BeforeEach
    void setUp() {
        stack = new StackO<>(10);

    }

    @Test
    void verifyStackPush() {
        stack.push(1);
        assertEquals(1, stack.peek(), "stack should be pushed and contain int 1");
    }

    @Test
    void verifyStackPop() {
        stack.push(1);
        stack.pop();
        stack.push(2);
        assertEquals(2, stack.peek(), "stack should be pushed and contain int 2");
    }

    @Test
    void verifyStackPopOnEmptyThrowsException() {
        assertThrows(EmptyStackException.class, () -> stack.pop(), "stack should be empty and throw the EmptyStackException");
    }

}
