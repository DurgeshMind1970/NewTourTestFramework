package com.newtour.utilities;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
//import org.w3c.dom.Node;



//import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;
import com.newtour.genericfunctions.GenericFunctions;
import com.newtour.genericfunctions.GenericFunctions.PROPERTY;

public class XMLUtility {

	public static void f_createLogxml() throws Exception
	{
		
		DocumentBuilderFactory dbFactory=null;
		DocumentBuilder dBuilder =null;
		org.w3c.dom.Document doc =null;
		org.w3c.dom.Element logfilename=null;
		TransformerFactory transformerFactory=null;
		Transformer transformer =null;
		DOMSource source=null;
		StreamResult result =null;
		
		try
		{
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.newDocument();
		
			logfilename = doc.createElement("LogFileName");
	        
			 logfilename.appendChild(doc.createTextNode(GenericFunctions.f_generateRandomNumber()));
			 
	         doc.appendChild(logfilename);
	         
	         transformerFactory = TransformerFactory.newInstance();
	         transformer = transformerFactory.newTransformer();
	         source = new DOMSource(doc);
	         result = new StreamResult(new File(PropertyUtility.f_readProperty(PROPERTY.XMLLOG)));
	         transformer.transform(source, result);
	         
		}
		catch(Exception  e)
		{
			System.out.println(e.getLocalizedMessage());
			throw e;
		}
				
	}
	
	public static String f_readLogXML() throws Exception
	{
		File inputFile =null;
		DocumentBuilderFactory dbFactory =null;
		DocumentBuilder dBuilder=null;
		Document doc =null;
		
		try
		{
			inputFile = new File(PropertyUtility.f_readProperty(PROPERTY.XMLLOG));
	        dbFactory = DocumentBuilderFactory.newInstance();
	        dBuilder = dbFactory.newDocumentBuilder();
	        doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        org.w3c.dom.Node rootelement = doc.getFirstChild();
	        return rootelement.getTextContent();
	        
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			throw e;
		}
	  }
	
	
	public static void main(String[] a) throws Exception
	{
		XMLUtility.f_createLogxml();
		System.out.println(XMLUtility.f_readLogXML());
	}
}
