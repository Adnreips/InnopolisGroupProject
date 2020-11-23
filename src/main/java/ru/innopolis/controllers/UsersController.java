package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.innopolis.repositories.UsersRepository;
import ru.innopolis.services.BannedPlayerService;


@Controller
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(value = "/users")
    public String getUsersPage(ModelMap model, Authentication authentication) {

        model.addAttribute("usersFromServer", usersRepository.findAll());
        return "users";
    }

}
