package br.com.design.patterns.behavioral.visitor.filesystem;

import java.util.ArrayList;
import java.util.List;

public class FileSystemApplication {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        root.addElement(new File("file.txt", 10));
        root.addElement(new File("another-file.txt", 20));

        Directory subDir = new Directory("subdir");
        subDir.addElement(new File("one-more-file.txt", 30));
        root.addElement(subDir);

        Directory anotherSubDir = new Directory("another-subdir");
        anotherSubDir.addElement(new File("another-file-subdir.txt", 40));
        root.addElement(anotherSubDir);

        Directory secondRoot = new Directory("second-root");
        secondRoot.addElement(new File("root-file.txt", 50));

        // Use the visitor to display the file system
        FileSystemVisitor displayVisitor = new DisplayFileSystemVisitor();
        root.accept(displayVisitor);
        secondRoot.accept(displayVisitor);
    }
}

// Element interface
interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}

// Visitor interface
interface FileSystemVisitor {
    void visitFile(File file);
    void visitDirectory(Directory directory);
}

// Concrete element
class File implements FileSystemElement {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }
    public int getSize() {
        return size;
    }
    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitFile(this);
    }
}

class Directory implements FileSystemElement {
    private String name;
    private List<FileSystemElement> elements = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }
    public String getName() {
        return name;
    }
    public List<FileSystemElement> getElements() {
        return elements;
    }
    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitDirectory(this);
    }
}

// Concrete visitor
class DisplayFileSystemVisitor implements FileSystemVisitor {
    private int indentLevel = 0;

    private void printIndent() {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("  ");
        }
    }

    @Override
    public void visitFile(File file) {
        printIndent();
        System.out.println("File: " + file.getName() + " (" + file.getSize() + " KB)");
    }

    @Override
    public void visitDirectory(Directory directory) {
        printIndent();
        System.out.println("Directory: " + directory.getName());
        indentLevel++; // Increase indentation for children
        // Visit contained elements
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
        indentLevel--; // Restore previous indentation level
    }
}