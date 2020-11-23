package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.innopolis.forms.UserForm;
import ru.innopolis.models.Role;
import ru.innopolis.models.State;
import ru.innopolis.models.User;
import ru.innopolis.repositories.UsersRepository;


@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {

        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .hashPassword(hashPassword)
                .login(userForm.getLogin())
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();
        usersRepository.save(user);

        if (usersRepository.findAllByFirstName("ADMIN").size() == 0) {
            User admin = User.builder()
                    .firstName("ADMIN")
                    .lastName("ADMIN")
                    .hashPassword(passwordEncoder.encode("123"))
                    .login("ADMIN")
                    .role(Role.ADMIN)
                    .state(State.ACTIVE)
                    .build();
            usersRepository.save(admin);
        }
    }
}
