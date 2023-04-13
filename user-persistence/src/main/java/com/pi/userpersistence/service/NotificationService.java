package com.pi.userpersistence.service;

import com.pi.userpersistence.model.Notification;

public interface NotificationService {
    void publishNotification(Notification notification);
}
