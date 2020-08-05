package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.Player;


import java.util.List;


/**
 * @author
 */

@Repository
public interface PlayersRepository extends JpaRepository<Player, Long> {
    List<Player> findAllById(Integer user_id);
    Player findByNickName(String nickName);

}