import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class PlayerInput implements KeyListener {


    private HashSet<Integer> keysPressed;
    private final Blackjack game;
    private final GameView gameView;

    public PlayerInput(Blackjack game, GameView gameView) {
        this.game = game;
        this.gameView = gameView;
        this.keysPressed = new HashSet<>();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int k = e.getKeyCode();
        if (keysPressed.contains(k)) return;
        keysPressed.add(k);
        System.out.println(game.getState());

        if (game.getState() == GameState.ROUND_OVER) {
            if (k == KeyEvent.VK_ENTER) {
                game.resetGame();
                gameView.repaint();
            }
        } else if (game.getState() == GameState.PLAYER_TURN) {
            switch (k) {
                case KeyEvent.VK_SPACE:
                    game.playerHit();
                    System.out.println("Player hit");
                    gameView.repaint();
                    break;
                case KeyEvent.VK_ENTER:
                    game.playerStay();
                    System.out.println("Player Stay");
                    gameView.repaint();
                    break;
            }
        } else {
            System.out.println("Not your turn!");
            gameView.repaint();
        }




    }

    @Override
    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();
        keysPressed.remove(k);

    }
}
