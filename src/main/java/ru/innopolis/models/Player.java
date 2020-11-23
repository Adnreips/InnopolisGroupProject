package ru.innopolis.models;

import lombok.*;
import ru.innopolis.services.games.Game;
import ru.innopolis.services.games.Play;

import javax.persistence.*;


@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
@Table(name = "players", uniqueConstraints = @UniqueConstraint(columnNames = {"nickName"}))
public class Player implements Play {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Long saloonTime; //время для салуна//
    private Long restTime; //время для отдыха//
    private Integer point; //повышалки характеристик//

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Override
    public void play(Game game) {
         game.executeGame();
    }
}
