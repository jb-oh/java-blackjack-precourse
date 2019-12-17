package domain;

import domain.card.Card;
import domain.user.Dealer;
import domain.user.Player;

import java.util.ArrayList;
import java.util.List;

public class BlackjackGame {
    static ArrayList<Player> playersArray;
    static Dealer dealer;
    static List<Card> shuffledCards;

    static void initGame() {
        playersArray = GameProcessor.addPlayers(InputProcessor.getPlayerName());
        dealer = GameProcessor.createDealer();
        shuffledCards = GameProcessor.createCard();
    }

    static void dealFirstRound() {
        dealer.addCard(GameProcessor.dealCard(shuffledCards));
        dealer.addCard(GameProcessor.dealCard(shuffledCards));
        for (Player player : playersArray) {
            player.addCard(GameProcessor.dealCard(shuffledCards));
            player.addCard(GameProcessor.dealCard(shuffledCards));
        }
        GameProcessor.showFirstRoundResult(dealer, playersArray);
    }

    static void evaluateRound() {
        evaluatePlayerRound();
    }

    static void evaluatePlayerRound() {
        ArrayList<Integer> playerScoreArray = GameProcessor.calculateAllPlayersHandValue(playersArray);
        for (int i = 0; i < playersArray.size(); i++) {
            GameProcessor.askPlayerAnotherCard(playersArray.get(i), shuffledCards);
        }
    }

    public static void main(String[] args) {
        initGame();
        dealFirstRound();
        evaluateRound();
    }
}
