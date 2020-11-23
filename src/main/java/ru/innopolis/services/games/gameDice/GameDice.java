package ru.innopolis.services.games.gameDice;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Service;
import ru.innopolis.services.games.Game;


@Service
public class GameDice extends Game {

    private long aLong = System.currentTimeMillis();
    private Random random1 = new Random();
    private SecureRandom random2 = SecureRandom.getInstance("SHA1PRNG","SUN");
    public int throwDice1(){
        int resulDice1 = random1.nextInt(6)+1;
        return resulDice1;
    }

//    public int throwDice2(){
//        int resulDice2 = random2.nextInt(6)+1;
//        return resulDice2;
//    }

    public GameDice() throws NoSuchProviderException, NoSuchAlgorithmException {
    }

    public int executeGame() {
//        System.out.println(throwDice1() + throwDice2());
        return throwDice1() /* + throwDice2()*/;
    }
}
