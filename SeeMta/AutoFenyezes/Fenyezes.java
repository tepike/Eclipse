package AutoFenyezes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Fenyezes extends main {
	static JCheckBox lathatBox;
	static JLabel Mindig_Lathato;
	 static void FenyezesGomb() {
		System.out.println("Fenyezesi osztaly betoltese");
		JLabel Fenyezes_label= new JLabel("Fényezés");
		main.MainScreen_Wallpaper.add(Fenyezes_label);
		Fenyezes_label.setBounds(10, 15, Fenyezes_label.getText().length()*13, 29);
		Fenyezes_label.setFont(new Font("Serif", Font.BOLD, 25));
		Fenyezes_label.setForeground(Color.white);
		//Fenyezes_label.setBorder(new LineBorder(Color.white));
		
		//Fényezésgomb aktivitások
		Fenyezes_label.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Fenyezes_label.setBounds(10, 11, Fenyezes_label.getText().length()*15, 34);
				Fenyezes_label.setFont(new Font("Serif", Font.BOLD, 30));
			}
			public void mouseExited(MouseEvent e) {
				Fenyezes_label.setBounds(10, 15, Fenyezes_label.getText().length()*13, 29);
				Fenyezes_label.setFont(new Font("Serif", Font.BOLD, 25));
			}
			public void mousePressed(MouseEvent e) {
				if(!Munkaterulet.isVisible()) {
					if(ElsoMegnyitas) {
						ElsoMegnyitas=false;
						Munkaterulet.setLocation((int)keret.getLocation().getX()-250,(int)keret.getLocation().getY());
					}
					Munkaterulet.setVisible(true);
					Fenyezes_label.setForeground(Color.green);
					Lathatosag.setVisible(true);
					lathatBox.setVisible(true);
					Mindig_Lathato.setVisible(true);
					Munkaterulet_Attetszoseg.setVisible(true);
				}else {
					Munkaterulet.setVisible(false);
					Fenyezes_label.setForeground(Color.white);
					Lathatosag.setVisible(false);
					lathatBox.setVisible(false);
					Mindig_Lathato.setVisible(false);
					Munkaterulet_Attetszoseg.setVisible(false);
				}
			}
		});
		
		//Munkaterület allways on top
		Mindig_Lathato= new JLabel("Mindig felül");
		Mindig_Lathato.setFont(new Font("Serif", Font.BOLD, 25));
		Mindig_Lathato.setForeground(Color.white);
		Mindig_Lathato.setBounds(20,50,Mindig_Lathato.getText().length()*12,35);
		Mindig_Lathato.setVisible(false);
		//Mindig_Lathato.setBorder(new LineBorder(Color.red, 1));
		
		lathatBox= new JCheckBox();
		lathatBox.setVisible(false);
		lathatBox.setBounds((int)Mindig_Lathato.getLocation().getX()+Mindig_Lathato.getText().length()*11+5, 60, 22, 19);
		lathatBox.setBackground(new Color(0,0,0,0));
		lathatBox.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1) {
					System.out.println("Bal egér");
					if(lathatBox.isSelected()) {
						Munkaterulet.setAlwaysOnTop(false);
						System.out.println("Munkaterulet mindig felul: "+lathatBox.isSelected());
					}else{
						Munkaterulet.setAlwaysOnTop(true);
						System.out.println("Munkaterulet mindig felul: "+lathatBox.isSelected());
					}}}
		});
		
		//Munkaterület láthatóságának állítása + felirat
		Munkaterulet_Attetszoseg.setBounds(20, 80, Munkaterulet_Attetszoseg.getText().length()*16, 35);
		Munkaterulet_Attetszoseg.setFont(new Font("Tahoma", Font.BOLD, 24));
		Munkaterulet_Attetszoseg.setForeground(Color.white);
			//Munkaterulet_Attetszoseg.setBorder(new LineBorder(Color.white));

		Lathatosag.setVisible(false);
		Munkaterulet_Attetszoseg.setVisible(false);
		
		Lathatosag.setBounds(195, 88, 200, 25);
		Lathatosag.setValue(100);
		Lathatosag.setMinimum(5);
		Lathatosag.setBackground(new Color(0,0,0,0));
		Lathatosag.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Munkaterulet.setBackground(new Color(100,100,100,Lathatosag.getValue()*2));
				keret.repaint();
			}
		});
	
		
		MainScreen_Wallpaper.add(Lathatosag);
		MainScreen_Wallpaper.add(Munkaterulet_Attetszoseg);
		MainScreen_Wallpaper.add(Mindig_Lathato);
		MainScreen_Wallpaper.add(lathatBox);
	}

}
