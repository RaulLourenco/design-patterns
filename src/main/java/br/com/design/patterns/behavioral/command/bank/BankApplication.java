package br.com.design.patterns.behavioral.command.bank;

public class BankApplication {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        TransactionInvoker invoker = new TransactionInvoker();

        // Create commands for deposit and withdrawal
        Command depositCommand = new DepositCommand(account, 100);
        Command withdrawCommand = new WithdrawCommand(account, 50);

        // Execute deposit
        invoker.setCommand(depositCommand);
        invoker.executeCommand();

        // Execute withdrawal
        invoker.setCommand(withdrawCommand);
        invoker.executeCommand();

        // Undo withdrawal
        invoker.undoCommand();

        // Undo deposit
        invoker.setCommand(depositCommand);
        invoker.undoCommand();
    }
}

// Command interface
interface Command {
    void execute();
    void undo();
}

// Receiver
class BankAccount {
    private int balance = 0;

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ", Balance: " + balance);
    }

    public void withdraw(int amount) {
        balance -= amount;
        System.out.println("Withdrew " + amount + ", Balance: " + balance);
    }
}

// Concrete Command
class DepositCommand implements Command {
    private BankAccount account;
    private int amount;

    public DepositCommand(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }
    @Override
    public void execute() {
        account.deposit(amount);
    }

    @Override
    public void undo() {
        account.withdraw(amount);
    }
}

class WithdrawCommand implements Command {
    private BankAccount account;
    private int amount;

    public WithdrawCommand(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }
    @Override
    public void execute() {
        account.withdraw(amount);
    }

    @Override
    public void undo() {
        account.deposit(amount);
    }
}

// Invoker
class TransactionInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }

    public void undoCommand() {
        command.undo();
    }
}