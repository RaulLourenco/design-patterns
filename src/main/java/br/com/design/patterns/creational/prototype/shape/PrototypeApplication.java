package br.com.design.patterns.creational.prototype.shape;

import java.util.ArrayList;
import java.util.List;

public class PrototypeApplication {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Circle circle = new Circle();
        circle.setX(10);
        circle.setY(10);
        circle.setRadius(20);
        shapes.add(circle);

        Circle anotherCircle = circle.cloneShape();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(20);
        shapes.add(rectangle);

        for(Shape shape : shapes) {
            System.out.printf("Printing shapes. This shape is a %s\n", shape.getClass().getSimpleName());
        }
    }
}

abstract class Shape {
    private int X;
    private int Y;
    private String color;

    Shape() {}
    Shape(Shape source) {
        this();
        this.X = source.X;
        this.Y = source.Y;
        this.color = source.color;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public void setColor(String color) {
        this.color = color;
    }

    abstract Shape cloneShape();
}

class Rectangle extends Shape {
    private int width;
    private int height;

    Rectangle() {}
    Rectangle(Rectangle source) {
        super(source);
        this.width = source.width;
        this.height = source.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    Rectangle cloneShape() {
        return new Rectangle(this);
    }
}

class Circle extends Shape {
    private int radius;
    Circle() {}

    Circle(Circle source) {
        super(source);
        this.radius = source.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    Circle cloneShape() {
        return new Circle(this);
    }
}