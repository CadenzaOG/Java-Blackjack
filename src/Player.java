import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand;
    private int handSize;
    private int handTotal;
    private int aceCount;
    private double purse;

    public Player() {
        this.hand = new ArrayList<>();
        this.handSize = 0;
        this.handTotal = 0;
        this.aceCount = 0;
        this.purse = 1000.0;
    }

    public void hit(Card card) {
        hand.add(card);
        handSize++;
        calculateHandTotal();

    }

    private void calculateHandTotal() {
        handTotal = 0;
        aceCount = 0;

        for (Card c : hand) {
            handTotal += c.getIntValue();
            if (c.isAce()) {
                aceCount++;
            }
        }

        while (handTotal > 21 && aceCount > 0) {
            handTotal -= 10;
            aceCount--;
        }
    }

    public String getCardKey(int index) {
        return hand.get(index).toString();
    }

    public void discard() {
        hand.clear();
        this.handTotal = 0;
        this.handSize = 0;
        this.aceCount = 0;
    }

    public int getHandTotal() {
        return handTotal;
    }

    public int getHandSize() {
        return handSize;
    }



}
