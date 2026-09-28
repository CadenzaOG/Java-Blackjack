import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameView extends JPanel implements GameListener, Runnable {

    private JButton button;
    private final Blackjack game;
    private final int PANEL_WIDTH = 1056;
    private final int PANEL_HEIGHT = 480;
    private final int DEALER_OFFSET_X = 288;
    private final int DEALER_OFFSET_Y = 96;
    private final int PLAYER_OFFSET_X = 288;
    private final int PLAYER_OFFSET_Y = 288;
    private final int TEXT_OFFSET_X = 366;
    private final int TEXT_OFFSET_Y = 64;
    private final int cardOffsetX = 288;
    private final int CARD_WIDTH = 96;
    private final int CARD_HEIGHT = 96;
    private final int DECK_X = 96;
    private final int DECK_Y = 96;
    private final int cardOffsetY = 96;
    private static final int FPS = 60;
    private AssetManager assets;
    private JLabel status;
    private FlipAnimation animation;

    private AnimationManager animationManager;
    private ArrayList<CardEntity> cards;
    private CardEntity holeCardEntity;



    private Thread gameThread;
    private boolean gameRunning;




    public GameView(Blackjack game, AssetManager assets) {
        setLayout(new BorderLayout());
        status = new JLabel();
        status.setBackground(Color.BLACK);
        add(status, BorderLayout.SOUTH);
        this.assets = assets;
        this.game = game;
        animationManager = new AnimationManager();
        this.cards = new ArrayList<>();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);


//        // Draw Dealer Cards
//        Player d = game.getDealer();
//        for (int i = 0; i < d.getHandSize(); i++) {
//            int x = DEALER_OFFSET_X + (i * CARD_WIDTH);
//            int y = DEALER_OFFSET_Y;
//
//            // If card hidden, draw card back
//            if (i == 0 && game.getHoleCardHidden()) {
//                g.drawImage(assets.getCardSprite("BACK"), x, y, this);
//            } else {
//                BufferedImage card = assets.getCardSprite(d.getCardKey(i));
//                g.drawImage(card,x,y,this);
//            }
//        }
//
//        // For each of player cards, draw at offset x + hand index * card width.
//
//        // Draw Player Cards
//        Player p = game.getPlayer();
//        for (int i = 0; i < p.getHandSize(); i++) {
//            int x = PLAYER_OFFSET_X + (i * CARD_WIDTH);
//            int y = PLAYER_OFFSET_Y ;
//
//            BufferedImage card = assets.getCardSprite(p.getCardKey(i));
//            g.drawImage(card,x,y,this);
//        }
//


        //Draw Background
        g.drawImage(assets.getBackground(),
                0,0 , this) ;


        for (CardEntity c: cards) {
            drawCard(g, c);
        }


        // Draw outcome TEMPORARY

        g.setFont(new Font("Arial",Font.BOLD, 36));
        g.setColor(new Color(214,163,65));
        switch (game.getOutcome()) {
            case Outcome.PLAYER_WIN:
                g.drawString("Player Win!",TEXT_OFFSET_X, TEXT_OFFSET_Y);
                break;
            case Outcome.PLAYER_BUST:
                g.drawString("Player Bust!",TEXT_OFFSET_X,TEXT_OFFSET_Y);
                break;
            case Outcome.DEALER_WIN:
                g.drawString("Dealer wins!",TEXT_OFFSET_X,TEXT_OFFSET_Y);
                break;
            case Outcome.DEALER_BUST:
                g.drawString("Dealer Bust!",TEXT_OFFSET_X,TEXT_OFFSET_Y);
                break;
            case Outcome.DRAW:
                g.drawString("Draw!",TEXT_OFFSET_X, TEXT_OFFSET_Y);
        }




        // For each of player cards, draw at offset x + hand index * card width.



    }

    public void resetBoard() {
        cards.clear();
        animationManager.clear();
    }


    @Override
    public void gameChanged() {
        repaint();
    }


    @Override
    public void playerCardDrawn(Card card, int handPos) {
        System.out.println("Card: " + card);
        CardEntity c = new CardEntity(card,DECK_X,DECK_Y,CARD_WIDTH,CARD_HEIGHT);
        int startX = DECK_X;
        int startY = DECK_Y;
        int endX = PLAYER_OFFSET_X + (handPos * CARD_WIDTH);
        int endY = PLAYER_OFFSET_Y;
        cards.add(c);
        System.out.println(
                "handPos=" + handPos +
                        " endX=" + endX
        );
        animationManager.add(new MoveFlipAnimation(c,startX,startY,endX,endY));
    }

    public void dealerCardDrawn(Card card,int handPos,boolean holeCard) {
        int startX = DECK_X;
        int startY = DECK_Y;
        int endX = DEALER_OFFSET_X + (handPos * CARD_WIDTH);
        int endY = DEALER_OFFSET_Y;
        CardEntity c = new CardEntity(card,startX,startY,CARD_WIDTH,CARD_HEIGHT);
        cards.add(c);
        if (holeCard) {
            this.holeCardEntity = c;
            animationManager.add(new MoveAnimation(c,startX,startY,endX,endY));
        } else {
            animationManager.add(new MoveFlipAnimation(c,startX,startY,endX,endY));
        }


    }

    @Override
    public void revealHoleCard() {
        animationManager.add(new FlipAnimation(holeCardEntity,CARD_WIDTH));
    }

    @Override
    public void run() {


        double period = 1_000_000_000.0 / FPS;


        gameRunning = true;


        long frameEnd = System.nanoTime();

        while (gameRunning) {
            long frameStart = System.nanoTime();

            double dt = (frameStart - frameEnd) / 1_000_000_000.0;

            animationManager.update(dt);
            repaint();

            frameEnd = System.nanoTime();

            long timDiff = frameEnd - frameStart;
            long sleepTime = (long) (period - timDiff);
            if (sleepTime > 0) {
                try {
                    gameThread.sleep(sleepTime / 1_000_000);
                } catch (InterruptedException e) { }
            }
        }

    }

    private void drawCard(Graphics g, CardEntity c) {
        BufferedImage cardSprite = assets.getCardSprite(c.getCardKey());
        g.drawImage(cardSprite,c.getX() + ((CARD_WIDTH - c.getWidth()) / 2),c.getY(),c.getWidth(),CARD_HEIGHT,this);
    }

    private void paintScreen() {
        repaint();
    }

    private void gameRender() {
    }

    private void gameUpdate() {

    }
}
