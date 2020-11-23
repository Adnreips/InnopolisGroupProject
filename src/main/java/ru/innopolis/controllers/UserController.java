package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.innopolis.models.User;
import ru.innopolis.repositories.UsersRepository;
import ru.innopolis.services.BannedPlayerService;
import ru.innopolis.transfer.UserDto;

import static ru.innopolis.transfer.UserDto.from;


@Controller
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BannedPlayerService bannedPlayerService;

    @GetMapping(value = "/users/{userId}")
    public String getUsersPage(ModelMap model, @PathVariable Long userId) {
        UserDto user = from(usersRepository.getOne(userId));
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping("/users/{userId}")
    public String bannedUsers(ModelMap model, @PathVariable Long userId) {
        if (userId != 11) {
            bannedPlayerService.bannedUser(userId);
        } else {
            UserDto user = from(usersRepository.getOne(userId));
            model.addAttribute("user", user);
            model.addAttribute("message", "Админа банить нельзя");
            return "user";
        }
        return "redirect:/users";
    }

    @PostMapping("/users/restore/{userId}")
    public String restoreUser(ModelMap model, @PathVariable Long userId) {
        if (userId != 11) {
            bannedPlayerService.restoreUser(userId);
        } else {
            UserDto user = from(usersRepository.getOne(userId));
            model.addAttribute("user", user);
            model.addAttribute("message1", "Админа нельзя редактировать");
            return "user";
        }
        return "redirect:/users";
    }
}
