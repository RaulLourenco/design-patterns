package br.com.design.patterns.behavioral.memento.texteditor;

import java.util.Stack;

public class TextEditorApplication {
    public static void main(String[] args) {
        Editor editor = new Editor();
        EditorHistory history = new EditorHistory();

        // Set initial state
        editor.setText("Version 1: Hello World!");
        System.out.println("Current text: " + editor.getText());
        history.saveState(editor.createMemento());

        // Modify state
        editor.setText("Version 2: Hello Memento!");
        System.out.println("Current text: " + editor.getText());
        history.saveState(editor.createMemento());

        // Modify state again
        editor.setText("Version 3: Another change!");
        System.out.println("Current text: " + editor.getText());

        // Undo the last change
        EditorMemento memento = history.undo();
        if(memento != null) {
            editor.restore(memento);
            System.out.println("After undo: " + editor.getText());
        }

        // Undo again
        memento = history.undo();
        if(memento != null) {
            editor.restore(memento);
            System.out.println("After second undo: " + editor.getText());
        }
    }
}

// Memento class: Stores the state of the Editor
class EditorMemento {
    private final String text;

    public EditorMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

// Originator: The Editor that creates and restores its memento
class Editor {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // Create a memento with the current state
    public EditorMemento createMemento() {
        return new EditorMemento(text);
    }

    // Restore the state from a memento
    public void restore(EditorMemento memento) {
        this.text = memento.getText();
    }
}

class EditorHistory {
    private final Stack<EditorMemento> history = new Stack<>();

    // Save a new memento (state) into the history
    public void saveState(EditorMemento memento) {
        history.push(memento);
    }

    // Undo the last change by popping the last saved memento
    public EditorMemento undo() {
        if(!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}