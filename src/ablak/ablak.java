package ablak;

import java.awt.*;
import java.awt.event.*;

public class ablak extends Frame {
	public ablak() {
		super("ablak");
		//add(new Label("Megszentségteleníthetetlenségeskedéseitekért"));
		//add(new Button("Majdnem kilépés"));
		//add(new Checkbox("Jelölés?"));
		//add(new TextField("Mit is írjak ide?"));
		//add(new TextArea("Valamit írni kéne"));
		
		/*List lista=new List();
		lista.add("Hesoyam");
		lista.add("Aezakmi");
		add(lista);
		*/
		
		/*Choice lista=new Choice();
		lista.add("Hesoyam");
		lista.add("Aezakmi");
		add(lista);
		*/
		
		Panel gombok=new Panel();
		gombok.setLayout(new GridLayout(0,4));
		gombok.add(new Button("Keresés"));
		gombok.add(new Button("Bezárás"));
		gombok.add(new Button("Kiír"));
		gombok.add(new Button("Beír"));
		add(gombok);
		
		
	
	}
	
	

	public static void main(String[] args) {
		ablak ablak=new ablak();
		ablak.setSize(400,400);
		ablak.setVisible(true);

	}
	

}

