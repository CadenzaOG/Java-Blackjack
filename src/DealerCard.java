public class DealerCard extends Card {

    private boolean isFaceDown;

    public DealerCard(Card card)  {
        super(card.getCardValue(), card.getSuit());
        isFaceDown = false;
    }

    public void setFaceDown() {
        isFaceDown = true;
    }

    public void setFaceUp() {
        isFaceDown = false;
    }

}
