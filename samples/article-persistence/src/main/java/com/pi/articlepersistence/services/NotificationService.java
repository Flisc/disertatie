package com.pi.articlepersistence.services;


import com.pi.articlepersistence.models.Notification;

public interface NotificationService {
    void publishNotification(Notification notification);
}
