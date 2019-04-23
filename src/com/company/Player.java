package com.company;

import java.util.ArrayList;

public class Player {

    ArrayList<Card> playerHand = new ArrayList<>(12);
    ArrayList<Card> dealerHand = new ArrayList<>(12);

    public void player() {

    }


    public void playerCards(ArrayList<Card> playerHand) {
        this.playerHand = playerHand;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(Card playerHand) {
        this.playerHand.add(playerHand);
    }

    public void printPlayerHand() {

        for (int i = 0; i < playerHand.size(); i++) {
            System.out.println(playerHand.get(i).getAll());

        }
    }
    public void printLastCard(){
        System.out.println(playerHand.get(playerHand.size()-1).getAll());
    }
    public int getPlayerLastCard(){
      return playerHand.get(playerHand.size()-1).getValue();
    }


    public int getCurrentHandValue() {
        int value=0;
        for(int i=0;i<playerHand.size();i++){
            value += playerHand.get(i).getValue();

        }

        return value;

    }
}