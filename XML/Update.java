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

	
	
	private static NodeList fnameList;
	private static NodeList lnameList;
	private static NodeList passwordList;
	private static NodeList mobileList;

	public static void updateName(User obj) {
		
		obj.setFiName(fnameList.item(0));
		obj.setLaName(lnameList.item(0));
	}
	
	public static void updatePassword(User obj) {
		obj.setPass(passwordList.item(0));
	}
	
	public static void updateMNumber(User obj) {
		obj.setmNumber(mobileList.item(0));
	}
	
	public static void main(String[] argv) {
		try {
			
			User obj = new User();
			String filepath = "/tmp/"+obj.getUname()+".xml";
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(filepath);
	        doc.getDocumentElement().normalize();
	        fnameList = doc.getElementsByTagName("fname");
	        lnameList = doc.getElementsByTagName("lname");
	        passwordList = doc.getElementsByTagName("password");
	        mobileList = doc.getElementsByTagName("mobile");

	        
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);
	        
	        
		}
		catch (Exception e) {
	         e.printStackTrace();
	    }  
		  
	}
	
	
}
