//1
package Jatek2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonLoader {
    public static void loadButtons(JPanel panel) {
        JButton button1 = new JButton("Új játék");
        JButton button2 = new JButton("Beállítások");
        JButton button3 = new JButton("Kilépés");

        Dimension buttonSize = new Dimension(160, 60);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);

        Font betutipus = new Font("Ink Free", Font.BOLD, 30);

        button1.setBackground(new Color(57, 43, 130));
        button1.setForeground(new Color(164, 15, 203));
        button1.setBorder(null);
        button1.setFont(betutipus);


        button2.setBackground(new Color(57, 43, 130));
        button2.setForeground(new Color(164, 15, 203));
        button2.setBorder(null);
        button2.setFont(betutipus);


        button3.setBackground(new Color(57, 43, 130));
        button3.setForeground(new Color(164, 15, 203));
        button3.setBorder(null);
        button3.setFont(betutipus);


        

        
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
    }
}
