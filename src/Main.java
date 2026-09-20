import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class Main {

    public static void createUI() {

        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(new GameView());
        window.setResizable(false);
        window.setSize(300, 300);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createUI);




    }
}

