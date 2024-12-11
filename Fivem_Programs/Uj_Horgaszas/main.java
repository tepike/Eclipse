package Uj_Horgaszas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class main {
	static JFrame Keret = new JFrame();
	//Felirat 1
	static JLabel Label1 = new JLabel("Horgászbot:");
	static JLabel Label1_gomb = new JLabel("Click");
	static int figyelo_1=0;
	static JLabel Label1_seged = new JLabel("Nyomd meg a használni kívánt gombot");
	//Felirat 2
	static JLabel Label2 =new JLabel("Kapásban lévő körök:");
	static JTextField Label2_text= new JTextField();
	static boolean Text_Aktiv=false;
	static int Kapas_kor=1;
	//Felirat 3
	static JLabel Label3=new JLabel("Program elindítási gomb:");
	static JLabel Label3_gomb= new JLabel("Click");
	static JLabel Label3_seged = new JLabel("Nyomd meg a használni kívánt gombot");
	static int figyelo_3=0;
	static int Indithato=0;
	static boolean Indithato_Boolean=false;
	//Felirat 4
	static JLabel Horgaszat_Aktiv= new JLabel("Horgászat aktív: ");
	static JLabel Horgaszat_Aktiv_Visszajelzes= new JLabel("o");
	//Felirat 5
	static JLabel Elemzes_Aktiv= new JLabel("Elemzés aktív: ");
	static JLabel Elemzes_Aktiv_Visszajelzes= new JLabel("o");
	
	static JLabel Bezaras_Label=new JLabel("X");
	static int Keret_szeles=700;
	static int Keret_magas=500;
	
	static int pointerX = (int)MouseInfo.getPointerInfo().getLocation().getX();
	static int pointerY = (int)MouseInfo.getPointerInfo().getLocation().getY();
	static Timer timer2 = new Timer();
	static Timer timer1 = new Timer();
	
	//Kép elemzési szakasz
	static JFrame Elemzo= new JFrame();

	public static void main(String[] args) {
		

		Keret.setSize(Keret_szeles, Keret_magas);
		Keret.setLocationRelativeTo(null);
		Keret.setUndecorated(true);
		Keret.setDefaultCloseOperation(Keret.EXIT_ON_CLOSE);
		Keret.setAlwaysOnTop(true);

		Keret.setLayout(null);
		Keret.setResizable(false);
		Keret.setBackground(new Color(100,100,100,200));
		
		Horgaszbot_Felirat();
		Masodik_Felirat();
		Harmadik_Felirat();
		Negyedik_Felirat();
		Otodik_Felirat();
		Program_Elinditas_Figyelo();
		KepElemzes.Indul();
		

	
		Bezaras_Label.setBounds(Keret.getWidth()-25,5,20,20);
		Bezaras_Label.setFont(new Font("Arial Black", Font.BOLD, 20));
		Bezaras_Label.setVisible(true);

		Keret.getContentPane().addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mousePressed(MouseEvent e) {
	        		if(e.getButton()==MouseEvent.BUTTON1) {
	        			panelmozgat();
	        		}
	        		
	        	}
	        	@Override
	        	public void mouseReleased(MouseEvent e) {
	        		if(e.getButton()==MouseEvent.BUTTON1) {
	        			panelleark();
	        		}
	        		
	        	}
	        
	        });
		
		Elemzo.getContentPane().addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		if(e.getButton()==MouseEvent.BUTTON1) {
        			elemzomozgat();
        		}
        		if(e.getButton()==MouseEvent.BUTTON3) {
        			System.out.println("Jobb egeret nyomtal");
        			elemmeretez();
        		}
        		
        	}
        	@Override
        	public void mouseReleased(MouseEvent e) {
        		if(e.getButton()==MouseEvent.BUTTON1) {
        			elemzoleark();
        		}
        		if(e.getButton()==MouseEvent.BUTTON3) {
        			System.out.println("Jobb egeret nyomtal");
        			elemzoleark();
        		}
        		
        	}
        
        });
		
		Keret.add(Bezaras_Label);
		
		Keret.setVisible(true);

		Bezaras_Label.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(0);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		}) ;}
		
	    //Panel mozgatása ha lenyomva van az egér
	    static void panelmozgat() {
	    	 pointerX = (int)MouseInfo.getPointerInfo().getLocation().getX();
	    	 pointerY = (int)MouseInfo.getPointerInfo().getLocation().getY();
	    	 timer2 = new Timer();
	    	 timer2.scheduleAtFixedRate(new TimerTask() {
	    		 int i =0;
	    		 
	             @Override
	             public void run() {
	            	int pointerX2= (int)MouseInfo.getPointerInfo().getLocation().getX();
	             	int pointerY2=(int)MouseInfo.getPointerInfo().getLocation().getY();
	             	if(pointerX2>pointerX) {
	             		 Keret.setLocation((int)Keret.getLocation().getX()+(pointerX2-pointerX), (int)Keret.getLocation().getY());
	             		 pointerX=pointerX2;
	             	}else {
	             		Keret.setLocation((int)Keret.getLocation().getX()-(pointerX-pointerX2), (int)Keret.getLocation().getY());
	            		 pointerX=pointerX2;
	             	}
	             	if(pointerY2>pointerY) {
	             		Keret.setLocation((int)Keret.getLocation().getX(), (int)Keret.getLocation().getY()+(pointerY2-pointerY));
	             		pointerY=pointerY2;
	             	}else {
	             		Keret.setLocation((int)Keret.getLocation().getX(), (int)Keret.getLocation().getY()+(pointerY2-pointerY));
	             		pointerY=pointerY2;
	             	}
	             	
	            	 System.out.println(i);
	            	 i++;
	            	 Keret.setLocation((int)Keret.getLocation().getX(), (int)Keret.getLocation().getY());
	                 
	                 
	             }
	         },0, 10);
	    
	}
	    static void panelleark() {
			timer2.cancel();
	    	timer2=new Timer();
	    
	    }
	    static void elemzomozgat() {
	    	 pointerX = (int)MouseInfo.getPointerInfo().getLocation().getX();
	    	 pointerY = (int)MouseInfo.getPointerInfo().getLocation().getY();
	    	 timer1 = new Timer();
	    	 timer1.scheduleAtFixedRate(new TimerTask() {
	    		 int i =0;
	    		 
	             @Override
	             public void run() {
	            	int pointerX2= (int)MouseInfo.getPointerInfo().getLocation().getX();
	             	int pointerY2=(int)MouseInfo.getPointerInfo().getLocation().getY();
	             	if(pointerX2>pointerX) {
	             		Elemzo.setLocation((int)Elemzo.getLocation().getX()+(pointerX2-pointerX), (int)Elemzo.getLocation().getY());
	             		 pointerX=pointerX2;
	             	}else {
	             		Elemzo.setLocation((int)Elemzo.getLocation().getX()-(pointerX-pointerX2), (int)Elemzo.getLocation().getY());
	            		 pointerX=pointerX2;
	             	}
	             	if(pointerY2>pointerY) {
	             		Elemzo.setLocation((int)Elemzo.getLocation().getX(), (int)Elemzo.getLocation().getY()+(pointerY2-pointerY));
	             		pointerY=pointerY2;
	             	}else {
	             		Elemzo.setLocation((int)Elemzo.getLocation().getX(), (int)Elemzo.getLocation().getY()+(pointerY2-pointerY));
	             		pointerY=pointerY2;
	             	}
	             	
	            	 System.out.println(i);
	            	 i++;
	            	 Elemzo.setLocation((int)Elemzo.getLocation().getX(), (int)Elemzo.getLocation().getY());
	                 
	                 
	             }
	         },0, 10);
	    
	}
	    static void elemzoleark() {
			timer1.cancel();
	    	timer1=new Timer();
			timer2.cancel();
	    	timer2=new Timer();
	    
	    }
	    static void elemmeretez() {
	    	pointerX= (int)MouseInfo.getPointerInfo().getLocation().getX();
	    	pointerY=(int)MouseInfo.getPointerInfo().getLocation().getY();
	    	timer2 = new Timer();
	    	 timer2.scheduleAtFixedRate(new TimerTask() {
	             @Override
	             public void run() {
	            	int pointerX2= (int)MouseInfo.getPointerInfo().getLocation().getX();
	             	int pointerY2=(int)MouseInfo.getPointerInfo().getLocation().getY();
	             	if(pointerX2>pointerX) {
	             		Elemzo.setSize(Elemzo.getWidth()+(pointerX2-pointerX), Elemzo.getHeight());
	             		pointerX=pointerX2;
	             		if(Elemzo.getWidth()<10) {
	             			Elemzo.setSize(10,Elemzo.getHeight());
	             		}
	             	}else {
	             		Elemzo.setSize(Elemzo.getWidth()-(pointerX-pointerX2), Elemzo.getHeight());
	             		pointerX=pointerX2;
	             		if(Elemzo.getWidth()<10) {
	             			Elemzo.setSize(10,Elemzo.getHeight());
	             		}
	             	}
	             	if(pointerY2>pointerY) {
	             		Elemzo.setSize(Elemzo.getWidth(), Elemzo.getHeight()+(pointerY2-pointerY));
	             		pointerY=pointerY2;
	             		if(Elemzo.getHeight()<20) {
	             			Elemzo.setSize(Elemzo.getWidth(),20);
	             		}
	             	}else {
	             		Elemzo.setSize(Elemzo.getWidth(), Elemzo.getHeight()-(pointerY-pointerY2));
	             		pointerY=pointerY2;
	             		if(Elemzo.getHeight()<20) {
	             			Elemzo.setSize(Elemzo.getWidth(),20);
	             		}
	             	}
	             }       
	         },0, 10);
	    }	    
	    static void Horgaszbot_Felirat() {
			Keret.add(Label1);
			Keret.add(Label1_gomb);
			Keret.add(Label1_seged);
			//Horgászbot felirat
			Label1.setFont(new Font("Arial Bold", 0, 25));
			Label1.setForeground(Color.white);
			Label1.setBounds(30, 50, Label1.getText().length()*14, 25);
			Label1.setVisible(true);
			//Nyomandó gomb
			Label1_gomb.setFont(new Font("Arial Bold", 0, 25));
			Label1_gomb.setForeground(Color.white);
			Label1_gomb.setBounds((int)Label1.getLocation().getX()+Label1.getWidth()+5, 45, Label1_gomb.getText().length()*14, 35);
			Label1_gomb.setBorder(BorderFactory.createRaisedBevelBorder());
			
			Label1_seged.setFont(new Font("Arial Bold", 0, 22));
			Label1_seged.setForeground(Color.yellow);
			Label1_seged.setBounds((int)Label1_gomb.getLocation().getX()+Label1_gomb.getWidth()+10, 50, Label1_seged.getText().length()*14, 25);
			Label1_seged.setVisible(false);
			
			 try {
					GlobalScreen.registerNativeHook();
				} catch (NativeHookException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			
			Label1_gomb.addMouseListener(new MouseListener() {
				
				
				@Override
				public void mouseReleased(MouseEvent e) {
					
					System.out.println("Kattintva");
					Label1_seged.setVisible(true);
					figyelo_1++;
					if(figyelo_1==1) {
					GlobalScreen.addNativeKeyListener(new NativeKeyListener()
				    {

				        @Override
				        public void nativeKeyTyped(NativeKeyEvent e)
				        {
				        	
				        }

				        @Override
				        public void nativeKeyReleased(NativeKeyEvent e)
				        {
				        	if(figyelo_1==1) {
				            String keyText=NativeKeyEvent.getKeyText(e.getKeyCode());
				            //System.out.println("User typed: "+keyText);
				            Label1_gomb.setText(keyText);
				            //Label1_gomb.setAlignmentX(0);
				            //System.out.println(figyelo_1);
				            figyelo_1=0;
				            Label1_seged.setVisible(false);
				        	}
				            
				        }

				        @Override
				        public void nativeKeyPressed(NativeKeyEvent e)
				        {
				        	
				        }
				    });
					}
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			
			Label1_gomb.setVisible(true);
			
	    }
        static void Masodik_Felirat() {
        	Keret.add(Label2);
        	Keret.add(Label2_text);
        	Label2.setBounds((int)Label1.getLocation().getX(),(int)Label1.getLocation().getY()+60, Label2.getText().length()*14, 25);
        	Label2.setFont(new Font("Arial Bold", 0, 25));
        	Label2.setForeground(Color.white);
        	
        	Label2_text.setFont(new Font("Arial Bold", 0, 25));
        	Label2_text.setBounds((int)Label2.getLocation().getX()+Label2.getText().length()*14,(int)Label2.getLocation().getY(), 50, 25);
        	Label2_text.setEditable(false);
        	Label2_text.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					Text_Aktiv=true;
					Label2_text.setEditable(true);
					
					GlobalScreen.addNativeKeyListener(new NativeKeyListener()
				    {

				        @Override
				        public void nativeKeyTyped(NativeKeyEvent e)
				        {
				        	
				        }

				        @Override
				        public void nativeKeyReleased(NativeKeyEvent e)
				        {
				        	if(Text_Aktiv) {
				        		String keyText=NativeKeyEvent.getKeyText(e.getKeyCode());
				        		System.out.println("Ellenorzes a gombra: "+keyText);
				        		if(keyText.equals("Enter")) {
				        		System.out.println("A lenyomott gomb az enter");
				        		Text_Aktiv=false;
				        		Label2_text.setEditable(false);
				        		Kapas_kor=Integer.parseInt(Label2_text.getText());
				        		}
				        		
				        	}
				            
				        }

				        @Override
				        public void nativeKeyPressed(NativeKeyEvent e)
				        {
				        	
				        }});
				    
					
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
        	
			
        	
        }
        static void Harmadik_Felirat() {
        	Keret.add(Label3);
        	Keret.add(Label3_gomb);
        	Keret.add(Label3_seged);
        	
			Label3.setFont(new Font("Arial Bold", 0, 25));
			Label3.setForeground(Color.white);
			Label3.setBounds((int)Label2.getLocation().getX(),(int)Label2.getLocation().getY()+60, Label3.getText().length()*13, 25);
			Label3.setVisible(true);
			//Nyomandó gomb
			Label3_gomb.setFont(new Font("Arial Bold", 0, 25));
			Label3_gomb.setForeground(Color.white);
			Label3_gomb.setBounds((int)Label3.getLocation().getX()+Label3.getWidth()-5,(int)Label3.getLocation().getY()-5, Label3_gomb.getText().length()*14, 35);
			Label3_gomb.setBorder(BorderFactory.createRaisedBevelBorder());
			
			Label3_seged.setFont(new Font("Arial Bold", 0, 22));
			Label3_seged.setForeground(Color.yellow);
			Label3_seged.setBounds((int)Label3.getLocation().getX(),(int)Label3.getLocation().getY()+35, Label3_seged.getText().length()*14, 25);
			Label3_seged.setVisible(false);
        	
        	
        	
			Label3_gomb.addMouseListener(new MouseListener() {
				
				
				@Override
				public void mouseReleased(MouseEvent e) {
					Indithato=0;
					Indithato_Boolean=false;
					
					System.out.println("Kattintva");
					Label3_seged.setVisible(true);
					figyelo_3++;
					if(figyelo_3==1) {
					GlobalScreen.addNativeKeyListener(new NativeKeyListener()
				    {

				        @Override
				        public void nativeKeyTyped(NativeKeyEvent e)
				        {
				        	
				        }

				        @Override
				        public void nativeKeyReleased(NativeKeyEvent e)
				        {
				        	if(figyelo_3==1) {
				            String keyText=NativeKeyEvent.getKeyText(e.getKeyCode());
				            //System.out.println("User typed: "+keyText);
				            Label3_gomb.setText(keyText);
				            
				            System.out.println(figyelo_3);
				            figyelo_3=0;
				            Label3_seged.setVisible(false);
				            Indithato++;
				            Indithato_Boolean=true;
				        	}
				            
				        }

				        @Override
				        public void nativeKeyPressed(NativeKeyEvent e)
				        {
				        	
				        }
				    });
					}
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
        	
        }
        static void Negyedik_Felirat() {
        	Keret.add(Horgaszat_Aktiv);
        	Keret.add(Horgaszat_Aktiv_Visszajelzes);
        	
        	Horgaszat_Aktiv.setFont(new Font("Arial Bold", 0, 25));
        	Horgaszat_Aktiv.setForeground(Color.white);
        	Horgaszat_Aktiv.setBounds((int)Label3.getLocation().getX(),(int)Label3.getLocation().getY()+60, Horgaszat_Aktiv.getText().length()*13, 25);
        	Horgaszat_Aktiv.setVisible(true);
        	
        	Horgaszat_Aktiv_Visszajelzes.setFont(new Font("Arial Bold", 0, 40));
        	Horgaszat_Aktiv_Visszajelzes.setForeground(Color.RED);
        	Horgaszat_Aktiv_Visszajelzes.setBackground(Color.RED);
        	Horgaszat_Aktiv_Visszajelzes.setBounds((int)Horgaszat_Aktiv.getLocation().getX()+Horgaszat_Aktiv.getText().length()*12,(int)Label3.getLocation().getY()+54, 40, 30);
        	Horgaszat_Aktiv_Visszajelzes.setVisible(true);
        	
        }
        static void Otodik_Felirat() {
        	Keret.add(Elemzes_Aktiv);
        	Keret.add(Elemzes_Aktiv_Visszajelzes);
        	
        	Elemzes_Aktiv.setFont(new Font("Arial Bold", 0, 25));
        	Elemzes_Aktiv.setForeground(Color.white);
        	Elemzes_Aktiv.setBounds((int)Horgaszat_Aktiv.getLocation().getX(),(int)Horgaszat_Aktiv.getLocation().getY()+60, Elemzes_Aktiv.getText().length()*13, 25);
        	Elemzes_Aktiv.setVisible(true);
        	
        	Elemzes_Aktiv_Visszajelzes.setFont(new Font("Arial Bold", 0, 40));
        	Elemzes_Aktiv_Visszajelzes.setForeground(Color.RED);
        	Elemzes_Aktiv_Visszajelzes.setBackground(Color.RED);
        	Elemzes_Aktiv_Visszajelzes.setBounds((int)Elemzes_Aktiv.getLocation().getX()+Elemzes_Aktiv.getText().length()*12,(int)Horgaszat_Aktiv.getLocation().getY()+54, 40, 30);
        	Elemzes_Aktiv_Visszajelzes.setVisible(true);
        }
        static void Program_Elinditas_Figyelo() {
        	GlobalScreen.addNativeKeyListener(new NativeKeyListener()
		    {

		        @Override
		        public void nativeKeyTyped(NativeKeyEvent e)
		        {
		        	
		        }

		        @Override
		        public void nativeKeyReleased(NativeKeyEvent e)
		        {
		        	
		        	if(Indithato_Boolean) {
		        		Indithato++;
		            String keyText=NativeKeyEvent.getKeyText(e.getKeyCode());
		            //System.out.println("User typed: "+keyText);
		            if(Indithato>2) {
		            if(keyText.equals(Label3_gomb.getText())) {
		            	System.out.println("Megegyezik az indito gombbal!");
		            }else {
		            	System.err.println("Hiba van a felismeresben: "+Label3_gomb.getText()+" Bejott gomb: "+keyText);
		            		}
		            	}
		            }
		            

		        	
		            
		        }

		        @Override
		        public void nativeKeyPressed(NativeKeyEvent e)
		        {
		        	
		        }
		    });
        }
}

