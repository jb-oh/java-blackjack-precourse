package domain;

import domain.card.Card;
import domain.card.CardFactory;
import domain.user.Dealer;
import domain.user.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameProcessor {
    private static ArrayList<Player> playersArray = new ArrayList<Player>();

    static void addPlayers(ArrayList<String> playerNamesArray) {
        for (String playerName : playerNamesArray) {
            Double playerMoney = InputProcessor.getPlayerMoney(playerName);
            playersArray.add(new Player(playerName, playerMoney));
        }
        for (int i = 0; i < playersArray.size(); i++) {
            System.out.println(playersArray.get(i).getName() + ", " + (int)playersArray.get(i).getBettingMoney());
        }
    }

    static void createDealer() {
        Dealer dealer = new Dealer();
    }

    static void createCard() {
        List<Card> cardsArray;
        CardFactory cardFactory = new CardFactory();
        cardsArray = cardFactory.create();
    }
}
