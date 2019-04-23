package com.company;

import java.util.*;

import static com.company.Suit.*;

public class Main {
    static ArrayList<Player> playerList  = new ArrayList<>(4);
    static DeckCreate trapoula = new DeckCreate();
    public static void main(String[] args) {

        int playerNum = 0;



     trapoula.deckCreate();
        System.out.println("insert number of players");
        Scanner scanner = new Scanner(System.in);
        playerNum = scanner.nextInt();


        for( int i=0; i<playerNum;i++){
            playerList.add(new Player());
        }

        System.out.println(playerList.size());

       giveCards();

        for( int i=0; i<playerNum;i++){
            GameOfPlayer(i);
        }


//

}

public static void giveCards() {
        for(int x=0;x<2;x++){
    for (int i = 0; i < playerList.size(); i++) {
        Player currPlayer = playerList.get(i);
        currPlayer.setPlayerHand(trapoula.getDeck().get(i));
        trapoula.removeDeckCard(i);
        int value = currPlayer.getCurrentHandValue();
        System.out.println("Player"+i+" ");
        currPlayer.printPlayerHand();
    }
    }
}
public static Integer giveSingleCard(int player){
    Player currPlayer = playerList.get(player);
    currPlayer.setPlayerHand(trapoula.getDeck().get(0));
    trapoula.removeDeckCard(0);
    System.out.println("You draw : ");
    currPlayer.printLastCard();
    return currPlayer.getCurrentHandValue();
}

public static void GameOfPlayer(int player){
        boolean draw=false;

    int playerHandValue=  playerList.get(player).getCurrentHandValue();

        while(draw==false) {
            System.out.println(" Your current score is: " + playerHandValue + " you want to continue?(Press Y for Yes and N for No ");
            if(playerHandValue<=21){
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next().toLowerCase();

            if (answer.equals("y")) {
                draw = false;
             int extraCard = giveSingleCard(0);
            playerHandValue= extraCard;
            } else if (answer.equals("n")) {
                draw = true;
            }
            else{
                System.out.println("Wrong answer try again");
            }
        }else{
                System.out.println();
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