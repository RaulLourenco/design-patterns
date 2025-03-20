package br.com.design.patterns.creational.factorymethod.notification.orchestrator;

import br.com.design.patterns.creational.factorymethod.notification.core.NotificationSender;
import br.com.design.patterns.creational.factorymethod.notification.infrastructure.processor.EmailSender;
import br.com.design.patterns.creational.factorymethod.notification.infrastructure.processor.SMSSender;

public class NotificationFactory {
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
