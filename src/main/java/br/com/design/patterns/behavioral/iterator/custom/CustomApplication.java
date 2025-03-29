package br.com.design.patterns.behavioral.iterator.custom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomApplication {
    public static void main(String[] args) {
        NumberCollection collection = new NumberCollection(5);
        collection.add(10);
        collection.add(20);
        collection.add(30);

        // Using the iterator
        for(Integer num : collection) {
            System.out.println("Number: " + num);
        }
    }
}

// Custom collection
class NumberCollection implements Iterable<Integer> {
    private Integer[] numbers;
    private int size;

    public NumberCollection(int capacity) {
        numbers = new Integer[capacity];
        size = 0;
    }

    public void add(int number) {
        if(size < numbers.length) {
            numbers[size++] = number;
        }
    }
    @Override
    public Iterator<Integer> iterator() {
        return new NumberIterator();
    }

    // Private inner class implementing Iterator
    private class NumberIterator implements Iterator<Integer> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Integer next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return numbers[index++];
        }
    }
}