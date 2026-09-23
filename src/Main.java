import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

// https://docs.oracle.com/javase/tutorial/uiswing/events/changelistener.html

public class Main {

    public static void createUI() {

        JFrame window = new JFrame();
        AssetManager assetManager = new AssetManager();
        Blackjack blackjack = new Blackjack();
        GameView view = new GameView(blackjack, assetManager);

        blackjack.setGameListener(view);
        PlayerInput input = new PlayerInput(blackjack, view);

        view.addKeyListener(input);

        blackjack.gameStart();

        view.setBackground(Color.BLACK);
        view.setPreferredSize(new Dimension(1056,480));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(view);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        view.requestFocus();
        window.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createUI);

    }
}

