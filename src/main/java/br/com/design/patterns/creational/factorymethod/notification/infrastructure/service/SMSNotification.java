package br.com.design.patterns.creational.factorymethod.notification.infrastructure.service;

import br.com.design.patterns.creational.factorymethod.notification.core.service.Notification;

public class SMSNotification implements Notification {
    @Override
    public void notifyUsers(String message) {
        System.out.printf("Sending a SMS. Content= %s", message);
    }
}
