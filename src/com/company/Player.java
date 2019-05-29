package com.company;

import java.util.ArrayList;

public class Player implements IPlayer{

    ArrayList<Card> playerHand = new ArrayList<>(12);
    ArrayList<Card> dealerHand = new ArrayList<>(12);

    public void player() {

    }

@Override
    public void playerCards(ArrayList<Card> playerHand) {
        this.playerHand = playerHand;
    }
@Override
    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }


@Override
public void addCardToPlayersHand(Card cardToBeAdded){
        playerHand.add(cardToBeAdded);
}
@Override
    public void printPlayerHand() {

        for (int i = 0; i < playerHand.size(); i++) {
            System.out.println(playerHand.get(i).getAll());

        }
    }
    @Override
    public void printDrawnCard(String drawnCardContent){
        System.out.println(drawnCardContent);
    }
    @Override
    public int getPlayerLastCardValue(){
      return playerHand.get(playerHand.size()-1).getValue();
    }

@Override
    public int getCurrentHandValue() {
        int value=0;
        for(int i=0;i<playerHand.size();i++){
            value += playerHand.get(i).getValue();

        }

        return value;

    }
    @Override
    public ArrayList<Number> getCurrentHandNumbers(){
        ArrayList<Number> numberList= new ArrayList<>();
        for(int i=0;i<playerHand.size();i++){
            numberList.add(playerHand.get(i).getNumber());

        }

        return numberList;
    }

}