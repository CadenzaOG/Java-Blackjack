public interface GameListener {

    void gameChanged();

    void playerCardDrawn(Card card, int handPos);

    void dealerCardDrawn(Card card, int handPos,boolean holeCard);

    void revealHoleCard();
}
