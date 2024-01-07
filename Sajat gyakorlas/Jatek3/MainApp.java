package Jatek3;

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
    private static boolean lathato_menu = true;
    private static boolean lathato_settings = false;

    public static void main(String[] args) {
        boolean meretezes = false;
        JFrame frame = new JFrame("Brutál hiper szuper giga mega kungfu baszó szett");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1920, 1080);
        frame.setResizable(meretezes);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(false);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1920, 1080));

        JPanel Menu_Panel = new JPanel();
        Menu_Panel.setOpaque(false);
        ButtonLoader.loadButtons(Menu_Panel);
        Menu_Panel.setBounds(850, 350, 200, 500);
        layeredPane.add(Menu_Panel, JLayeredPane.PALETTE_LAYER);

        JPanel Settings_LayeredPane = new JPanel();
        Settings_LayeredPane.setOpaque(false);
        Test.loadButtons(Settings_LayeredPane);
        Settings_LayeredPane.setBounds(1050, 350, 200, 500);
        layeredPane.add(Settings_LayeredPane, JLayeredPane.PALETTE_LAYER);
        Settings_LayeredPane.setVisible(lathato_settings);

        JLabel backgroundLabel = new JLabel(new ImageIcon("medieval-inn3.gif"));
        backgroundLabel.setBounds(0, 0, 1920, 1080);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        layeredPane.setBounds(0, 0, 1920, 1080);
        frame.setLayout(new BorderLayout());
        frame.add(layeredPane, BorderLayout.CENTER);
        frame.setVisible(lathato_menu);
    }

    public static boolean getLathato_settings() {
        return lathato_settings;
    }

    public static void setLathato_settings(boolean lathato_settings) {
        MainApp.lathato_settings = lathato_settings;
    }

    public static boolean getLathato_menu() {
        return lathato_menu;
    }

    public static void setLathato_menu(boolean lathato_menu) {
        MainApp.lathato_menu = lathato_menu;
    }
}