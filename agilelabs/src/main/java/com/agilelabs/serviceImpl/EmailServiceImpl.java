
// EmailService.java
package com.agilelabs.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.agilelabs.email.MailSessionProvider;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl {

    @Autowired
    private MailSessionProvider mailSessionProvider;
    @Value("${spring.mail.username}")
    private String emailSender;
    public void sendPasswordResetEmail(String to, String subject, String text) throws MessagingException {
        Session session = mailSessionProvider.getSession();
        try {
          
          MimeMessage message = new MimeMessage(session);
          message.setFrom(new InternetAddress(emailSender));
          message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
          message.setSubject(subject);
          message.setText(text);
          Transport.send(message);
          
     } catch (MessagingException e) {
          // Print or handle the messaging exception
          e.printStackTrace();
          throw e;
      }
    }
}

