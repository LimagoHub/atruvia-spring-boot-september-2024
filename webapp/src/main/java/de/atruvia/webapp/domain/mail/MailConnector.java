package de.atruvia.webapp.domain.mail;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MailConnector {

    private String smtp;
    private String username;
    private String password;

    public void send( ){

    }

    public void connect( ){

    }
}
