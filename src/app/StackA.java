package app;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackA<T> implements Stack<T> {
    private ArrayList<T> items;

    public StackA(int capacity) {
        items = new ArrayList<>(capacity);

    }

    @Override
    public T peek() {
        if (items.isEmpty()) {
            throw new EmptyStackException();
        }
        return items.getLast();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public T pop() {
        if (items.isEmpty()) {
            throw new EmptyStackException();
        }
        return items.removeLast();
    }

    @Override
    public void push(T element) {
        items.add(element);
    }

}
