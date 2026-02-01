package tests;
import app.Stack;
import app.StackVector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import app.Reader;

import static org.junit.jupiter.api.Assertions.*;

public class StackTests {
    public StackTests() {}

    private Stack<Integer> stack;
    private final String path = "C:\\Users\\Danri\\Documents\\datos.txt";

    @BeforeEach
    void setUp() {
        stack = new StackVector<>();
        var line = Reader.readFile(path);
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
        assertNull(stack.peek(), "stack should be popped");
        stack.push(2);
        assertEquals(2, stack.peek(), "stack should be pushed and contain int 2");
    }

    @Test
    void verifyStack
}
