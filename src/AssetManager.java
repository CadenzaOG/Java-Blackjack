import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class AssetManager {

    private HashMap<String, BufferedImage> cardSprites;
    private BufferedImage background;

    public AssetManager() {
        this.cardSprites = new HashMap<>();
        try {
            this.background = ImageIO.read(getClass().getResourceAsStream("sprites/TABLE.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        loadCards();
    }

    public BufferedImage getBackground() {
        return background;
    }

    public BufferedImage getCardSprite(String card) {
        return cardSprites.get(card);
    }

    private void loadCards() {
        for (Suit s: Suit.values()) {
            for (Rank v : Rank.values()) {
                try {
                    String cardPath = "sprites/"+v+"-"+s+".png";
                    System.out.println(cardPath);
                    BufferedImage img = ImageIO.read(getClass().getResourceAsStream(cardPath));
                        cardSprites.put(v+"-"+s, img);
                } catch (IOException e) {
                    System.out.println(e);
                }

            }
        }
        try {
            BufferedImage img = ImageIO.read(getClass().getResourceAsStream("sprites/BACK.png"));
            cardSprites.put("BACK",img);
        } catch (IOException e) {
            System.out.println(e);
        }
    }


}
