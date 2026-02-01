package app;
import java.util.Vector;

public class StackVector<T> implements Stack<T> {

    private Vector<T> vector;

    public StackVector() {
        vector = new Vector<>();
    }

    @Override
    public void push(T element) {
        vector.add(element);
    }

    @Override
    public T pop() {
        var lastElement = vector.lastElement();
        vector.remove(lastElement);

        return lastElement;
    }

    @Override
    public T peek() {
        if (vector.isEmpty()) {
            return null;
        }
        return vector.getLast();
    }
}
