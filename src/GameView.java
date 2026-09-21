import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class GameView extends JPanel {

    private JButton button;
    private JTextArea text = new JTextArea();
    private GridBagConstraints gbc;
    private Timer timer = new Timer(16,null);
    private BufferedImage background;
    private final int cardOffsetX = 288;
    private final int cardOffsetY = 96;
    private BufferedImage testCard1;
    private BufferedImage testCard2;
    private final Deck deck = new Deck();
    private Card card1;
    private Card card2;


    public GameView() {
        card1 = deck.drawCard();
        card2 = deck.drawCard();
        try {
            this.background = ImageIO.read(getClass().getResourceAsStream("sprites/TABLE.png"));
            this.testCard1 = ImageIO.read(getClass().getResourceAsStream("sprites/"+card1));
            this.testCard2 = ImageIO.read(getClass().getResourceAsStream("sprites/"+card2));
        } catch (IOException e) {
            this.background = null;
            System.out.println(e);
        }



         }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.background != null) {
            g.drawImage(background, 0,0 , this) ;
        }


        String cardPath = "sprites/"+deck.drawCard().toString();

            g.drawImage(testCard1,cardOffsetX, cardOffsetY,this);
            g.drawImage(testCard2,cardOffsetX + 96, cardOffsetY,this);







    }

}
