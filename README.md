# Design Patterns

This repository contains clear and concise Java examples of popular design patterns, organized into three categories: **Creational**, **Structural**, and **Behavioral**. Each example demonstrates a pattern's intent, structure, and usage through simple, self-contained code samples.   

The goal of this project is to help you understand and apply these design patterns in your own projects, as described by resources like [Refactoring.Guru](https://refactoring.guru/design-patterns/catalog) and the [Gang of Four](https://www.amazon.com/Design-Patterns-Object-Oriented-Addison-Wesley-Professional-ebook/dp/B000SEIBB8).


## Design Patterns Covered

### Creational Patterns
- Factory Method
- Abstract Factory
- Builder
- Prototype
- Singleton

### Structural Patterns
- Adapter
- Bridge
- Composite
- Decorator
- Facade
- Flyweight
- Proxy

### Behavioral Patterns
- Chain of Responsibility
- Command
- Iterator
- Mediator
- Memento
- Observer
- State
- Strategy
- Template Method
- Visitor

Each pattern is demonstrated with two example scenarios to illustrate its purpose and implementation details.

## Example Code
Here's a minimal example of defining a Strategy for sorting algorithms.

```java
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
// Concrete Strategy
class QuickSortStrategy implements SortStrategy {
   @Override
   public void sort(int[] array) {
      System.out.println("Sorting using Quick Sort");
      quickSort(array, 0, array.length - 1);
   }

   private void quickSort(int[] array, int low, int high) {
       // Quick sort implementation goes here
   }
   private int partition(int[] array, int low, int high) {
       // Partition implementation goes here
       return low;
   }
}
```

## Project Structure

The repository is organized into folders by pattern category.
```text
src/main/java/br/com/design/patterns/
├── creational/
│   ├── FactoryMethod.java
│   ├── AbstractFactory.java
│   ├── Builder.java
│   ├── Prototype.java
│   └── Singleton.java
├── structural/
│   ├── Adapter.java
│   ├── Bridge.java
│   ├── Composite.java
│   ├── Decorator.java
│   ├── Facade.java
│   ├── Flyweight.java
│   └── Proxy.java
├── behavioral/
│   ├── ChainOfResponsibility.java
│   ├── Command.java
│   ├── Iterator.java
│   ├── Mediator.java
│   ├── Memento.java
│   ├── Observer.java
│   ├── State.java
│   ├── Strategy.java
│   ├── TemplateMethod.java
│   └── Visitor.java
└── README.md
```

## How to Run

Each design pattern example is a standalone Java file (or set of files) that includes a `main()` method. To run an example:

1. **Ensure Java is installed:**  
   Make sure you have [Java JDK 8 or above](https://www.oracle.com/java/technologies/javase-downloads.html) installed.

2. **Compile the Example:**  
   Navigate to the appropriate folder and compile the file. For example:
   ```bash
   javac FactoryMethod.java

3. **Run the Compiled Class:**
    ```bash
    java FactoryMethod

Alternatively, you can import the project into an IDE (e.g., IntelliJ IDEA or Eclipse) and run the examples directly.

## Dependencies
This project uses plain Java without any external libraries. If desired, you can integrate these examples into a Maven or Gradle project for easier management.

## License
This project is licensed under the MIT License. See the LICENSE file for details.