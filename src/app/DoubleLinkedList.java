package app;

import java.util.NoSuchElementException;
/**
 * Implementación de lista doblemente encadenada genérica.
 * Al mantener referencia al nodo tail, las operaciones de agregar
 * y obtener el último elemento son O(1).
 */
public class DoubleLinkedList<T> extends AbstractList<T> {
    /**
     * Nodo interno de la lista doblemente encadenada.
     */
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedList() {
        super();
        head = null;
        tail = null;
    }

    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista está vacía.");
        }
        T data = tail.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista está vacía.");
        }
        return tail.data;
    }
}
