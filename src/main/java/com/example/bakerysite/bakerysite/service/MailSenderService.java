package com.example.bakerysite.bakerysite.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
    
    private JavaMailSender mailSender;

    public MailSenderService (JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public void sendConfirmationEmail(String to, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(body);
        mailSender.send(message);

    }
}
