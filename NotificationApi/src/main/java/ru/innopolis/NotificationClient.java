package ru.innopolis;

import org.springframework.mail.SimpleMailMessage;


public interface NotificationClient {

    Boolean notifyUser(SimpleMailMessage message);

}
