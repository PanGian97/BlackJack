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

        giveCards();

        for (int i = 0; i < playerNum; i++) {
            GameOfPlayer(i);
        }
        GameOfDealer();
        Results();

//

    }

    public static void giveCards() {
        for (int x = 0; x < 2; x++) {
            for (int i = 0; i < playerList.size(); i++) {
                Player currPlayer = playerList.get(i);
                currPlayer.setPlayerHand(trapoula.getDeck().get(i));
                trapoula.removeDeckCard(i);
                int value = currPlayer.getCurrentHandValue();
                System.out.println("Player" + i + " ");
                currPlayer.printPlayerHand();
            }
            dealer.setDealerHand(trapoula.getDeck().get(playerNum));// while players have drawn
            trapoula.removeDeckCard(playerNum);
            int dealerValue = dealer.getDealerCurrentHandValue();
            System.out.println("Dealer");
            dealer.printDealerHand();
        }
    }

    public static Integer giveSingleCard(int player) {
        Player currPlayer = playerList.get(player);
        currPlayer.setPlayerHand(trapoula.getDeck().get(0));
        trapoula.removeDeckCard(0);
        System.out.println("You draw : ");
        currPlayer.printLastCard();
        return currPlayer.getPlayerLastCard();
    }

    public static Integer giveDealerCard() {
        dealer.setDealerHand(trapoula.getDeck().get(0));
        trapoula.removeDeckCard(0);
        System.out.println("Dealer You draw : ");
        dealer.printDealerLastCard();
        return dealer.getDealerLastCard();
    }

    public static void GameOfPlayer(int player) {
        boolean draw = true;
        int extraCard=0;
        int playerHandValue = playerList.get(player).getCurrentHandValue();

        while (draw) {
            System.out.println(" Player"+player+" score is: " + playerHandValue + " you want to continue?(Press Y for Yes and N for No ");
            if (playerHandValue <= 21) {
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.next().toLowerCase();

                if (answer.equals("y")) {
                    draw = true;
                    extraCard = giveSingleCard(0);
                    playerHandValue = extraCard + playerHandValue;
                } else if (answer.equals("n")) {
                    draw = false;

                } else {
                    System.out.println("Wrong answer try again");

                }
            } else {
                System.out.println("Player : "+player+"is burned :(");
                playerHandValue = 0;
                draw = false;
            }

        }
    }

    public static void GameOfDealer() {
        boolean draw = true;
        int maxPlayerValue = 0;
        int dealerHandValue = dealer.getDealerCurrentHandValue();

        while (draw == true) {
            System.out.println(" Dealer score is: " + dealerHandValue);
            for (int i = 0; i < playerNum; i++) {
                if (maxPlayerValue <= playerList.get(i).getCurrentHandValue()) {
                    maxPlayerValue = playerList.get(i).getCurrentHandValue();
                }
            }
            if (dealerHandValue <= maxPlayerValue) {
                if ( dealerHandValue <= 17) {
                    draw = true;
                    int extraCard = giveSingleCard(0);
                    dealerHandValue = extraCard + dealerHandValue;
                } else if( dealerHandValue<=21){
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













//     System.out.println(player1.getPlayerHand());
//     trapoula.printDeck();

// Player player1 = new Player();
 //for(int i=0;i<playerList.size();i++) {
//           playerList.get(i).printPlayerHand();
//        }