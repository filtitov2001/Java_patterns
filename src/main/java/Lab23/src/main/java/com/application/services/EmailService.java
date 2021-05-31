package com.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.javaMailSender = mailSender;
    }

    @Async
    public void sendInfoAboutSaveObject(String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("servermail781227@gmail.com");
        message.setTo("servermail781227@gmail.com");
        message.setSubject("Save object");
        message.setText(text);
        javaMailSender.send(message);
    }
}