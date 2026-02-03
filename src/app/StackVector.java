package app;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Implementación concreta del ADT Stack utilizando un arreglo dinámico.
 * Esta clase maneja internamente el crecimiento del arreglo
 * y lanza excepciones cuando se realizan operaciones inválidas.
 *
 * @param <T> Tipo de los elementos almacenados en la pila.
 */
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
}
