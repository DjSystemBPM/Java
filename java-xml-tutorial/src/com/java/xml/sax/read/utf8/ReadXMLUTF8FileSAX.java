package com.java.xml.sax.read.utf8;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * @author Ing. Alfredo Cuevas Barrera
 *
 *Esta clase resuelve los caracteres raros de un xml:
 *
 *com.sun.org.apache.xerces.internal.impl.io.MalformedByteSequenceException:
 *Invalid byte 1 of 1-byte UTF-8 sequence.
 *
 */
public class ReadXMLUTF8FileSAX {

	private static final String RUTA_XML = "src/com/java/xml/sax/read/utf8/" + "Archivo.xml";
	
	public static void main( String[] args )
    {
    	try {

    	      SAXParserFactory factory = SAXParserFactory.newInstance();
    	      SAXParser saxParser = factory.newSAXParser();

    	      DefaultHandler handler = new DefaultHandler() {

    	        boolean bfname = false;
    	        boolean blname = false;
    	        boolean bnname = false;
    	        boolean bsalary = false;

    	        public void startElement(String uri, String localName,
    	            String qName, Attributes attributes)
    	            throws SAXException {

    	          System.out.println("Start Element :" + qName);

    	          if (qName.equalsIgnoreCase("FIRSTNAME")) {
    	        	  bfname = true;
    	          }

    	          if (qName.equalsIgnoreCase("LASTNAME")) {
    	        	  blname = true;
    	          }

    	          if (qName.equalsIgnoreCase("NICKNAME")) {
    	        	  bnname = true;
    	          }

    	          if (qName.equalsIgnoreCase("SALARY")) {
    	        	  bsalary = true;
    	          }

    	        }

    	        public void endElement(String uri, String localName,
    	                String qName)
    	                throws SAXException {

    	              System.out.println("End Element :" + qName);

    	        }

    	        public void characters(char ch[], int start, int length)
    	            throws SAXException {

    	          System.out.println(new String(ch, start, length));


    	          if (bfname) {
    	            System.out.println("First Name : "
    	                + new String(ch, start, length));
    	            bfname = false;
    	          }

    	          if (blname) {
    	              System.out.println("Last Name : "
    	                  + new String(ch, start, length));
    	              blname = false;
    	           }

    	          if (bnname) {
    	              System.out.println("Nick Name : "
    	                  + new String(ch, start, length));
    	              bnname = false;
    	           }

    	          if (bsalary) {
    	              System.out.println("Salary : "
    	                  + new String(ch, start, length));
    	              bsalary = false;
    	           }

    	        }

    	      };

    	      File file = new File(RUTA_XML);
    	      InputStream inputStream= new FileInputStream(file);
    	      Reader reader = new InputStreamReader(inputStream,"UTF-8");

    	      InputSource is = new InputSource(reader);
    	      is.setEncoding("UTF-8");

    	      saxParser.parse(is, handler);


    	    } catch (Exception e) {
    	      e.printStackTrace();
    	    }

    }
}
