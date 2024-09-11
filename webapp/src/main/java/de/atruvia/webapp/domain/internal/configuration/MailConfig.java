package de.atruvia.webapp.domain.internal.configuration;


import de.atruvia.webapp.YamlPropertySourceFactory;
import de.atruvia.webapp.domain.mail.MailConnector;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value= "classpath:mail.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "mail")
@Setter
public class MailConfig {

    private String smtp;
    private String username;
    private String password;


    @Bean
    public MailConnector create() {
        return MailConnector
                .builder()
                .smtp(smtp)
                .username(username)
                .password(password)
                .build();
    }
}
