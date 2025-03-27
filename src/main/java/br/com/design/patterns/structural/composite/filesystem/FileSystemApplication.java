package br.com.design.patterns.structural.composite.filesystem;

import java.util.ArrayList;
import java.util.List;

public class FileSystemApplication {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        File file = new File("file.txt");
        File anotherFile = new File("another-file.txt");
        root.addItem(file);
        root.addItem(anotherFile);

        Directory subDir = new Directory("sub");
        File pdf = new File("file.pdf");
        subDir.addItem(pdf);
        root.addItem(subDir);

        root.showDetails();
    }
}

// Component interface
interface FileSystemItem {
    void showDetails();
}

// Leaf
class File implements FileSystemItem {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

// Composite
class Directory implements FileSystemItem {
    private String name;
    private List<FileSystemItem> items = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addItem(FileSystemItem item) {
        items.add(item);
    }

    public void removeItem(FileSystemItem item) {
        items.remove(item);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for(FileSystemItem item : items) {
            item.showDetails();
        }
    }
}