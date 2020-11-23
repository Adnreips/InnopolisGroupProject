package ru.innopolis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.innopolis.models.Player;



@Data
@AllArgsConstructor
@Builder
public class PlayerDto {
    private Long id;
    private String nickName;
    private Integer HP; //очки здоровья//
    private Integer MP; //очки действия//
    private Integer experience;//очки опыта//
    private Integer level; //уровень//
    private Integer strength; //сила//
    private Integer charisma; //общение//
    private Integer intelligence; //знание//
    private Integer luck; //удача//
    private Integer gold; //бабки//
    private Integer bandit; //помощник//
    private Long saloonTime; //время//
    private Long restTime;
    private Integer point;

    public static PlayerDto from(Player player) {
        return PlayerDto.builder()
                .id(player.getId())
                .nickName(player.getNickName())
                .HP(player.getHP())
                .MP(player.getMP())
                .experience(player.getExperience())
                .level(player.getLevel())
                .strength(player.getStrength())
                .charisma(player.getCharisma())
                .intelligence(player.getIntelligence())
                .luck(player.getLuck())
                .gold(player.getGold())
                .bandit(player.getBandit())
                .saloonTime(player.getSaloonTime())
                .restTime(player.getRestTime())
                .point(player.getPoint())
                .build();
    }


}
