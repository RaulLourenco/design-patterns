package br.com.design.patterns.creational.factorymethod.notification.core.factory;

import br.com.design.patterns.creational.factorymethod.notification.core.service.Notification;

public abstract class NotificationSender {
    public abstract Notification createNotification();

    public void send(String message) {
        Notification notification = createNotification();
        notification.notifyUsers(message);
    }
}
