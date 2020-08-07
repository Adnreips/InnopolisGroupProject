package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.innopolis.forms.PlayerForm;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;
import ru.innopolis.repositories.UsersRepository;
import ru.innopolis.security.details.UserDetailsImpl;
import ru.innopolis.transfer.UserDto;

import static ru.innopolis.transfer.UserDto.from;

/**
 * CreatPlayerServiceImpl
 *
 * @author "Andrei Prokofiev"
 */

@Service
public class CreatPlayerServiceImpl implements CreatPlayerService {
    @Autowired
    private PlayersRepository playersRepository;

    @Override
    public void signUp(PlayerForm playerForm, Authentication authentication) {
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        Player player = Player.builder()
                .nickName(playerForm.getNickName())
                .HP(125)
                .MP(100)
                .level(1)
                .strength(100)
                .charisma(100)
                .intelligence(100)
                .luck(100)
                .gold(100)
                .user(details.getUser())
                .experience(0)
                .strength(1)
                .charisma(1)
                .intelligence(1)
                .luck(1)
                .gold(10)
                .bandit(0)
                .experience(0)
                .build();
        playersRepository.save(player);

    }

    @Override
    public void deletPlayer(Long id) {
        playersRepository.deleteById(id);
    }


}
