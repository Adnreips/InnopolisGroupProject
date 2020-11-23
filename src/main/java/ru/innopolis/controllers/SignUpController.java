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
import ru.innopolis.forms.UserForm;
import ru.innopolis.services.SignUpService;
import javax.validation.Valid;
import java.util.List;


@Controller
public class
SignUpController {

    @Autowired
    private SignUpService service;

    @GetMapping("/signup")
    public String getSignUpPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/";
        }
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@Valid UserForm userForm, BindingResult bindingResult, ModelMap model) {

        if (bindingResult.hasErrors()) {
            String message = "";
            List<ObjectError> allErrors = bindingResult.getAllErrors();

            for (ObjectError error : allErrors) {
                message = error.getDefaultMessage();
                if (message.contains("Имя должно начинаться с большой буквы")) {
                    model.addAttribute("messageFirstName", message);
                }
                if (message.contains("Поле не может быть пустым")) {
                    model.addAttribute("message", message);
                }
            }
            return "signup";
        } else {
            try {
                service.signUp(userForm);
            } catch (DataIntegrityViolationException e){
                model.addAttribute("messageLogin", "Лoгин занят. Введите другое значение.");
                return "signup";
            }
            return "redirect:/login";
        }

    }
}
