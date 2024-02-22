package UtolsoHonap3;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


import java.io.File;
import javax.xml.parsers.*;


public class main {
	public static void main(String[] args) {
		try {
			
			File inputFile=new File("muvhaz.xml");
			DocumentBuilderFactory a=DocumentBuilderFactory.newInstance();
			DocumentBuilder b=a.newDocumentBuilder();
			Document c=b.parse(inputFile);
			c.getDocumentElement().normalize();
			System.out.println(c.getDocumentElement().getNodeName());
			NodeList kiallitaslista=c.getElementsByTagName("kiallitas");
			System.out.println("\nProgramok szama:"+kiallitaslista.getLength());
			for (int i=0;i<kiallitaslista.getLength();i++) {
				
				Node d=kiallitaslista.item(i);
				Element e=(Element) d;
				System.out.println("Program cime: "+e.getElementsByTagName("cim").item(0).getTextContent());
				System.out.println("Program datuma: "+e.getElementsByTagName("datum").item(0).getTextContent());
				System.out.println("Belepo ara: "+e.getElementsByTagName("ar").item(0).getTextContent());
				System.out.println("Korosztalynak javasolt: "+e.getElementsByTagName("korosztaly").item(0).getTextContent()+"\n");
			}
		}
		catch(Exception f) {
			f.printStackTrace();
		}
				
	}
}



