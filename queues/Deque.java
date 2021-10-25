package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int number;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }

    public Deque() {
        first = null;
        last = null;
        number = 0;
    }

    public boolean isEmpty() {
        return number == 0;
    }

    public int size() {
        return number;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        first.prev = null;
        if (isEmpty()) last = first;
        else oldFirst.prev = first;
        number++;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        last.prev = oldLast;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        number++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        number--;
        if (isEmpty()) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = last.item;
        number--;
        if (isEmpty()) {
            first = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addLast(4);
        deque.addFirst(3);
        deque.addLast(5);
        for (Integer i : deque) System.out.print(i + " ");
        System.out.print("\n");
        deque.removeFirst();
        deque.removeLast();
        deque.removeFirst();
        for (Integer i : deque) System.out.print(i + " ");
    }
}