package AutoFenyezes;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

public class TeruletJeloles extends main {
	public void Munkaterulet_Letrehozas() {
		int Minimum_Meret=50;
		
		System.out.println("Munkaterület betöltése");
		main.Munkaterulet.setSize(200,200);
		main.Munkaterulet.setLayout(null);
		main.Munkaterulet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.Munkaterulet.setUndecorated(true);
		main.Munkaterulet.setBackground(new Color(100,100,100,200));
		
		//Munkaterület mozgatása
		main.Munkaterulet.addMouseListener(new MouseAdapter() {
			int x=0; 	//Munkaterülethez készített panelen azh egér pozíciójának ki indulási helyzete
			int y=0;	//Munkaterülethez készített panelen azh egér pozíciójának ki indulási helyzete
			int x2=0;	//Munkaterülethez készített panel a lenyomott egér pozíciója
			int y2=0;	//Munkaterülethez készített panel a lenyomott egér pozíciója
			int x3=0;	//Munkaterület átméretezéshez az egér pozíciójának ki indulási helyzete
			int y3=0;	//Munkaterület átméretezéshez az egér pozíciójának ki indulási helyzete
			int x4=0;	//Munkaterület átméretezéshez az egér pozíciója a képen amíg a jobb egér lenyomva van
			int y4=0;	//Munkaterület átméretezéshez az egér pozíciója a képen	amíg a jobb egér lenyomva van
			public void mousePressed(MouseEvent e) {
				main.keret.setVisible(false);
				try {
					x=(int)main.Munkaterulet.getMousePosition().getX();
					y=(int)main.Munkaterulet.getMousePosition().getY();
					x3=(int)MouseInfo.getPointerInfo().getLocation().getX();
					y3=(int)MouseInfo.getPointerInfo().getLocation().getY();
				} catch (Exception e2) {
					System.err.println(e2);
				}

				main.gomb=(byte) e.getButton();
				//System.out.println(e.getButton());

				main.Munkaterulet.addMouseMotionListener(new MouseMotionAdapter() {
					int i=0;
					public void mouseDragged(MouseEvent e) {
						if(main.gomb==1) {
							try {
								x2=(int)main.Munkaterulet.getMousePosition().getX();
								y2=(int)main.Munkaterulet.getMousePosition().getY();
							} catch (Exception e2) {
								i++;
								System.err.println("Kilépett az egér a munkaterületről ezért korrigáljuk a panel pozícióját: "+i);
								main.Munkaterulet.setLocation((int)MouseInfo.getPointerInfo().getLocation().getX()-(main.Munkaterulet.getWidth()/2),
														 (int)MouseInfo.getPointerInfo().getLocation().getY()-(main.Munkaterulet.getHeight()/2));
							}

							if(x2>x) {
								main.Munkaterulet.setLocation((int)main.Munkaterulet.getLocation().getX()+(x2-x),(int) main.Munkaterulet.getLocation().getY());
							}else {
								main.Munkaterulet.setLocation((int)main.Munkaterulet.getLocation().getX()-(x-x2),(int) main.Munkaterulet.getLocation().getY());
							}
							if(y2>y) {
								main.Munkaterulet.setLocation((int)main.Munkaterulet.getLocation().getX(),(int) main.Munkaterulet.getLocation().getY()+(y2-y));
							}else {
								main.Munkaterulet.setLocation((int)main.Munkaterulet.getLocation().getX(),(int) main.Munkaterulet.getLocation().getY()-(y-y2));
							}
						}
						if(main.gomb==3) {
							x4=(int)MouseInfo.getPointerInfo().getLocation().getX();
							y4=(int)MouseInfo.getPointerInfo().getLocation().getY();

							if(x4>x3) {
								main.Munkaterulet.setSize((int)main.Munkaterulet.getSize().getWidth()+(x4-x3), (int)main.Munkaterulet.getSize().getHeight());
								x3=x4;}
							
							if(x4<x3) {
								main.Munkaterulet.setSize((int)main.Munkaterulet.getSize().getWidth()-(x3-x4), (int)main.Munkaterulet.getSize().getHeight());
								x3=x4;}
							
							if(y4>y3) {
								main.Munkaterulet.setSize((int)main.Munkaterulet.getSize().getWidth(), (int)main.Munkaterulet.getSize().getHeight()+(y4-y3));
								y3=y4;}
							
							if(y4<y3) {
								main.Munkaterulet.setSize((int)main.Munkaterulet.getSize().getWidth(), (int)main.Munkaterulet.getSize().getHeight()-(y3-y4));
								y3=y4;}
						}

					}

				});
				
			}
			public void mouseReleased(MouseEvent e) {
				System.out.println("Elengedve");
				main.gomb=(byte) e.getButton();
				System.err.println(main.gomb);
				if(main.gomb==3) {
					if(main.Munkaterulet.getSize().getWidth()<Minimum_Meret) {
						main.Munkaterulet.setSize(Minimum_Meret,(int)main.Munkaterulet.getSize().getHeight());}
				
					if(main.Munkaterulet.getSize().getHeight()<Minimum_Meret) {
						main.Munkaterulet.setSize((int)main.Munkaterulet.getSize().getWidth(),Minimum_Meret);}
				}
				main.keret.setVisible(true);
				
			}

		});
	}
	
	public void Valami() {
		main.Munkaterulet.setBackground(new Color(0,100,100,200));
	}
	public void Font_Nevek() {
		Font[] style;
		style=GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
		for(Font font:style) {
			System.out.println(font.getFamily());
		}
	}
	

}
