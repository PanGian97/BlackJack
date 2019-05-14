package com.company;

import java.util.*;



public class Main {
    static ArrayList<Player> playerList = new ArrayList<>(4);
    static ArrayList<Integer> results = new ArrayList<>();
    static DeckCreate trapoula = new DeckCreate();
    static Dealer dealer = new Dealer();
    static int playerNum = 0;

    public static void main(String[] args) {




        trapoula.deckCreate();
        System.out.println("insert number of players");
        Scanner scanner = new Scanner(System.in);
        playerNum = scanner.nextInt();


        for (int i = 0; i < playerNum; i++) {
            playerList.add(new Player());
        }

        System.out.println(playerList.size());

        GiveStartingCards();

        for (int i = 0; i < playerNum; i++) {
            GameOfPlayer(i);
        }
        GameOfDealer();
        Results();

//

    }

    public static void GiveStartingCards() {
        for (int x = 0; x < 2; x++) {
            for (int i = 0; i < playerList.size(); i++) {
                Player currPlayer = playerList.get(i);
                currPlayer.addCardToPlayersHand(trapoula.getDeck().get(0));
                trapoula.removeDeckCard(0);
                int pHandValue = currPlayer.getCurrentHandValue();
                System.out.println("Player" + i + " ");
                currPlayer.printPlayerHand();
            }
            dealer.setDealerHand(trapoula.getDeck().get(0));// while players have drawn
            trapoula.removeDeckCard(0);
            int dHandValue = dealer.getDealerCurrentHandValue();
            System.out.println("Dealer");
            dealer.printDealerHand();
        }
    }

//    public static Integer giveSingleCardValue(int player) {
//        Player currPlayer = playerList.get(player);
//        currPlayer.setPlayerHand(trapoula.getDeck().get(0));
//        trapoula.removeDeckCard(0);
//        System.out.println("You draw : ");
//        currPlayer.printLastCard();
//        return currPlayer.getPlayerLastCardValue();
//    }
    public static Card giveSinglePlayerCard(int player) {
        Player currPlayer = playerList.get(player);
        Card drawnCard = trapoula.getDeck().get(0);
        currPlayer.addCardToPlayersHand(drawnCard);
        System.out.println("You draw : ");
        currPlayer.printDrawnCard(drawnCard);
        trapoula.removeDeckCard(0);
        return drawnCard;
    }
    public static Card giveSingleDealerCard() {
        Card drawnCard = trapoula.getDeck().get(0);
        dealer.addCardToDealerHand(drawnCard);
        System.out.println("Dealer You draw : ");
        dealer.printDealerLastCard();
        trapoula.removeDeckCard(0);
        return drawnCard;
    }

    public static void GameOfPlayer(int player) {
        boolean draw = true;
      //  int extraCard=0;
       Player currentPlayer =  playerList.get(player);
       int playerHandValue;

        while (draw) {
            playerHandValue = currentPlayer.getCurrentHandValue();
        System.out.println("player "+currentPlayer+" hand value is: "+playerHandValue+"want to continue drawing?(Press Y for Yes and N for No )");
            if (playerHandValue < 21) {
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.next().toLowerCase();

                if (answer.equals("y")) {
                    draw = true;
                    giveSinglePlayerCard(player);
                                                     //  playerHandValue = currentPlayer.getCurrentHandValue();
                } else if (answer.equals("n")) {
                    draw = false;

                } else {
                    System.out.println("Wrong answer try again");

                }
            }
            else if(playerHandValue == 21){
                System.out.println("player "+currentPlayer+" GOT 21!");
                draw=false;
            }
            else {
                System.out.println("Player : "+player+"is burned :(");
                draw = false;
            }

        }
    }

    public static Player bestPlayerScore() {
        Player bestPlayer = new Player();
        for (int i = 0; i < playerNum; i++) {
            if (bestPlayer.getCurrentHandValue() <= playerList.get(i).getCurrentHandValue()) {
                bestPlayer = playerList.get(i);
            }
        }
        return bestPlayer;
    }
    public static void GameOfDealer() {
        boolean draw = true;
        int maxPlayerValue = 0;
        int dealerHandValue;

        while (draw) {
             dealerHandValue = dealer.getDealerCurrentHandValue();
            System.out.println(" Dealer score is: " + dealerHandValue);

           maxPlayerValue = bestPlayerScore().getCurrentHandValue();

            if (dealerHandValue <= maxPlayerValue) {

                    draw = true;
                    int extraCard = giveSinglePlayerCard(0);
                    dealerHandValue = extraCard + dealerHandValue;
                } else if( dealerHandValue>21){
                    draw = false;
                }
                else {
                    System.out.println("Dealer is burned!");
                    draw = false;
                    dealerHandValue = 0;
                }
            } else {
                System.out.println("Dealer WON!!!");
                 draw=false;
            }

        }

    }



    public static void Results(){
            for (int i=0;i<playerList.size();i++){
                int currentPlayerHand =  playerList.get(i).getCurrentHandValue();
                if(playerList.get(i).getCurrentHandValue() >= dealer.getDealerCurrentHandValue() ){
                    if(currentPlayerHand>0)
                    System.out.println("Player: "+i+" WON!!");
                }
            }


        }

    }
// while (draw) {
//         dealerHandValue = dealer.getDealerCurrentHandValue();
//         System.out.println(" Dealer score is: " + dealerHandValue);
//         for (int i = 0; i < playerNum; i++) {
//        if (maxPlayerValue <= playerList.get(i).getCurrentHandValue()) {
//        maxPlayerValue = playerList.get(i).getCurrentHandValue();
//        }
//        }
//        if (dealerHandValue <= maxPlayerValue) {
//        if ( dealerHandValue <= 17) {
//        draw = true;
//        int extraCard = giveSinglePlayerCard(0);
//        dealerHandValue = extraCard + dealerHandValue;
//        } else if( dealerHandValue<=21){
//        draw = false;
//        }
//        else {
//        System.out.println("Dealer is burned!");
//        draw = false;
//        dealerHandValue = 0;
//        }
//        } else {
//        System.out.println("Dealer WON!!!");
//        draw=false;
//        }
//
//        }












//     System.out.println(player1.getPlayerHand());
//     trapoula.printDeck();

// Player player1 = new Player();
 //for(int i=0;i<playerList.size();i++) {
//           playerList.get(i).printPlayerHand();
//        }