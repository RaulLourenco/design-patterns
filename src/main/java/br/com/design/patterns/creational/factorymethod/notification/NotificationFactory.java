package br.com.design.patterns.creational.factorymethod.notification;

class NotificationFactory {
    private static NotificationSender notificationSender;
    private static void initialize() {
        String notificationType = "SMS";

        if(notificationType.equals("email")) {
            notificationSender = new EmailSender();
        } else {
            notificationSender = new SMSSender();
        }
    }
    public static void main(String[] args) {
        initialize();
        notificationSender.send("Hello!");
    }
}

abstract class NotificationSender {
    public abstract Notification createNotification();

    public void send(String message) {
        Notification notification = createNotification();
        notification.notifyUsers(message);
    }
}

class EmailSender extends NotificationSender {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSSender extends NotificationSender {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

interface Notification {
    void notifyUsers(String message);
}

class EmailNotification implements Notification {
    @Override
    public void notifyUsers(String message) {
        System.out.printf("Sending an email. Content= %s", message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void notifyUsers(String message) {
        System.out.printf("Sending an SMS. Content= %s", message);
    }
}
