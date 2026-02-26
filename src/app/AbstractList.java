package app;

/**
 * Clase abstracta que provee comportamiento base para implementaciones de lista.
 *
 * @param <T> Tipo de dato que almacenará la lista.
 * @author Dani
 * @version 1.0
 */
public abstract class AbstractList<T> implements List<T> {

    /** Número de elementos en la lista. */
    protected int size;

    /**
     * Constructor base que inicializa el tamaño en cero.
     */
    protected AbstractList() {
        this.size = 0;
    }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public int size() { return size; }

    @Override
    public abstract void add(T element);

    @Override
    public abstract T removeLast();

    @Override
    public abstract T getLast();
}