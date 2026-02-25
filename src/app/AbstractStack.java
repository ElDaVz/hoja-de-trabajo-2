package app;

public abstract class AbstractStack<T> implements Stack<T> {
    protected int size;

    protected AbstractStack() {
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}