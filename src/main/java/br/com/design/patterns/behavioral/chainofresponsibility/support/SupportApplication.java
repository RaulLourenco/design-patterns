package br.com.design.patterns.behavioral.chainofresponsibility.support;

public class SupportApplication {
    public static void main(String[] args) {
        // Build the chain
        SupportHandler frontline = new FrontlineSupport();
        SupportHandler technical = new TechnicalSupport();
        SupportHandler manager = new ManagerSupport();

        frontline.setNextHandler(technical);
        technical.setNextHandler(manager);

        // Process tickets
        frontline.handleTicket("Basic issue: Cannot login.");
        frontline.handleTicket("Technical issue: System crash.");
        frontline.handleTicket("Urgent: Account compromised.");
    }
}

// Abstract handler
abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleTicket(String ticket);
}

// Concrete handler
class FrontlineSupport extends SupportHandler {
    @Override
    public void handleTicket(String ticket) {
        if(ticket.toLowerCase().contains("basic")) {
            System.out.println("Frontline support handled ticket: " + ticket);
        } else if(nextHandler != null) {
            nextHandler.handleTicket(ticket);
        }
    }
}

class TechnicalSupport extends SupportHandler {
    @Override
    public void handleTicket(String ticket) {
        if(ticket.toLowerCase().contains("technical")) {
            System.out.println("Technical support handled ticket: " + ticket);
        } else if(nextHandler != null) {
            nextHandler.handleTicket(ticket);
        }
    }
}

// Handles any remaining issues
class ManagerSupport extends SupportHandler {
    @Override
    public void handleTicket(String ticket) {
        System.out.println("Manager handled ticket: " + ticket);
    }
}