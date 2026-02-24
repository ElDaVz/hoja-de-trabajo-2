package app;

/**
 * Define el contrato para una lista genérica.
 * Solo expone las operaciones necesarias para soportar una pila:
 * agregar al final, eliminar el último y consultar el último.
 *
 * @param <T> Tipo de los elementos almacenados en la lista.
 */
public interface List<T> {
    /**
     * Agrega un elemento al final de la lista.
     * @param element elemento a agregar.
     */
    void add(T element);

    /**
     * Elimina y retorna el último elemento de la lista.
     * @return último elemento.
     */
    T removeLast();

    /**
     * Retorna el último elemento sin eliminarlo.
     * @return último elemento.
     */
    T getLast();

    /**
     * Indica si la lista está vacía.
     * @return true si no hay elementos.
     */
    boolean isEmpty();
}
