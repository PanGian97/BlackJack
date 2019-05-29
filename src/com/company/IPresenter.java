package com.company;

import java.util.ArrayList;

public interface IPresenter {

     void fullGame(int playerNum);

     void GiveStartingCards();



   void giveSinglePlayerCard(int player);



    void giveSingleDealerCard();


     void playerGame(int player);


     Player bestPlayerScore();



     void dealerGame();



    void playerResults();


}




