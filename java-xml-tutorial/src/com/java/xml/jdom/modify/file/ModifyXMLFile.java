package com.java.xml.jdom.modify.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class ModifyXMLFile {

	private static final String RUTA_XML = "src/com/java/xml/jdom/modify/file/" + "Archivo.xml";

	public static void main(String[] args) {

		  try {

			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File(RUTA_XML);

			Document doc = (Document) builder.build(xmlFile);
			Element rootNode = doc.getRootElement();

			// update staff id attribute
			Element staff = rootNode.getChild("staff");
			staff.getAttribute("id").setValue("2");

			// add new age element
			Element age = new Element("age").setText("28");
			staff.addContent(age);

			// update salary value
			staff.getChild("salary").setText("7000");

			// remove firstname element
			staff.removeChild("firstname");

			XMLOutputter xmlOutput = new XMLOutputter();

			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter(RUTA_XML));

			// xmlOutput.output(doc, System.out);

			System.out.println("[:::: ARCHIVO ACTUALIZADO ::::]");
		  } catch (IOException io) {
			io.printStackTrace();
		  } catch (JDOMException e) {
			e.printStackTrace();
		  }
		}
}
