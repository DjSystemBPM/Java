package com.java.xml.dom.countelement.file;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CountXMLElement {

	private static final String RUTA_XML = "src/com/java/xml/dom/countelement/file/" + "Archivo.xml";
	
	public static void main(String argv[]) {

		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(RUTA_XML);

			NodeList list = doc.getElementsByTagName("staff");

			System.out.println("Total of elements : " + list.getLength());

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	  }
}
