package PickPocket;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class BlackAndWhiteScreenshot {
    public static void main(String[] args) throws AWTException {
        // Készítsünk egy robotot a képernyőképhez
        Robot robot = new Robot();
        
        // A képernyő teljes területét képezzük le
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenshot = robot.createScreenCapture(screenRect);
        
        // Fekete-fehér képpé konvertálás
        BufferedImage bwImage = new BufferedImage(screenshot.getWidth(), screenshot.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        
        // Színes képről fekete-fehérre konvertálás
        for (int y = 0; y < screenshot.getHeight(); y++) {
            for (int x = 0; x < screenshot.getWidth(); x++) {
                // A pixel színének kinyerése
                Color color = new Color(screenshot.getRGB(x, y));
                
                // Szürkeárnyalat számítása: egyszerű színátlagolás (R, G, B)
                int gray = (int) (color.getRed() * 0.2 + color.getGreen() * 0.2 + color.getBlue() * 0.2);
                
                // Átváltás fekete-fehérre (fekete, ha szürkeérték kisebb, mint 128, fehér egyébként)
                if (gray < 128) {
                    bwImage.setRGB(x, y, Color.BLACK.getRGB());
                } else {
                    bwImage.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }
        
        // Eredmény megjelenítése
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenshot.getWidth(), screenshot.getHeight());
        JLabel label = new JLabel(new ImageIcon(bwImage));
        frame.add(label);
        frame.setVisible(true);
    }
}
