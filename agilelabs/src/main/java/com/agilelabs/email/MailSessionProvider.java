package com.agilelabs.email;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

@Component
public class MailSessionProvider {

    private final String emailHost;
    private final String emailPort;
    private final String emailAuth;
    private final String startTlsEnable;
    private final String emailAuthUsername;
    private final String emailAuthPassword;

    public MailSessionProvider(
            @Value("${spring.mail.host}") String emailHost,
            @Value("${spring.mail.port}") String emailPort,
            @Value("${spring.mail.auth}") String emailAuth,
            @Value("${spring.mail.starttls.enable}") String startTlsEnable,
            @Value("${spring.mail.username}") String emailAuthUsername,
            @Value("${spring.mail.password}") String emailAuthPassword) {
        this.emailHost = emailHost;
        this.emailPort = emailPort;
        this.emailAuth = emailAuth;
        this.startTlsEnable = startTlsEnable;
        this.emailAuthUsername = emailAuthUsername;
        this.emailAuthPassword = emailAuthPassword;
    }

    public Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", emailHost);
        props.put("mail.smtp.port", emailPort);
        props.put("mail.smtp.auth", emailAuth);
        props.put("mail.smtp.starttls.enable", startTlsEnable);

        return Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAuthUsername, emailAuthPassword);
            }
        });
    }
}
