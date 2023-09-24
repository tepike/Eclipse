//1
package Jatek2;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class BackgroundPanel extends JPanel {
    private BufferedImage backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

public class MainApp {
    public static void main(String[] args) {
        boolean meretezes = false;
        JFrame frame = new JFrame("Brutál hiper szuper giga mega kungfu baszó szett");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        frame.setSize(1920, 1080);
        frame.setResizable(meretezes);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(false);
        // Hozz létre egy JLayeredPane-t a háttérképnek és a gomboknak
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1920, 1080));

        // Hozz létre egy JPanel-t a gomboknak
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        ButtonLoader.loadButtons(panel); // Gombok betöltése a JPanel-re
        
        panel.setBounds(850, 350, 200, 500); // Állítsd be a gomb pozícióját és méretét


        // Hozz létre egy JLabel-t a háttérképnek
        JLabel backgroundLabel = new JLabel(new ImageIcon("medieval-inn3.gif"));
        backgroundLabel.setBounds(0, 0, 1920, 1080);

        // Add hozzá a háttérképet a JLayeredPane-hoz a háttér rétegként
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        // Add hozzá a gombokat a JLayeredPane-hoz a gombok rétegként (a háttér fölött)
        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER);

        // Állítsd be a JLayeredPane méretét az ablak méretére
        layeredPane.setBounds(0, 0, 1920, 1080);

        frame.setLayout(new BorderLayout());
        frame.add(layeredPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
