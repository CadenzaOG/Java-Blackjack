import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class GameView extends JPanel {

    private JButton button;
    private final Blackjack game;
    private final int cardOffsetX = 288;
    private final int cardWidth = 96;
    private final int cardHeight = 96;
    private final int cardOffsetY = 96;
    private BufferedImage testCard1;
    private BufferedImage testCard2;
    private final Deck deck = new Deck();
    private Card card1;
    private Card card2;
    private AssetManager assets;


    public GameView() {
        this.game = new Blackjack();
        this.assets = new AssetManager();
        card1 = deck.drawCard();
        card2 = deck.drawCard();
        this.testCard1 = assets.getCardSprite(card1.toString());
        System.out.println(testCard1);
        this.testCard2 = assets.getCardSprite(card2.toString());
        addKeyListener(new PlayerInput());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Draw Background
        g.drawImage(assets.getBackground(),
                0,0 , this) ;

        // Testing with hardcoded cards
        g.drawImage(assets.getCardSprite("BACK"),cardOffsetX, cardOffsetY, this);
        g.drawImage(testCard1,cardOffsetX + cardWidth, cardOffsetY,this);
        g.drawImage(testCard2,cardOffsetX + cardWidth * 2, cardOffsetY,this);

    }

}
