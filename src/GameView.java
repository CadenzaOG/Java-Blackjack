import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    private JButton button;
    private JTextArea text = new JTextArea();
    private GridBagConstraints gbc;
    private Timer timer = new Timer(16,null);

    public GameView() {
        for (int i = 0; i < 25; i++) {
          JButton b = new JButton(String.valueOf(i));
            int finalI = i;
            b.addActionListener(e -> {
              System.out.println("You pressed button "+ finalI);
          });
          this.add(b);

        }
    }

    protected void paintComponent(Graphics g) {

    }

}
