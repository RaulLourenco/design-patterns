package br.com.design.patterns.creational.prototype.robot;

import java.util.ArrayList;
import java.util.List;

public class RobotApplication {
    public static void main(String[] args) {
        HumanoidRobot humanoid = new HumanoidRobot();
        humanoid.setId("H001");
        humanoid.setModel("Beta");
        humanoid.setVoice("Friendly");

        HumanoidRobot clonedHumanoid = humanoid.cloneRobot();
        clonedHumanoid.setId("H002");

        IndustrialRobot industrial = new IndustrialRobot();
        industrial.setId("I001");
        industrial.setModel("Alpha");
        industrial.setTask("Welding");

        IndustrialRobot clonedIndustrial = industrial.cloneRobot();
        clonedIndustrial.setId("I002");

        System.out.println("Original humanoid:");
        humanoid.display();

        System.out.println("\nCloned humanoid:");
        clonedHumanoid.display();

        System.out.println("\nOriginal industrial:");
        industrial.display();

        System.out.println("\nCloned industrial:");
        clonedIndustrial.display();
    }
}

abstract class Robot {
    private String id;
    private String model;
    private final List<String> components;

    public Robot() {
        components = new ArrayList<>();
    }

    public Robot(Robot source) {
        // Since 'id' and 'model' are immutable (String), a shallow-copy strategy works fine.
        // Primitive fields also works with shallow-copy.
        this.id = source.id;
        this.model = source.model;
        // Create a new list and copy each component (Deep Copy). If 'source.components' is passed to 'this.components' directly,
        // it will be only referenced, because 'components' is a List (a mutable object).
        this.components = new ArrayList<>(source.components);
    }

    public abstract Robot cloneRobot();

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void display() {
        System.out.printf("Robot ID: %s, Model: %s\n", id, model);
    }
}

class HumanoidRobot extends Robot {
    private String voice;

    HumanoidRobot() {}

    HumanoidRobot(HumanoidRobot source) {
        super(source);
        this.voice = source.voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    @Override
    public HumanoidRobot cloneRobot() {
        return new HumanoidRobot(this);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Voice: " + voice);
    }
}

class IndustrialRobot extends Robot {
    private String task;

    IndustrialRobot() {}

    IndustrialRobot(IndustrialRobot source) {
        super(source);
        this.task = source.task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public IndustrialRobot cloneRobot() {
        return new IndustrialRobot(this);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Task: " + task);
    }
}