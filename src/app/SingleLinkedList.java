package app;

import java.util.NoSuchElementException;

public class SingleLinkedList<T> extends AbstractList<T> {
    /**
     * Nodo interno de la lista simplemente encadenada.
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /** Primer nodo de la lista. */
    private Node<T> head;

    /**
     * Constructor: crea una lista vacía.
     */
    public SingleLinkedList() {
        super();
        head = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * {@inheritDoc}
     * @throws NoSuchElementException si la lista está vacía.
     */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista está vacía.");
        }
        T data;
        if (head.next == null) {
            data = head.data;
            head = null;
        } else {
            Node<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            data = current.next.data;
            current.next = null;
        }
        size--;
        return data;
    }

    /**
     * {@inheritDoc}
     * @throws NoSuchElementException si la lista está vacía.
     */
    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista está vacía.");
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }


}
