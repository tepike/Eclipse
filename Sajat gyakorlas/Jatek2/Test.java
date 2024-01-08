//1
package Jatek2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
	private static boolean Lathato=true;
    public static void loadButtons(JPanel Menu_Panel) {
        JButton button1 = new JButton("Gomb 1");
        JButton button2 = new JButton("Gomb 2");
        JButton button3 = new JButton("Vissza");

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
            	Menu_Panel.setVisible(false);
            }
        });

        Menu_Panel.add(button1);
        Menu_Panel.add(button2);
        Menu_Panel.add(button3);
    }
	public static boolean getLathato() {
		return Lathato;
	}
	public static void setLathato(boolean lathato) {
		Lathato = lathato;
	}
}
