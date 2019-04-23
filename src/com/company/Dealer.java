package com.company;

import java.util.ArrayList;

public class Dealer {
    ArrayList<Card> dealerHand = new ArrayList<>(12);


    public void dealer(){ }

    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(ArrayList<Card> dealerHand) {
        this.dealerHand = dealerHand;
    }
}
