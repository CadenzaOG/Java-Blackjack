
/*
https://casino.betmgm.com/en/blog/understanding-the-blackjack-five-card-charlie-rule/
 */

public class Blackjack {

    private Player player;
    private Dealer dealer;
    private Deck deck;

    public Blackjack() {
        this.player = new Player();
        this.dealer = new Dealer();
        this.deck = new Deck();
    }

    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void playerHit() {
        // to add logic
        player.hit(deck.drawCard());
    }

    public void dealerHit() {
        // to add logic
        dealer.hit(deck.drawCard());
    }




}
