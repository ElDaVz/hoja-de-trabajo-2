package app;

import java.util.NoSuchElementException;

public class SingleLinkedList<T> implements List<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node<T> head;

    public SingleLinkedList() {
        head = null;
    }

    @Override
    public void add(T element) {
        var newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            return;
        }
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    @Override
    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Lista vacía");

        if (head.next == null) {
            var data = head.data;
            head = null;
            return data;
        }

        var current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        var data = current.next.data;
        current.next = null;

        return data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException("Lista vacía");

        var current = head;

        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
