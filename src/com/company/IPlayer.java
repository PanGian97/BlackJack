package com.company;

import java.util.ArrayList;

public interface IPlayer {


    void playerCards(ArrayList<Card> playerHand);


     ArrayList<Card> getPlayerHand();

    void addCardToPlayersHand(Card cardToBeAdded);

    void printPlayerHand();


     void printDrawnCard(String drawnCardContent);
     int getPlayerLastCardValue();


        int getCurrentHandValue();



}
