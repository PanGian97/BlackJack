package com.company.Rules;

import com.company.Card;
import com.company.Dealer;
import com.company.Number;
import com.company.Player;

import java.util.ArrayList;

public interface AceRules {

    boolean checkAndSetAceValue(Player currPlayer, Card drawnCard);

    boolean checkAndSetAceValue(Dealer dealer, Card drawnCard);

    boolean hasAce(ArrayList<Number> currentHandNumbers);

    boolean isAce(Card drawnCard);

    Player checkForSilverWin(ArrayList<Player> playerList);
}
