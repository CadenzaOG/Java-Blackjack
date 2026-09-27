public class CardEntity {

    private final Card card;
    int x, y, width, height;
    private CardState state;
    private String cardKey;
    private String currentKey;
    private boolean isFaceUp;

    private enum CardState {
        WAITING,
        ACTIVE,
        IDLE
    }

    public CardEntity(Card card, int startX, int startY,int width,int height) {
        this.card = card;
        this.x = startX;
        this.y = startY;
        this.width = width;
        this.height = height;
        this.state = CardState.WAITING;
        this.currentKey = "BACK";
        this.cardKey = card.toString();
    }

    public void reveal() {
        this.currentKey = cardKey;
        isFaceUp = true;
    }



    public boolean isFaceUp() { return isFaceUp;}

    public void setSprite(String k) {
        cardKey = k;
    }

    public void update(double dt) {

    }

    public void setWidth(int width) { this.width = width; }

    public int getWidth() { return width; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    public void setState(CardState s) {
        state = s;
    }

    public String getCardKey() { return currentKey; }

    public int getX() { return x; }

    public int getY() { return y; }



}


