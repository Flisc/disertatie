package com.example.blog.service.impl;

import com.example.blog.model.Notification;
import com.example.blog.service.NotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final ObjectMapper objectMapper;


    public NotificationServiceImpl(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendNotification(Notification notification) throws Exception {
        try {
            final String payload = objectMapper.writeValueAsString(notification);
            log.info("\n \t Notificare : {}", payload);
        } catch(final JsonProcessingException ex) {
            log.error("\n Notification creation error: {}", ex.getMessage());
            throw new Exception("Unable to publish notification", ex);
        }
    }

}
