package br.com.design.patterns.creational.factorymethod.notification.infrastructure;

import br.com.design.patterns.creational.factorymethod.notification.core.Notification;
import br.com.design.patterns.creational.factorymethod.notification.core.NotificationSender;

public class EmailSender extends NotificationSender {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
