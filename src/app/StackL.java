package app;

import java.util.EmptyStackException;

public class StackL<T> extends AbstractStack<T> {
    private final List<T> list;

    public StackL(List<T> list) {
        this.list = list;
    }

    @Override
    public void push(T element) {
        list.add(element);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        size--;
        return list.removeLast();
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return list.getLast();
    }
}
