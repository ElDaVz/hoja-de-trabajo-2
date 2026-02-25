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
public class StackO<T> extends AbstractStack<T> {
    private T[] items;

    public StackO(int capacity) {
        items =  (T[]) new Object[capacity];
    }

    @Override
    public void push(T element) {
        if (size  == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        this.size++;
        items[size++] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        var item = items[this.size--];
        items[this.size] = null;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return items[size - 1];
    }
}
