package br.com.design.patterns.behavioral.templatemethod.game;

public class GameApplication {
    public static void main(String[] args) {
        System.out.println("Playing cricket:");
        Game cricket = new Cricket();
        cricket.play();

        System.out.println("\nPlaying football:");
        Game football = new Football();
        football.play();
    }
}

// Abstract class defining the template method
abstract class Game {
    // Template method defining the overall flow; marked final to prevent overriding
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
}

// Concrete subclass
class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket game initialized! Get ready to play.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket game started. Enjoy the match!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket game finished.");
    }
}

class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football game initialized! Kick-off time.");
    }

    @Override
    void startPlay() {
        System.out.println("Football game started. Let the goals begin!");
    }

    @Override
    void endPlay() {
        System.out.println("Football game finished.");
    }
}