import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand;
    private int handSize;
    private int handTotal;
    private double purse;

    public Player() {

    }

    public void hit(Card card) {
        hand.add(card);
    }

    public void discard() {
        hand.clear();
    }

    public int getHandTotal() {
        return handTotal;
    }

    public int getHandSize() {
        return handSize;
    }



}
