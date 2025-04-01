package br.com.design.patterns.behavioral.state.vendingmachine;

public class VendingMachineApplication {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.selectItem(); // No coin inserted
        machine.insertCoin(); // Insert coin
        machine.insertCoin(); // Coin already inserted
        machine.selectItem(); // Item selected, state moves to Sold
        machine.dispense(); // Dispense item and return to NoCoin state
        machine.ejectCoin(); // No coin to eject
    }
}

// State interface
interface VendingMachineState {
    void insertCoin(VendingMachine machine);
    void ejectCoin(VendingMachine machine);
    void selectItem(VendingMachine machine);
    void dispense(VendingMachine machine);
}

// Concrete State
class NoCoinState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin inserted.");
        machine.setState(new HasCoinState());
    }

    @Override
    public void ejectCoin(VendingMachine machine) {
        System.out.println("No coin to eject.");
    }

    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Insert coin first.");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("No coin inserted. Cannot dispense.");
    }
}
class HasCoinState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin already inserted.");
    }

    @Override
    public void ejectCoin(VendingMachine machine) {
        System.out.println("Coin returned.");
        machine.setState(new NoCoinState());
    }

    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Item selected.");
        machine.setState(new SoldState());
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("No item selected yet.");
    }
}
class SoldState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Please wait, dispensing item.");
    }

    @Override
    public void ejectCoin(VendingMachine machine) {
        System.out.println("Cannot eject coin, item already selected.");
    }

    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Item already selected.");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Dispensing item...");
        machine.setState(new NoCoinState());
    }
}

// Context class
class VendingMachine {
    private VendingMachineState state;

    public VendingMachine() {
        state = new NoCoinState();
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }
    public void insertCoin() {
        state.insertCoin(this);
    }
    public void ejectCoin() {
        state.ejectCoin(this);
    }
    public void selectItem() {
        state.selectItem(this);
    }
    public void dispense() {
        state.dispense(this);
    }
}