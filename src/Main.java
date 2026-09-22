import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

// https://docs.oracle.com/javase/tutorial/uiswing/events/changelistener.html

public class Main {

    public static void createUI() {

        JFrame window = new JFrame();
        GameView view = new GameView();
        view.setBackground(Color.BLACK);
        view.setPreferredSize(new Dimension(1056,480));

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(view);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createUI);

    }
}

