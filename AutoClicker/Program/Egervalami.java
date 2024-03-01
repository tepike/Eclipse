package Program;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class Egervalami extends JFrame {
    private JPanel panel;
    private JLabel textLabel;

    public Egervalami() {
        super("Mouse Tracker");
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0)); // Átlátszó háttér
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(192, 192, 192)); // Szürke háttérszín
        panel.setBorder(new LineBorder(new Color(192, 192, 192))); // Halvány szürke keret
        add(panel);

        textLabel = new JLabel("Minta szöveg2");
        textLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        textLabel.setForeground(Color.BLACK); // Fekete szöveg
        panel.add(textLabel, BorderLayout.CENTER); // A szöveg középre helyezése a panelen belül

        setSize(150, 30);
        setAlwaysOnTop(true); // Mindig felül
        setVisible(true);

        // Timer létrehozása és indítása az egér pozíciójának frissítésére
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Point mousePosition = MouseInfo.getPointerInfo().getLocation();
                SwingUtilities.invokeLater(() -> updateTextPosition(mousePosition.x, mousePosition.y));
            }
        }, 0, 10); // Az egér pozíciójának frissítése minden 10 ms-ben

    }

    private void updateTextPosition(int x, int y) {
        // Az ablak eltolása az egér pozíciójához képest
        setLocation(x + 20, y - getHeight());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Egervalami());
    }
}
