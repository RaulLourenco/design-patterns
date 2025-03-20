package br.com.design.patterns.creational.factorymethod.notification.infrastructure.service;

import br.com.design.patterns.creational.factorymethod.notification.core.service.Notification;

public class EmailNotification implements Notification {
    @Override
    public void notifyUsers(String message) {
        System.out.printf("Sending an email. Content= %s", message);
    }
}
