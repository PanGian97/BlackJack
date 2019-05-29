package com.company;

import java.util.Scanner;

public interface IView {
     Integer insertPlayers();

    void printStartPlayerHand(int i,IPlayer currPlayer);

    void printStartDealerHand(IDealer dealer);

    Boolean viewPlayerGame(int player, int playerHandValue, boolean draw);


     Boolean viewDealerGame(int dealerHandValue,boolean draw,int maxPlayerValue);
void playBlackJack();

  void printPlayerDrawResult() ;
     void printDealerDrawResult();

   void printPlayerWinner(int playerIndex,int maxAcceptedValue);

    void printPlayerWinner(Player player);



}
