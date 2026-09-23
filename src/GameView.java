import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameView extends JPanel implements GameListener {

    private JButton button;
    private final Blackjack game;
    private final int DEALER_OFFSET_X = 288;
    private final int DEALER_OFFSET_Y = 96;
    private final int PLAYER_OFFSET_X = 288;
    private final int PLAYER_OFFSET_Y = 288;
    private final int TEXT_OFFSET_X = 366;
    private final int TEXT_OFFSET_Y = 64;
    private final int cardOffsetX = 288;
    private final int CARD_WIDTH = 96;
    private final int cardHeight = 96;
    private final int cardOffsetY = 96;
    private AssetManager assets;
    private JLabel status;


    public GameView(Blackjack game, AssetManager assets) {
        setLayout(new BorderLayout());
        status = new JLabel();
        status.setBackground(Color.BLACK);
        add(status, BorderLayout.SOUTH);
        this.assets = assets;
        this.game = game;
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        //Draw Background
        g.drawImage(assets.getBackground(),
                0,0 , this) ;

        // Draw Dealer Cards
        Player d = game.getDealer();
        for (int i = 0; i < d.getHandSize(); i++) {
            int x = DEALER_OFFSET_X + (i * CARD_WIDTH);
            int y = DEALER_OFFSET_Y;

            // If card hidden, draw card back
            if (i == 0 && game.getHoleCardHidden()) {
                g.drawImage(assets.getCardSprite("BACK"), x, y, this);
            } else {
                BufferedImage card = assets.getCardSprite(d.getCardKey(i));
                g.drawImage(card,x,y,this);
            }
        }

        // For each of player cards, draw at offset x + hand index * card width.

        // Draw Player Cards
        Player p = game.getPlayer();
        for (int i = 0; i < p.getHandSize(); i++) {
            int x = PLAYER_OFFSET_X + (i * CARD_WIDTH);
            int y = PLAYER_OFFSET_Y;

            BufferedImage card = assets.getCardSprite(p.getCardKey(i));
            g.drawImage(card,x,y,this);
        }

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


    @Override
    public void gameChanged() {
        repaint();
    }
}
