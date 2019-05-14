package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class View {

Presenter presenter;
        private static int playerNum = 0;

        public Integer insertPlayers() {

            System.out.println("insert number of players");
            Scanner scanner = new Scanner(System.in);
            playerNum = scanner.nextInt();
            return playerNum;
        }
public void printStartPlayerHand(int i,IPlayer currPlayer) {
    System.out.println("Player " + i + " turn to get starting cards... ");
    currPlayer.printPlayerHand();
}
    public void printStartDealerHand(IDealer dealer) {
        System.out.println("Dealer turn to get starting cards...");
        dealer.printDealerHand();
    }
 public Boolean viewPlayerGame(int player, int playerHandValue, boolean draw)
    {
        System.out.println("player "+player+" hand value is: "+playerHandValue+" want to continue drawing?(Press Y for Yes and N for No )");
        if (playerHandValue < 21) {
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next().toLowerCase();

            if (answer.equals("y")) {
                draw = true;
               presenter.giveSinglePlayerCard(player);
                //  playerHandValue = currentPlayer.getCurrentHandValue();
            } else if (answer.equals("n")) {
                draw = false;

            } else {
                System.out.println("Wrong answer try again");

            }
        }
        else if(playerHandValue == 21){
            System.out.println("player "+player+" GOT 21!");
            //draw=false;
        }
        else {
            System.out.println("Player : "+player+" is burned :(");
            draw = false;
        } return draw;
    }


   public Boolean viewDealerGame(int dealerHandValue,boolean draw,int maxPlayerValue){
     System.out.println(" Dealer score is: " + dealerHandValue);

    maxPlayerValue = presenter.bestPlayerScore().getCurrentHandValue();

                if (dealerHandValue <= maxPlayerValue && dealerHandValue<21) {

        draw = true;
       presenter.giveSingleDealerCard();
    }

                else  if(dealerHandValue == 21 && maxPlayerValue==21)
    {
        System.out.println("The match is a tie");
        draw = false;
    }
                else if(dealerHandValue==21){
        System.out.println("Dealer won the game with 21!!");
        draw=false;
    }
                else if(dealerHandValue>21){
        System.out.println("Dealer burned!");
        draw = false;
        presenter.playerResults();
    }
                else if(dealerHandValue>= maxPlayerValue && dealerHandValue<21){
        System.out.println("Dealer won the game...");
        draw=false;
    }
                else {
        System.out.println("No winner...Everybody burned to ashes");
    }    return draw;
        }
}
