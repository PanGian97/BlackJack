package com.company;

public interface IPresenter {
  Integer number();
     void fullGame();

     void GiveStartingCards();



   void giveSinglePlayerCard(int player);

     void giveSingleDealerCard();


     void playerGame(int player);


     Player bestPlayerScore();



     void dealerGame();



    void playerResults();


}




