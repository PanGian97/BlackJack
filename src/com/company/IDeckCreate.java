package com.company;

import java.util.ArrayList;
import java.util.Collections;

import static com.company.Suit.*;
import static com.company.Suit.CLUB;

public interface IDeckCreate {

    void deckCreate();

     ArrayList<Card> getDeck();

   void removeDeckCard(int pulledCardPos);

    void printDeck();

}
