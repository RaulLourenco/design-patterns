package br.com.design.patterns.behavioral.chainofresponsibility.discount;

public class DiscountApplication {
    public static void main(String[] args) {
        // Build the approval chain
        Approver manager = new ManagerApprover();
        Approver director = new DirectorApprover();
        Approver vicePresident = new VicePresidentApprover();

        manager.setNextApprover(director);
        director.setNextApprover(vicePresident);

        // Create discount requests
        DiscountRequest firstRequest = new DiscountRequest(5);
        DiscountRequest secondRequest = new DiscountRequest(15);
        DiscountRequest thirdRequest = new DiscountRequest(25);
        DiscountRequest fourthRequest = new DiscountRequest(35);

        // Process the discount requests
        manager.processRequest(firstRequest);
        manager.processRequest(secondRequest);
        manager.processRequest(thirdRequest);
        manager.processRequest(fourthRequest);
    }
}

// Request class
class DiscountRequest {
    private double discount;

    public DiscountRequest(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}

// Abstract handler
abstract class Approver {
    protected Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void processRequest(DiscountRequest request);
}

// Concrete handler
class ManagerApprover extends Approver {
    @Override
    public void processRequest(DiscountRequest request) {
        if (request.getDiscount() <= 10) {
            System.out.println("Manager approved discount of " + request.getDiscount() + "%");
        } else if (nextApprover != null) {
            nextApprover.processRequest(request);
        }
    }
}

class DirectorApprover extends Approver {
    @Override
    public void processRequest(DiscountRequest request) {
        if (request.getDiscount() <= 20) {
            System.out.println("Director approved discount of " + request.getDiscount() + "%");
        } else if (nextApprover != null) {
            nextApprover.processRequest(request);
        }
    }
}

class VicePresidentApprover extends Approver {
    @Override
    public void processRequest(DiscountRequest request) {
        if (request.getDiscount() <= 30) {
            System.out.println("Vice President approved discount of " + request.getDiscount() + "%");
        } else {
            System.out.println("Discount of " + request.getDiscount() + "% is too high for approval.");
        }
    }
}