package br.com.design.patterns.structural.composite.hierarchy;

import java.util.ArrayList;
import java.util.List;

public class HierarchyApplication {
    public static void main(String[] args) {
        Manager ceo = new Manager("Alice", "CEO");
        Developer dev = new Developer("Bob", "Senior Developer");
        Developer anotherDev = new Developer("Charlie", "Junior Developer");
        ceo.addSubordinate(dev);
        ceo.addSubordinate(anotherDev);

        Manager cto = new Manager("Dave", "CTO");
        Developer consultant = new Developer("Eve", "Consultant");
        cto.addSubordinate(consultant);

        ceo.addSubordinate(cto);
        ceo.showEmployeeDetails();
    }
}

// Component interface
interface Employee {
    void showEmployeeDetails();
}

// Leaf
class Developer implements Employee {
    private String name;
    private String position;

    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }
    @Override
    public void showEmployeeDetails() {
        System.out.println("Developer: " + name + ", " + position);
    }
}

// Composite
class Manager implements Employee {
    private String name;
    private String position;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void addSubordinate(Employee e) {
        subordinates.add(e);
    }

    public void removeSubordinate(Employee e) {
        subordinates.remove(e);
    }
    @Override
    public void showEmployeeDetails() {
        System.out.println("Manager: " + name + ", " + position);
        for(Employee e : subordinates) {
            e.showEmployeeDetails();
        }
    }
}