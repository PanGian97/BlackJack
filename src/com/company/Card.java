package com.company;

public class Card {

    private Number number;
    private Suit suit;
    private int value;

    public Card(Number number, Suit suit, int value) {
        this.number = number;
        this.suit = suit;
        this.value = value;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
