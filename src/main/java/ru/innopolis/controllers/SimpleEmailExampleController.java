package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.NotificationClient;

@Controller
public class SimpleEmailExampleController {

    @Autowired
    NotificationClient service;

    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail() {

        try{
            SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("109a@mail.ru");
        message.setSubject("Тестовое письмо");
        message.setText("Привет из игры");
        service.notifyUser(message);
        }catch (Exception o){

        }


        return "redirect:/";
    }

}
