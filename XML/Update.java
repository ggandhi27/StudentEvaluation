package com.javaxml;

import entity.User;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;	
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import com.javaxml.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class Update {

	
	
	
	
	public static void main(String[] argv) {
		try {
			
			User obj = new User();

			String filepath = "E:\\Spring_suite_workspace\\JavaXml\\src\\com\\javaxml\\"+obj.getUname()+".xml";
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(filepath);
	        doc.getDocumentElement().normalize();
	        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	        //node list
	        NodeList fnameList = doc.getElementsByTagName("fname");
	        NodeList lnameList = doc.getElementsByTagName("lname");
	        NodeList passwordList = doc.getElementsByTagName("password");
	        NodeList mobileList = doc.getElementsByTagName("mobile");
	        
	        //converting to nodes
	        Node fname = fnameList.item(0);
	        Node lname = lnameList.item(0);
	        Node password = passwordList.item(0);
	        Node mobile = mobileList.item(0);
	        
	        
	        //to be added inside methods
	        fname.setTextContent("hari");
	        lname.setTextContent("sadu");
	        password.setTextContent("ragnar");
	        mobile.setTextContent("124214");
	        
	        
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);
	        
	        
		}
		catch (Exception e) {
	         e.printStackTrace();
	    }  
		
		  
		  //creation(obj);
		  
	   }
	
	
}
