package com.company;

public class Card implements ICard{

    private Number number;
    private Suit suit;
    private int value;

    public Card(Number number, Suit suit, int value) {
        this.number = number;
        this.suit = suit;
        this.value = value;
    }
@Override
    public Number getNumber() {
        return number;
    }
@Override
    public void setNumber(Number number) {
        this.number = number;
    }
@Override
    public Suit getSuit() {
        return suit;
    }
@Override
    public void setSuit(Suit suit) {
        this.suit = suit;
    }
@Override
    public int getValue() {
        return value;
    }
@Override
    public void setValue(int value) {
        this.value = value;
    }
@Override
    public String getAll() {
        return this.number + "," + this.suit+","+this.value;
    }
}
