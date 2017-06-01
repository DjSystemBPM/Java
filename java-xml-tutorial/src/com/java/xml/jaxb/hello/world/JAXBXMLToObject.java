package com.java.xml.jaxb.hello.world;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBXMLToObject {
	
	private static final String RUTA_XML = "src/com/java/xml/jaxb/hello/world/" + "JAXB.xml";
	
	public static void main(String[] args) {

		 try {

			File file = new File(RUTA_XML);
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer.toString());

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }

		}
}
