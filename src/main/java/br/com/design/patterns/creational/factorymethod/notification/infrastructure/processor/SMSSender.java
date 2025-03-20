package br.com.design.patterns.creational.factorymethod.notification.infrastructure.processor;

import br.com.design.patterns.creational.factorymethod.notification.core.service.Notification;
import br.com.design.patterns.creational.factorymethod.notification.core.factory.NotificationSender;
import br.com.design.patterns.creational.factorymethod.notification.infrastructure.service.SMSNotification;

public class SMSSender extends NotificationSender {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
