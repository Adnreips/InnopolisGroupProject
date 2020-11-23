package ru.innopolis.forms;

import lombok.Data;
import javax.validation.constraints.NotBlank;


@Data
public class PlayerForm {

    @NotBlank(message = "Поле не может быть пустым")
    private String nickName;

}
