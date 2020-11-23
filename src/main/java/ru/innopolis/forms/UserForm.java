package ru.innopolis.forms;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
public class UserForm {

    @Pattern(message = "Имя должно начинаться с большой буквы: ${validatedValue}",
            regexp = "^[A-Z][a-z]*(\\s(([a-z]{1,3})|(([a-z]+\\')?[A-Z][a-z]*)))*$")
    @NotBlank(message = "Поле не может быть пустым")
    private String firstName;

    @NotBlank(message = "Поле не может быть пустым")
    private String lastName;

    @NotBlank(message = "Поле не может быть пустым")
    private String login;

    @NotBlank(message = "Поле не может быть пустым")
    private String password;

}
