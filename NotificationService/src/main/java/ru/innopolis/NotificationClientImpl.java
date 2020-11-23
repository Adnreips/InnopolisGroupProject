package ru.innopolis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


public class NotificationClientImpl implements NotificationClient {

    @Autowired
    public JavaMailSender emailSender;
    @Override
    public Boolean notifyUser(SimpleMailMessage message) {
        this.emailSender.send(message);
        return true;
    }

}
