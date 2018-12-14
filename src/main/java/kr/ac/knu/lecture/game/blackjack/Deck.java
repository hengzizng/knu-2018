package kr.ac.knu.lecture.game.blackjack;

import kr.ac.knu.lecture.exception.NoMoreCardException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rokim on 2018. 5. 26..
 */
public class Deck {
    @Getter
    private final int number;
    @Getter
    private final List<Card> cardList;

    public Deck(int number) {
        this.number = number;
        this.cardList = new ArrayList<Card>();
        createCards(number);
        Collections.shuffle(cardList);
    }

    private void createCards(int number) {
        // create card for single deck
        for (int j = 0; j < number; j++) {
            for (Suit suit : Suit.values()) {
                for (int i = 1; i < 14; i++) {
                    Card card = new Card(i, suit);
                    cardList.add(card);
                }
            }
        }
    }

    public Card drawCard() {
        if (cardList.size() < 10) {
            createCards(1);
            Collections.shuffle(cardList);
        }
        return cardList.remove(0);
    }

    public void addNextCard(int rank) {
        Card card = new Card(rank, Suit.CLUBS);
        cardList.add(0, card);
    }

    public int getcardListSize(){
        return cardList.size();
    }

    public void addCardToDeck(){
        createCards(1);
        Collections.shuffle(cardList);
    }

}
