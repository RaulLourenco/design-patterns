package br.com.design.patterns.behavioral.memento.game;

public class GameApplication {
    public static void main(String[] args) {
        GameCharacter character = new GameCharacter(5, 100);
        character.displayState();

        // Save state before a difficult battle
        CharacterMemento savedState = character.saveState();

        // Character takes damage and loses levels
        character.setHealth(40);
        character.setLevel(4);
        System.out.println("After battle:");
        character.displayState();

        // Restore to saved state
        character.restoreState(savedState);
        System.out.println("After restoring saved state:");
        character.displayState();
    }
}

// Memento class: Stores the state of the GameCharacter
class CharacterMemento {
    private final int level;
    private final int health;

    public CharacterMemento(int level, int health) {
        this.level = level;
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }
}

// Originator: GameCharacter that can create and restore its memento
class GameCharacter {
    private int level;
    private int health;

    public GameCharacter(int level, int health) {
        this.level = level;
        this.health = health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void displayState() {
        System.out.println("Character state => Level: " + level + ", Health: " + health);
    }

    // Save the current state
    public CharacterMemento saveState() {
        return new CharacterMemento(level, health);
    }

    // Restore the saved state
    public void restoreState(CharacterMemento memento) {
        this.level = memento.getLevel();
        this.health = memento.getHealth();
    }
}