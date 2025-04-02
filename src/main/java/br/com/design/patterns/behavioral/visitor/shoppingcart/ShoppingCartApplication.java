package br.com.design.patterns.behavioral.visitor.shoppingcart;

public class ShoppingCartApplication {
    public static void main(String[] args) {
        ShoppingCartItem[] cartItems = new ShoppingCartItem[] {
                new Book(50, "ISBN-12345"),
                new Fruit(3, 4, "Banana"),
                new Fruit(12, 2, "Kiwi"),
                new Book(30, "ISBN-54321")
        };

        ShoppingCartVisitor visitor = new ShoppingCartTotalVisitor();
        int totalCost = 0;
        for (ShoppingCartItem item : cartItems) {
            totalCost += item.accept(visitor);
        }
        System.out.println("Total cost: $" + totalCost);
    }
}

// Element interface
interface ShoppingCartItem {
    int accept(ShoppingCartVisitor visitor);
}

// Visitor interface
interface ShoppingCartVisitor {
    int visitBook(Book book);
    int visitFruit(Fruit fruit);
}

// Concrete element
class Book implements ShoppingCartItem {
    private int price;
    private String isbn;

    public Book(int price, String isbn) {
        this.price = price;
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }
    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visitBook(this);
    }
}

class Fruit implements ShoppingCartItem {
    private int pricePerKg;
    private int weightInKg;
    private String name;

    public Fruit(int pricePerKg, int weightInKg, String name) {
        this.pricePerKg = pricePerKg;
        this.weightInKg = weightInKg;
        this.name = name;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeightInKg() {
        return weightInKg;
    }

    public String getName() {
        return name;
    }
    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visitFruit(this);
    }
}

// Concrete visitor
class ShoppingCartTotalVisitor implements ShoppingCartVisitor {
    @Override
    public int visitBook(Book book) {
        System.out.println("Book: (ISBN: " + book.getIsbn() + ") price: $" + book.getPrice());
        return book.getPrice();
    }

    @Override
    public int visitFruit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeightInKg();
        System.out.println("Fruit: " + fruit.getWeightInKg() + "kg of " + fruit.getName() + " -> price: $" + cost);
        return cost;
    }
}