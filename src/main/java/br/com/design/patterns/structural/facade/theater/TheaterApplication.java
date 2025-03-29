package br.com.design.patterns.structural.facade.theater;

public class TheaterApplication {
    public static void main(String[] args) {
        PopcornPopper popper = new PopcornPopper();
        Projector projector = new Projector();
        Amplifier amplifier = new Amplifier();
        DVDPlayer dvdPlayer = new DVDPlayer();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(popper, projector, amplifier, dvdPlayer);
        homeTheater.watchMovie("Inception");
        System.out.println("\nThe end.");
        homeTheater.endMovie();
    }
}

// Subsystem classes
class PopcornPopper {
    public void on() { System.out.println("Popcorn popper on."); }
    public void pop() { System.out.println("Popping popcorn!"); }
    public void off() { System.out.println("Popcorn popper off."); }
}
class Projector {
    public void on() { System.out.println("Projector on."); }
    public void setInput(String input) { System.out.println("Projector input set to " + input + "."); }
    public void off() { System.out.println("Projector off."); }
}
class Amplifier {
    public void on() { System.out.println("Amplifier on."); }
    public void setVolume(int level) { System.out.println("Amplifier volume set to " + level + "."); }
    public void off() { System.out.println("Amplifier off."); }
}
class DVDPlayer {
    public void on() { System.out.println("DVD Player on."); }
    public void play(String movie) { System.out.println("Playing movie: " + movie); }
    public void stop() { System.out.println("DVD Player stopped."); }
    public void off() { System.out.println("DVD Player off."); }
}

// Facade
class HomeTheaterFacade {
    private PopcornPopper popper;
    private Projector projector;
    private Amplifier amplifier;
    private DVDPlayer dvdPlayer;

    public HomeTheaterFacade(PopcornPopper popper, Projector projector,
                             Amplifier amplifier, DVDPlayer dvdPlayer) {
        this.popper = popper;
        this.projector = projector;
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        projector.on();
        projector.setInput("DVD");
        amplifier.on();
        amplifier.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        dvdPlayer.stop();
        dvdPlayer.off();
        amplifier.off();
        projector.off();
        popper.off();
    }
}