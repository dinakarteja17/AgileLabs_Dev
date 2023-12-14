package com.agilelabs.service;

import jakarta.mail.MessagingException;

public interface EmailService {

    void sendPasswordResetEmail(String to, String subject, String text) throws MessagingException;

    
}
