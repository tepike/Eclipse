package Program;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class Egervalami extends JFrame {
    private JPanel Egerpanel;
    private JLabel EgerTextLabel;

    public Egervalami() {
        super();
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0)); // Átlátszó háttér
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Egerpanel = new JPanel();
        Egerpanel.setLayout(new BorderLayout());
        Egerpanel.setBackground(new Color(192, 192, 192)); // Szürke háttérszín
        Egerpanel.setBorder(new LineBorder(new Color(192, 192, 192))); // Halvány szürke keret
        add(Egerpanel);

        EgerTextLabel = new JLabel("Minta szöveg2");
        EgerTextLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        EgerTextLabel.setForeground(Color.BLACK); // Fekete szöveg
        Egerpanel.add(EgerTextLabel, BorderLayout.CENTER); // A szöveg középre helyezése a Egerpanelen belül

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
