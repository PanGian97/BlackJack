package com.company;

import java.util.ArrayList;

public class Dealer {
    ArrayList<Card> dealerHand = new ArrayList<>(12);


    public void dealer(){ }

    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(Card dealerHand) {
        this.dealerHand.add(dealerHand);
    }


    public void printDealerHand() {

        for (int i = 0; i < dealerHand.size(); i++) {
            System.out.println(dealerHand.get(i).getAll());

        }
    }
    public void printDealerLastCard(){
        System.out.println(dealerHand.get(dealerHand.size()-1).getAll());
    }
    public int getDealerLastCard(){
        return dealerHand.get(dealerHand.size()-1).getValue();
    }

    public int getDealerCurrentHandValue() {
        int value=0;
        for(int i=0;i<dealerHand.size();i++){
            value += dealerHand.get(i).getValue();

        }

        return value;

    }
}
