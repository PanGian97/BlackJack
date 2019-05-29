package com.company;

import java.util.ArrayList;

public class Dealer implements IDealer{
    ArrayList<Card> dealerHand = new ArrayList<>(12);


    public void dealer(){ }
@Override
    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }
@Override
    public void addCardToDealerHand(Card cardToBeAdded) {
        this.dealerHand.add(cardToBeAdded);
    }

@Override
    public void printDealerHand() {

        for (int i = 0; i < dealerHand.size(); i++) {
            System.out.println(dealerHand.get(i).getAll());

        }
    }
    @Override
    public void printDealerLastCard(){
        System.out.println(dealerHand.get(dealerHand.size()-1).getAll());
    }
    @Override
    public int getDealerLastCard(){
        return dealerHand.get(dealerHand.size()-1).getValue();
    }
@Override
    public int getDealerCurrentHandValue() {
        int value=0;
        for(int i=0;i<dealerHand.size();i++){
            value += dealerHand.get(i).getValue();

        }

        return value;

    }

    @Override
    public ArrayList<Number> getDealerCurrentHandNumbers(){
        ArrayList<Number> numberList= new ArrayList<>();
        for(int i=0;i<dealerHand.size();i++){
            numberList.add(dealerHand.get(i).getNumber());

        }

        return numberList;
    }
}
