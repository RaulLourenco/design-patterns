package br.com.design.patterns.behavioral.mediator.airtraffic;

import java.util.ArrayList;
import java.util.List;

public class AirTrafficApplication {
    public static void main(String[] args) {
        ATCMediator mediator = new AirTrafficControlTower();
        Aircraft plane = new Airplane(mediator, "A1");
        Aircraft anotherPlane = new Airplane(mediator, "B2");
        Aircraft smallPlane = new Airplane(mediator, "C3");

        mediator.registerPlane(plane);
        mediator.registerPlane(anotherPlane);
        mediator.registerPlane(smallPlane);

        // Airplane A1 sends a message to all other planes
        plane.send("Requesting landing clearance.");
    }
}

// Mediator interface
interface ATCMediator {
    void registerPlane(Aircraft plane);
    void sendMessage(String message, Aircraft plane);
}

// Concrete Mediator
class AirTrafficControlTower implements ATCMediator {
    private List<Aircraft> aircrafts = new ArrayList<>();
    @Override
    public void registerPlane(Aircraft plane) {
        if(!aircrafts.contains(plane)) {
            aircrafts.add(plane);
        }
    }

    @Override
    public void sendMessage(String message, Aircraft plane) {
        for (Aircraft ac : aircrafts) {
            // Skip sending the message to the sender
            if (ac != plane) {
                ac.receive(message);
            }
        }
    }
}

// Abstract colleague
abstract class Aircraft {
    protected ATCMediator mediator;
    protected String id;

    public Aircraft(ATCMediator mediator, String id) {
        this.mediator = mediator;
        this.id = id;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

// Concrete colleague
class Airplane extends Aircraft {
    public Airplane(ATCMediator mediator, String id) {
        super(mediator, id);
    }
    @Override
    public void send(String message) {
        System.out.println("Airplane " + id + " send message: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println("Airplane " + id + " receives message: " + message);
    }
}