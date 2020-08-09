package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

public class LevelUpByGoldServiceImpl implements LevelUpByGoldService {

    @Autowired
    private PlayersRepository playersRepository;
    @Autowired
    private LevelUpByExpService levelUpByExpService;
    @Autowired
    private LowHPService lowHPService;

    @Override
    public void levelUp(Player player) {

        long timeCheckin = player.getRestTime();
        long timeNow = System.currentTimeMillis();

        if (timeNow > timeCheckin + 3600000) {

            lowHPService.lowHP(player);

            int gold = player.getGold();
            int exp = player.getExperience();

            if (gold >= 50) {

                gold = gold - 50;
                exp = exp + 100;

                player.setGold(gold);
                player.setLevel(exp);

                playersRepository.save(player);

                levelUpByExpService.levelUpByExp(player);


            } else {
                System.out.println("Мало золота");
            }

        } else {
            System.out.println("Ты все еще отдыхаешь");
        }
    }
}
