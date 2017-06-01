package com.java.xml.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author acuevas
 *
 */

public class XMLToPropertiesExample {

	private static final String RUTA_XML = "src/com/java/xml/properties/" + "email-configuration.xml";
	
	public static void main(String[] args) throws IOException
    {
    	Properties props = new Properties();

    	InputStream is = new FileInputStream(RUTA_XML);
    	//load the xml file into properties format
    	props.loadFromXML(is);

    	String email = props.getProperty("email.support");
    	System.out.println(email);

    }
}
