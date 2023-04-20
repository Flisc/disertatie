package pi.notifications.notifications.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="notifications_id_seq")
    private Long id;

    private String message;

    private LocalDateTime timestamp;

    private String service;
}
