package br.com.design.patterns.structural.flyweight.forest;

import java.util.HashMap;
import java.util.Map;

public class ForestApplication {
    public static void main(String[] args) {
        // Create several trees in a forest, reusing tree types when possible
        Tree[] forest = new Tree[3];
        forest[0] = new Tree(10, 20, TreeFactory.getTreeType("Oak", "Green", "Rough"));
        forest[1] = new Tree(30, 40, TreeFactory.getTreeType("Oak", "Green", "Rough"));
        forest[2] = new Tree(50, 60, TreeFactory.getTreeType("Pine", "Dark Green", "Smooth"));

        for(Tree tree : forest) {
            tree.draw();
        }
    }
}

// The Flyweight class that stores the intrinsic state (shared)
class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing a " + name + " tree at (" + x + ", " + y + ") with color "
                + color + " and texture " + texture + ".");
    }
}

// The Flyweight factory caches and reuses TreeType objects
class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;
        TreeType type = treeTypes.get(key);
        if(type == null) {
            type = new TreeType(name, color, texture);
            treeTypes.put(key, type);
        }
        return type;
    }
}

// The context class that stores extrinsic state (unique)
class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}