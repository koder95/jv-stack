package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static class Node<T> {
        private final T value;
        private Node<T> prev;

        private Node(T value) {
            this.value = value;
        }
    }

    private Node<T> top = null;
    private int size = 0;

    public void push(T value) {
        Node<T> top = new Node<>(value);
        top.prev = this.top;
        this.top = top;
        size++;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public T pop() {
        Node<T> currentTop = top;
        T value = peek();
        top = top.prev;
        currentTop.prev = null;
        size--;
        return value;
    }

    public int size() {
        return size;
    }
}
