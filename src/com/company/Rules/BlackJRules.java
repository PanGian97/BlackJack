package com.company.Rules;

import com.company.Card;
import com.company.Dealer;
import com.company.Number;
import com.company.Player;

import java.util.ArrayList;

import static com.company.Number.ACE;

public class BlackJRules implements AceRules {

    @Override
    public boolean checkAndSetAceValue(Player currPlayer, Card drawnCard) {
        if(hasAce(currPlayer.getCurrentHandNumbers())&& isAce(drawnCard)){
            drawnCard.setValue(1);{return true;}
        }else return false;
    }


    @Override
    public boolean checkAndSetAceValue(Dealer dealer, Card drawnCard) {
        if(hasAce(dealer.getDealerCurrentHandNumbers() )&& isAce(drawnCard)){
            drawnCard.setValue(1);
            return true;
        } else {return false;}
    }

    @Override
    public boolean hasAce(ArrayList<Number> currentHandNumbers) {
        if(currentHandNumbers.contains(ACE)){
            return true;
        }else{return false;}

    }

    @Override
    public boolean isAce(Card drawnCard) {
        if(drawnCard.getNumber()==ACE){
            return true;
        }
        return false;
    }
@Override
    public Player checkForSilverWin(ArrayList<Player> playerList) {
        ArrayList<Player> silverWinners = new ArrayList<>();
        for(int i=0;i<playerList.size();i++){
            if(playerList.get(i).getCurrentHandValue()==14)
            {
        silverWinners.add(playerList.get(i));
            } if(silverWinners.size()==1)return silverWinners.get(0);
        }
       return null;
    }

}
