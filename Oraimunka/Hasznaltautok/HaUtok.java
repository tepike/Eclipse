// XML fájlok kezelése
package Hasznaltautok;
import java.util.Scanner;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;


public class HaUtok {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		Scanner bevitel = new Scanner(System.in);
		
		try {
		File inputFile=new File("Hasznaltautok.xml");
		DocumentBuilderFactory a=DocumentBuilderFactory.newInstance();
		DocumentBuilder b=a.newDocumentBuilder();
		Document c=b.parse(inputFile);
		c.getDocumentElement().normalize();
		System.out.println("Gyoker neve= "+c.getDocumentElement().getNodeName());

		
		NodeList autolista=c.getElementsByTagName("auto");
		System.out.println("Autok szama:"+autolista.getLength());
		for (int i=0;i<autolista.getLength();i++) {
			
			Node d=autolista.item(i);
			
			Element e=(Element) d;
			System.out.println("\nAuto Uzemanyaga:"+e.getAttribute("Uzemanyag"));
			System.out.println("Auto Tipusa:"+e.getElementsByTagName("Tipus").item(0).getTextContent());
			System.out.println("Auto Szine:"+e.getElementsByTagName("Szin").item(0).getTextContent());
			System.out.println("Auto Evjarata:"+e.getElementsByTagName("Evjarat").item(0).getTextContent());
			System.out.println("Auto Fogyasztasa:"+e.getElementsByTagName("Fogyasztas").item(0).getTextContent()+"\n");
			
		}
		}
	

	catch(Exception f) {
		f.printStackTrace();
	}
		

	
//Feladat 2
		System.out.print("Add meg az auto evszamat: ");
		String Bekert_evszam=bevitel.next();
		System.out.println("A megadott evszam = "+Bekert_evszam);


		File inputFile=new File("Hasznaltautok.xml");
		DocumentBuilderFactory a=DocumentBuilderFactory.newInstance();
		DocumentBuilder b=a.newDocumentBuilder();
		Document c=b.parse(inputFile);
		c.getDocumentElement().normalize();
		boolean Bekert_Ev_Vizsgalat=false;
		
		NodeList autolista=c.getElementsByTagName("auto");
		for (int i=0;i<autolista.getLength();i++) {
			
			Node d=autolista.item(i);
			Element e=(Element) d;
			//System.out.println(e.getElementsByTagName("Evjarat").item(0).getTextContent());
			String alma=e.getElementsByTagName("Evjarat").item(0).getTextContent();
			//System.out.println(alma);
			if (Bekert_evszam.equals(alma)) {
			
				System.out.println("\nEvjarathoz megfelelo auto = "+e.getElementsByTagName("Tipus").item(0).getTextContent());	
				Bekert_Ev_Vizsgalat=true;
			}
		

		}		if(Bekert_Ev_Vizsgalat==false) {
			System.out.println("\nNincs talalat");	
		}
	}
	}
	


		
		
		
		




	
	
	

