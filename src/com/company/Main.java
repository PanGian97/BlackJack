package com.company;

import java.util.*;



public class Main {
   private static ArrayList<Player> playerList = new ArrayList<>(4);
   private static ArrayList<Integer> results = new ArrayList<>();
   private static DeckCreate trapoula = new DeckCreate();
    private static Dealer dealer = new Dealer();
   private static int playerNum = 0;

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
            playerGame(i);
        }
        dealerGame();

    }

    public static void GiveStartingCards() {
        for (int x = 0; x < 2; x++) {
            for (int i = 0; i < playerList.size(); i++) {
                Player currPlayer = playerList.get(i);
                currPlayer.addCardToPlayersHand(trapoula.getDeck().get(0));
                trapoula.removeDeckCard(0);
                int pHandValue = currPlayer.getCurrentHandValue();
                System.out.println("Player " + i + " turn to get starting cards... ");
                currPlayer.printPlayerHand();
            }
            dealer.addCardToDealerHand(trapoula.getDeck().get(0));// while players have drawn
            trapoula.removeDeckCard(0);
            int dHandValue = dealer.getDealerCurrentHandValue();
            System.out.println("Dealer turn to get starting cards...");
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
        currPlayer.printDrawnCard(drawnCard.getAll());
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

    public static void playerGame(int player) {
        boolean draw = true;
      //  int extraCard=0;
       Player currentPlayer =  playerList.get(player);
       int playerHandValue;

        while (draw) {
            playerHandValue = currentPlayer.getCurrentHandValue();
        System.out.println("player "+player+" hand value is: "+playerHandValue+" want to continue drawing?(Press Y for Yes and N for No )");
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
                System.out.println("player "+player+" GOT 21!");
                //draw=false;
            }
            else {
                System.out.println("Player : "+player+" is burned :(");
                draw = false;
            }

        }
    }

    public static Player bestPlayerScore() {
        Player bestPlayer = new Player();
        int comparedPlayerValue=0;
        for (int i = 0; i < playerNum; i++) {
            comparedPlayerValue = playerList.get(i).getCurrentHandValue();
            if (bestPlayer.getCurrentHandValue() <= comparedPlayerValue && comparedPlayerValue<=21) {
                bestPlayer = playerList.get(i);
            }
        }
        return bestPlayer;
    }


    public static void dealerGame() {
        boolean draw = true;
        int maxPlayerValue = 0;
        int dealerHandValue;

        while (draw) {
             dealerHandValue = dealer.getDealerCurrentHandValue();
            System.out.println(" Dealer score is: " + dealerHandValue);

           maxPlayerValue = bestPlayerScore().getCurrentHandValue();

            if (dealerHandValue <= maxPlayerValue && dealerHandValue<21) {

                    draw = true;
                    giveSingleDealerCard();
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
                   playerResults();
                }
            else if(dealerHandValue>= maxPlayerValue && dealerHandValue<21){
                System.out.println("Dealer won the game...");
                draw=false;
            }
            else {
                System.out.println("No winner...Everybody burned to ashes");
            }
            }
        }




    public static void playerResults(){
        int currentPlayerHand=0;
        int maxAcceptedValue=0;
        int playerIndex=0;
        //playerIndex=-1;//case we have all players above 21...not used now cause we have checked this in dealerTurn()

            for (int i=0;i<playerList.size();i++)//+dealer
            { currentPlayerHand = playerList.get(i).getCurrentHandValue();
                if(currentPlayerHand <=21){
                if(maxAcceptedValue < currentPlayerHand){
                    playerIndex = i;
                    maxAcceptedValue = currentPlayerHand;
                }
                }
            }
        if(playerIndex>=0)System.out.println("The winner is player "+playerIndex+" with "+maxAcceptedValue);

        }

    }
