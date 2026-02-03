package app;
/**
 * Representa el Tipo de Dato Abstracto Pila (Stack).
 *
 * @param <T> Tipo de los elementos almacenados en la pila.
 */

public interface Stack<T> {

    void push(T element);

    T pop();

    T peek();
}