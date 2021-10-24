package week5.queues;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int INT_CAPACITY = 8;

    private Item[] queue;
    private int number;

    public RandomizedQueue() {
        queue = (Item[]) new Object[INT_CAPACITY];
        number = 0;
    }

    public boolean isEmpty() {
        return number == 0;
    }

    public int size() {
        return number;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        System.arraycopy(queue, 0, copy, 0, number);
        queue = copy;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (number == queue.length) resize(2 * queue.length);
        queue[number++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int randomIndex = StdRandom.uniform(number);
        Item item = queue[randomIndex];
        queue[randomIndex] = queue[--number];
        queue[number] = null;
        if (number > 0 && number == queue.length / 4) resize(queue.length / 2);
        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return queue[StdRandom.uniform(number)];
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i;
        private int[] randomIndices;

        public ArrayIterator() {
            i = 0;
            randomIndices = new int[number];
            for (int j = 0; j < number; j++) {
                randomIndices[j] = j;
            }
            StdRandom.shuffle(randomIndices);
        }

        public boolean hasNext() {
            return i < number;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return queue[randomIndices[i++]];
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(5);
        queue.enqueue(1);
        queue.enqueue(8);
        queue.enqueue(4);
        queue.enqueue(3);
        System.out.println(queue.size());
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        System.out.println(queue.sample());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.size());
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
    }
}
