package br.com.design.patterns.behavioral.strategy.sort;

public class SortApplication {
    public static void main(String[] args) {
        int[] data = { 34, 7, 23, 32, 5, 62};

        // Use Bubble Sort strategy
        Sorter sorter = new Sorter(new BubbleSortStrategy());
        sorter.sortArray(data);
        System.out.print("Sorted array: ");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Switch to Quick Sort strategy
        int[] anotherArray = { 34, 7, 23, 32, 5, 62};
        sorter.setStrategy(new QuickSortStrategy());
        sorter.sortArray(anotherArray);
        System.out.print("Sorted array: ");
        for (int num : anotherArray) {
            System.out.print(num + " ");
        }
    }
}

// Strategy interface
interface SortStrategy {
    void sort(int[] array);
}

// Concrete Strategy
class BubbleSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Bubble Sort");
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

class QuickSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Quick Sort");
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if(low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if(array[j] < pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap array[i + 1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

// Context class
class Sorter {
    private SortStrategy strategy;

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortArray(int[] array) {
        strategy.sort(array);
    }
}