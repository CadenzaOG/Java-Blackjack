import java.util.ArrayList;

public class Dealer {

    private ArrayList<DealerCard> hand;
    private int handTotal;
    private int handSize;

    public Dealer() {
        this.hand = new ArrayList<>();
    }

    public void hit(Card card) {
        hand.add(new DealerCard(card));
    }

    public void discard() {
        hand.clear();
    }

}
