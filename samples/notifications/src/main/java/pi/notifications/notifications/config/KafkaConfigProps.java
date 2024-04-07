package pi.notifications.notifications.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "pi.kafka")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KafkaConfigProps {
   private String topic;
}
