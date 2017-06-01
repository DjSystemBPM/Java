package com.java.xml.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesToXMLExample {
	
	private static final String RUTA_XML = "src/com/java/xml/properties/" + "email-configuration.xml";
	
	public static void main(String[] args) throws IOException
    {
    	Properties props = new Properties();
    	props.setProperty("email.support", "donot-spam-me@nospam.com");

    	//where to store?
    	OutputStream os = new FileOutputStream(RUTA_XML);

    	//store the properties detail into a pre-defined XML file
    	props.storeToXML(os, "Support Email","UTF-8");

    	System.out.println("Done");
    }
}
