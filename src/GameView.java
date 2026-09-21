import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameView extends JPanel {

    private JButton button;
    private JTextArea text = new JTextArea();
    private GridBagConstraints gbc;
    private Timer timer = new Timer(16,null);
    private BufferedImage background;
    private Deck deck;
    private final int cardOffsetX = 288;
    private final int cardOffsetY = 96;
    private BufferedImage testCard;


    public GameView() {
        try {
            this.background = ImageIO.read(getClass().getResourceAsStream("sprites/TABLE.png"));
            this.testCard = ImageIO.read(getClass().getResourceAsStream("sprites/ACE-SPADE.png"));
        } catch (IOException e) {
            this.background = null;
            System.out.println(e);
        }

        this.deck = new Deck();

         }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.background != null) {
            g.drawImage(background, 0,0 , background.getWidth() * 3, background.getHeight() * 3, this) ;
        }

        g.drawImage(testCard,cardOffsetX, cardOffsetY,78,96,this);
        g.drawImage(testCard,cardOffsetX + 96, cardOffsetY,78,96,this);

    }

}
