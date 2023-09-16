package Jatek;

import javax.swing.*;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class Ablak extends JFrame {
    private static  int versenyzolista=5;
    private static  int currentIndex = -1;
    private JTextArea chatBox;
    
    //Változó adatok amik Label vagy ChatBox-ba futnak int ként is String be jeleníti meg
    

    

    Ablak() {

       
    	//Hős Támadás gomb
        JButton HeroAttackBtn = new JButton("Támadás");
        HeroAttackBtn.setBounds(10, 300, 100, 40); // Balról - Fentről - Szélesség - Magasság
        add(HeroAttackBtn);

        //Hős Damage boost gonb
        JButton HeroDamageBoostBtn = new JButton("DMG Boost");
        HeroDamageBoostBtn.setBounds(110, 300, 100, 40);
        add(HeroDamageBoostBtn);
        
        //Hős healelés mana ki írása
        HeroDamageBoostBtn.addMouseListener(new MouseListener() { 

            @Override
            public void mouseEntered(MouseEvent e) {
                // Egér belép a gomb területére
            	HeroDamageBoostBtn.setText("10 Mana"); // Gomb feliratának megváltoztatása
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Egér kilép a gomb területéről
            	HeroDamageBoostBtn.setText("DMG Boost"); // Gomb eredeti feliratának visszaállítása
            }

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        
        //Hős healelés
        JButton HeroHealBtn = new JButton("Healelés");
        HeroHealBtn.setBounds(210, 300, 100, 40);
        add(HeroHealBtn);

        //Hős healelés mana ki írása
        HeroHealBtn.addMouseListener(new MouseListener() { 

            @Override
            public void mouseEntered(MouseEvent e) {
                // Egér belép a gomb területére
                HeroHealBtn.setText("5 Mana"); // Gomb feliratának megváltoztatása
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Egér kilép a gomb területéről
                HeroHealBtn.setText("Healelés"); // Gomb eredeti feliratának visszaállítása
            }

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
	
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
		
				
			}
        });
        
        
        //Jelenlegi kör chat panel
        chatBox = new JTextArea();
        chatBox.setBounds(270, 130, 200, 50); // Balról - Fentről - Szélesség - Magasság
        chatBox.setEditable(false);
        chatBox.setText("Jelenlegi kör = 12");
        add(chatBox);
       
    	// Hős nevének ki írása
    	JLabel Hero_Nev = new JLabel(Hero.getNev());
    	Hero_Nev.setBounds(70,10,200,200);
    	Font Hero_Nev_labelFont = Hero_Nev.getFont();
    	Hero_Nev.setFont(new Font(Hero_Nev_labelFont.getName(), Font.BOLD, 24));
    	add(Hero_Nev);
    	
    	
    	//Hős életének ki írása
    	//String HERO_ELET= Integer.toString(Hero.getElet());
    	JLabel Hero_Elet = new JLabel("Életerő = "+Hero.getElet());
    	Hero_Elet.setBounds(50,40,200,200);
    	Font Hero_Elet_labelFont = Hero_Elet.getFont();
    	Hero_Elet.setFont(new Font(Hero_Elet_labelFont.getName(), Font.BOLD, 18));
    	Hero_Elet.setForeground(Color.RED);    	
    	add(Hero_Elet);
    	
    	//Hős manájának ki írása
    	String HERO_MANA= Integer.toString(Hero.getMana());
    	JLabel Hero_Mana = new JLabel("Mana = "+HERO_MANA);
    	Hero_Mana.setBounds(50,60,200,200);
    	Font Hero_Mana_labelFont = Hero_Mana.getFont();
    	Hero_Mana.setFont(new Font(Hero_Mana_labelFont.getName(), Font.BOLD, 18));
    	Hero_Mana.setForeground(Color.BLUE);    	
    	add(Hero_Mana);
    	
    	//Hős damage ki írása
    	String HERO_DAMAGE= Integer.toString(Hero.getDamage());
    	JLabel Hero_Damage = new JLabel("Sebzés = "+HERO_DAMAGE);
    	Hero_Damage.setBounds(50,80,200,200);
    	Font Hero_Damage_labelFont = Hero_Damage.getFont();
    	Hero_Damage.setFont(new Font(Hero_Damage_labelFont.getName(), Font.BOLD, 18));
    	Hero_Damage.setForeground(Color.BLACK);    	
    	add(Hero_Damage);

    	//Badguy életének ki írása
    	JLabel Badguy_Nev = new JLabel(Badguy.getNev());
    	Badguy_Nev.setBounds(570,10,200,200);
    	Font _Badguy_NevlabelFont = Badguy_Nev.getFont();
    	Badguy_Nev.setFont(new Font(_Badguy_NevlabelFont.getName(), Font.BOLD, 24));
    	add(Badguy_Nev);
    	
    	//Badguy életének ki írása
    	String BADGUY_ELET= Integer.toString(Badguy.getElet());
    	JLabel Badguy_Elet = new JLabel("Életerő = "+BADGUY_ELET);
    	Badguy_Elet.setBounds(570,40,200,200);
    	Font Badguy_Elet_labelFont = Badguy_Elet.getFont();
    	Badguy_Elet.setFont(new Font(Badguy_Elet_labelFont.getName(), Font.BOLD, 18));
    	Badguy_Elet.setForeground(Color.RED);    	
    	add(Badguy_Elet);
    	
    	//Badguy manájának ki írása
    	String BADGUY_MANA= Integer.toString(Badguy.getMana());
    	JLabel Badguy_Mana = new JLabel("Mana = "+BADGUY_MANA);
    	Badguy_Mana.setBounds(570,60,200,200);
    	Font Badguy_Mana_labelFont = Badguy_Mana.getFont();
    	Badguy_Mana.setFont(new Font(Badguy_Mana_labelFont.getName(), Font.BOLD, 18));
    	Badguy_Mana.setForeground(Color.BLUE);    	
    	add(Badguy_Mana);
        
        
        

        setSize(800, 600);
        
        setLayout(null);
        getContentPane().setBackground(Color.CYAN);
        setVisible(true);

        HeroAttackBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent mindegy) {
            	
                	int Hero_Elet_Int=Hero.getElet();
                    String Hero_Chat_Elet= String.valueOf(Hero_Elet_Int);                                        
                    Hero_Elet_Int=((Hero.getElet()-5));
                    
                    Hero.setElet(Hero_Elet_Int);
                    System.out.print(Hero.getElet());
                    Hero_Elet.setText("Életerő Változott = "+Hero.getElet());
                    
                    
                
            }
        });

        HeroDamageBoostBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent mindegy) {
                if (currentIndex < versenyzolista) {
                    currentIndex++;

                    chatBox.setText(""+currentIndex);
                    
                }
            }
        });
    }

    public static void main(String[] args) {
    	new Ablak();
    }

}
