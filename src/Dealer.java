import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dealer extends Player {

    private ArrayList<Card> hand;
    private int handTotal;
    private int handSize;

    public Dealer() {
        this.hand = new ArrayList<>();
        this.handSize = 0;
        this.handTotal = 0;
    }

    public ArrayList<Card> getHand() { return hand; }



}
