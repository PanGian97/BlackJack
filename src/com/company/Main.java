package com.company;

public class Main {

    public static void main(String[] args) {

        Card[] deck = new Card[52];

        for(int i=0; i< Number.values().length; i++ ){
            for(int j=0; j<Suit.values().length; j++){
                deck[Suit.values().length*i + j] = new Card(Number.values()[i],Suit.values()[j])
            }
        }
    }
}
