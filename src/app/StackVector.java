package app;
import java.util.Arrays;
import java.util.EmptyStackException;

public class StackVector<T> implements Stack<T> {
    private T[] items;
    private int top = - 1;

    public StackVector(int capacity) {
        items =  (T[]) new Object[capacity];
    }

    @Override
    public void push(T element) {
        if (top + 1 == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        top++;
        items[top] = element;
    }

    @Override
    public T pop() {
        if (top == - 1) {
            throw new EmptyStackException();
        }
        var item = items[top];
        items[top] = null;
        top--;
        return item;
    }

    @Override
    public T peek() {
        if (top == - 1){
            throw new EmptyStackException();
        }

        return items[top];
    }

    public int getTop() {
        return top;
    }
}
