package com.javaxml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import entity.User;

import java.io.File;
//import org.w3c.dom.Node;


public class CreateXml {

   public void creation(User obj) {

      try {
         DocumentBuilderFactory dbFactory =
         DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.newDocument();
         
         // root element
         Element rootElement = doc.createElement("users");
         doc.appendChild(rootElement);
         
         //username element
         Element uname = doc.createElement("uname");
         rootElement.appendChild(uname);
         uname.appendChild(doc.createTextNode(obj.getUname()));
         
         // password element
         Element password = doc.createElement("password");
         rootElement.appendChild(password);
         password.appendChild(doc.createTextNode(obj.getPassword()));			
         
         // security element
         Element security = doc.createElement("security");
         rootElement.appendChild(security);
         security.appendChild(doc.createTextNode("home town place?"));
         
         //securityAnswer element
         Element securityAnswer = doc.createElement("securityAnswer");
         rootElement.appendChild(securityAnswer);
         securityAnswer.appendChild(doc.createTextNode("Bhilai"));
         
         //mobile element
         Element mobile = doc.createElement("mobile");
         rootElement.appendChild(mobile);
         mobile.appendChild(doc.createTextNode("9889431655"));
         
         //email element
         Element email = doc.createElement("email");
         rootElement.appendChild(email);
         email.appendChild(doc.createTextNode("foster@gmail.com"));
         
         
         
         //tests child-parent element
         Element tests = doc.createElement("tests");
         rootElement.appendChild(tests);
         
         //counter child element of tests
         Element counter = doc.createElement("counter");
         tests.appendChild(counter);
         counter.appendChild(doc.createTextNode(""+0));
         
         

         
         // write the content into xml file
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         StreamResult result = new StreamResult(new File("E:\\Spring_suite_workspace\\JavaXml\\src\\com\\javaxml\\cars.xml"));
         transformer.transform(source, result);
         
         // Output to console for testing
         StreamResult consoleResult = new StreamResult(System.out);
         transformer.transform(source, consoleResult);
      } catch (Exception e) {
         e.printStackTrace();
      }
      
   }
}
