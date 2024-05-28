package org.example.articleservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Notification {
    private String _id;
    private String to;
    private String message;
    private Date date;
}
