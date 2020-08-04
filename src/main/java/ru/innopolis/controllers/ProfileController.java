package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.innopolis.forms.PlayerForm;
import ru.innopolis.forms.UserForm;
import ru.innopolis.security.details.UserDetailsImpl;
import ru.innopolis.services.CreatPlayerService;
import ru.innopolis.services.SignUpService;
import ru.innopolis.transfer.UserDto;

import javax.validation.Valid;
import java.util.List;

import static ru.innopolis.transfer.UserDto.from;


/**
 *
 */
@Controller
public class ProfileController {

    @Autowired
    private CreatPlayerService service;

    @GetMapping("/")
    public String getProfilePage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        UserDto user = from(details.getUser());
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/")
    public String signUp(@Valid PlayerForm playerForm, BindingResult bindingResult, ModelMap model, Authentication authentication) {

        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        UserDto user = from(details.getUser());
        model.addAttribute("user", user);

        if (bindingResult.hasErrors()) {
            String message = "";
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                message = error.getDefaultMessage();
                if (message.contains("Поле не может быть пустым")) {
                    model.addAttribute("message", message);
                }
            }
            return "profile";
        } else {
            try {
                service.signUp(playerForm, authentication);
            } catch (DataIntegrityViolationException e) {
                model.addAttribute("messageNickName", "NickName занят. Введите другое значение.");
                return "profile";
            }
            return "profile";
        }

    }


}
