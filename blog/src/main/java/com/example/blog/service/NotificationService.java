package com.example.blog.service;


import com.example.blog.model.Notification;

public interface NotificationService {
    void sendNotification(Notification notification) throws Exception;
}
