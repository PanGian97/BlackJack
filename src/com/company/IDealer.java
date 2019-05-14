package com.company;

import java.util.ArrayList;

public interface IDealer {

     ArrayList<Card> getDealerHand();

     void addCardToDealerHand(Card cardToBeAdded);


     void printDealerHand();

     void printDealerLastCard();

     int getDealerLastCard();


    int getDealerCurrentHandValue();

}
