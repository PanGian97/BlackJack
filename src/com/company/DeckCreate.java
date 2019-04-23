package com.company;

import java.util.ArrayList;
import java.util.Collections;

import static com.company.Suit.*;
import static com.company.Suit.CLUB;

public class DeckCreate {




    ArrayList<Card> deck = new ArrayList<>(52);
    public DeckCreate() {
    }

    public void deckCreate() {

        // EnumSet<Number> numbers = EnumSet.allOf( Number.class);
        // Card[] deck = new Card[52];


        for (int i = 0; i < 10; i++) {

            deck.add(new Card(Number.values()[i], SPADE, i + 1));
            deck.add(new Card(Number.values()[i], DIAMOND, i + 1));
            deck.add(new Card(Number.values()[i], HEART, i + 1));
            deck.add(new Card(Number.values()[i], CLUB, i + 1));
        }
        for (int i = 10; i < 13; i++) {
            deck.add(new Card(Number.values()[i], SPADE, 10));
            deck.add(new Card(Number.values()[i], DIAMOND, 10));
            deck.add(new Card(Number.values()[i], HEART, 10));
            deck.add(new Card(Number.values()[i], CLUB, 10));
        }

        Collections.shuffle(deck);
    }
    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void removeDeckCard(int pulledCardPos) {
       deck.remove(pulledCardPos);
    }

    public void printDeck(){

        for (int i = 0; i < deck.size(); i++) {
            System.out.println(deck.get(i).getAll());

        }
    }
}
