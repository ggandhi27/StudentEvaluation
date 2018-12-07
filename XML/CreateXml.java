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

   public static void creation(User obj) {

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
         Element question = doc.createElement("question");
         rootElement.appendChild(question);
         question.appendChild(doc.createTextNode(obj.getQuestion()));
         
         //securityAnswer element
         Element answer = doc.createElement("answer");
         rootElement.appendChild(answer);
         answer.appendChild(doc.createTextNode(obj.getAnswer()));
         
         //mobile element
         Element mobile = doc.createElement("mobile");
         rootElement.appendChild(mobile);
         mobile.appendChild(doc.createTextNode(obj.getMobile()));
         
         //email element
         Element email = doc.createElement("email");
         rootElement.appendChild(email);
         email.appendChild(doc.createTextNode(obj.getEmail()));
         
         
         
         //tests child-parent element
         Element tests = doc.createElement("tests");
         rootElement.appendChild(tests);
         
         //counter child element of tests
         Element counter = doc.createElement("counter");
         tests.appendChild(counter);
         counter.appendChild(doc.createTextNode(Integer.toString(obj.getCounter())));
         
         

         
         // write the content into xml file
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         StreamResult result = new StreamResult(new File("E:\\Spring_suite_workspace\\JavaXml\\src\\com\\javaxml\\"+obj.getUname()+".xml"));
         transformer.transform(source, result);
         
         // Output to console for testing
         StreamResult consoleResult = new StreamResult(System.out);
         transformer.transform(source, consoleResult);
      } catch (Exception e) {
         e.printStackTrace();
      }
      
   }
   public static void main(String[] argv) {
	   
	  User obj = new User();
	  System.out.print(obj.getPassword());
	  creation(obj);
	  
   }
}
	
