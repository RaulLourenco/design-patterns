package br.com.design.patterns.creational.factorymethod.notification.infrastructure;

import br.com.design.patterns.creational.factorymethod.notification.core.Notification;
import br.com.design.patterns.creational.factorymethod.notification.core.NotificationSender;

public class SMSSender extends NotificationSender {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
