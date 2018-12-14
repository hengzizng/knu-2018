package kr.ac.knu.lecture.game.blackjack;

import kr.ac.knu.lecture.service.BlackjackService;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rokim on 2018. 5. 26..
 */
public class Hand {
    private Deck deck;
    @Getter
    private List<Card> cardList = new ArrayList<>();

    public Hand(Deck deck) {
        this.deck = deck;
    }

    public Card drawCard() {
        Card card = deck.drawCard();
        cardList.add(card);
        return card;
    }

    public int getCardSum() {
        int sum = 0;
        int ace = 0;
        for (int i = 0; i < cardList.size(); ++i) {
            if (cardList.get(i).getRank() == 1) {
                sum += 11;
                ace++;
            } else if (cardList.get(i).getRank() > 10) {
                sum += 10;
            } else {
                sum += cardList.get(i).getRank();
            }
        }

        if (sum > 21 && ace > 0) {
            ace--;
            sum -= 10;
        }
        if (sum > 21 && ace > 0) {
            ace--;
            sum -= 10;
        }
        if (sum > 21 && ace > 0) {
            ace--;
            sum -= 10;
        }
        return sum;
    }

    /*
    public int getCardSum() {
        return cardList.stream().mapToInt(card -> {
            int rank = card.getRank();
            if (rank > 10) {
                return 10;
            }
            return rank;
        }).sum();
    }
    */

    public void reset() {
        cardList.clear();
    }
}
