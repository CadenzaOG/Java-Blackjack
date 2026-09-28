
/*
https://casino.betmgm.com/en/blog/understanding-the-blackjack-five-card-charlie-rule/
 */

public class Blackjack {

    private GameListener listener;
    private final Player player;
    private final Player dealer;
    private Deck deck;
    private GameState state;
    private Outcome outcome;

    public void setGameListener(GameListener listener) {
        this.listener = listener;
    }

    public Blackjack() {
        this.player = new Player();
        this.dealer = new Dealer();
        this.state = GameState.DEALER_TURN;
        this.outcome = Outcome.IN_PLAY;
    }

    public void resetGame() {
        player.discard();
        dealer.discard();
        state = GameState.DEALER_TURN;
        outcome = Outcome.IN_PLAY;
        gameStart();
    }

    public void gameStart() {
        this.deck = new Deck();
        dealerHit();
        playerHit();
        dealerHit();
        playerHit();
        if (player.getHandTotal() == 21) {
            dealerTurn();
            outcome = resolveRound();
        } else {
            state = GameState.PLAYER_TURN;
        }
        System.out.println("Hand: "+player.getHandTotal());
    }

    public void playerHit() {
        Card card = deck.drawCard();
        player.hit(card);
        int handPos = player.getHandSize() - 1;
        listener.playerCardDrawn(card,handPos);
        System.out.println("Hand total: "+ player.getHandTotal());
        System.out.println("Hand: "+player.getHandTotal());
        if (player.getHandTotal() == 21) {
            dealerTurn();
            outcome = resolveRound();
        } else if (player.getHandTotal() > 21 || player.getHandSize() == 5) {
            outcome = resolveRound();
        }

    }

    public void playerStay() {
        System.out.println("Hand: "+player.getHandTotal());
        dealerTurn();
        outcome = resolveRound();
    }

    public void dealerTurn() {
        state = GameState.DEALER_TURN;
            while (dealer.getHandTotal() < 17) {
                dealerHit();
            }
        listener.revealHoleCard();
        }


    public void dealerHit() {
        Card card = deck.drawCard();
        dealer.hit(card);
        int handPos = dealer.getHandSize() - 1;
        boolean holeCard = handPos == 0;
        listener.dealerCardDrawn(card,handPos,holeCard);
    }

    private Outcome resolveRound() {
        int dealerHand = dealer.getHandTotal();
        int playerHandSize = player.getHandSize();
        int playerHandTotal = player.getHandTotal();

        if (playerHandTotal > 21) {
            state = GameState.ROUND_OVER;
            return Outcome.PLAYER_BUST;
        }

        if (playerHandSize == 5) {
            state = GameState.ROUND_OVER;
            return Outcome.PLAYER_WIN;
        }

        if (playerHandTotal == 21) {
            state = GameState.ROUND_OVER;
            return Outcome.PLAYER_WIN;
        }

        if (state == GameState.PLAYER_TURN) {
            return Outcome.IN_PLAY;
        }

        if (dealerHand == 21) {
            state = GameState.ROUND_OVER;
            return Outcome.DEALER_WIN;
        }

        if (dealerHand > 21) {
            state = GameState.ROUND_OVER;
            return Outcome.DEALER_BUST;
        }

        if (dealerHand == playerHandTotal) {
            state = GameState.ROUND_OVER;
            return Outcome.DRAW;
        }


        if (dealerHand > playerHandTotal) {
            state = GameState.ROUND_OVER;
            return Outcome.DEALER_WIN;
        }

        if (playerHandTotal > dealerHand) {
            state = GameState.ROUND_OVER;
            return Outcome.PLAYER_WIN;
        }

        return null;

    }

    public GameState getState() { return state; }

    public Outcome getOutcome() { return outcome; }


}
