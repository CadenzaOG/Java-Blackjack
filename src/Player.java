import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand;
    private double purse;

    public Player() {

    }

    public void hit(Card card) {
        hand.add(card);
    }

    public void discard() {
        hand.clear();
    }



}
