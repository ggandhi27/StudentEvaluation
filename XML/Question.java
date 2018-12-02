package com.javaxml;
import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Question {
	static Scanner sc = new Scanner(System.in);
	static Scanner in = new Scanner(System.in);
//	private int count;
	private static int nchoice;
	private static String quest;
	private static String choice [] = new String[6];
	private static int answer;
	Element rootElement;
	Element number;
	Element question []= new Element[100];
	Element choices[] = new Element[6];
	Element ans;
	Attr attr;
	Attr attrtype[] = new Attr[6];
	
	public void recurse(int counter) {
		
		try {
			DocumentBuilderFactory dbFactory =DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			
			// root element
	        rootElement = doc.createElement("questions");
	        doc.appendChild(rootElement);
			
	        for(int i=0; i<counter; i++) {
				this.question();
				this.choice();
				this.ans();
				
				
				// Number element
		        number = doc.createElement("number");
		        rootElement.appendChild(number);
		        
		        //setting id attribute
		        attr = doc.createAttribute("id");
		        attr.setValue(""+(i+1));
		        number.setAttributeNode(attr);
		        
		        //Question element
		        question[i] = doc.createElement("question");
		        number.appendChild(question[i]);
		        question[i].appendChild(doc.createTextNode(Question.quest));
		        
		        
		        
		        for(int x = 0;x < Question.nchoice; x++) {
		        	//Choices elements
		        	
			        choices[x] = doc.createElement("choice");
		        	attrtype[x] = doc.createAttribute("id");
		        	attrtype[x].setValue(""+(x+1));
		        	choices[x].setAttributeNode(attrtype[x]);
		        	choices[x].appendChild(doc.createTextNode(Question.choice[x]));
		        	number.appendChild(choices[x]);
		        }
		        
		        //Answer Element
		        ans = doc.createElement("ans");
		        number.appendChild(ans);
		        ans.appendChild(doc.createTextNode(""+Question.answer));
		        
			}
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         
	         StreamResult result = new StreamResult(new File("E:\\Spring_suite_workspace\\JavaXml\\src\\com\\javaxml\\xc.xml"));
	         System.out.println("1");
	         transformer.transform(source, result);
	         System.out.println("2");
		}
			catch (Exception e) {
		         e.printStackTrace();
		    }
			
		
	}
	
	public void question() {
		System.out.print("Enter the Question:");
		Question.quest = in.nextLine();
	}
	
	public void choice() {
		System.out.print("Enter the number of choices:");
		Question.nchoice = sc.nextInt();
		
		for(int x = 0; x < Question.nchoice; x++) {
			System.out.print("Enter your choice "+(x+1)+":");
			Question.choice[x] = in.nextLine();
		}
	}
	
	public void ans() {
		System.out.print("What could be the answer:");
		Question.answer = sc.nextInt();
	}
	
	public static void main(String[] args) {
		Question obj = new Question();
		
		
		System.out.print("Enter the number of questions to insert:");
		obj.recurse(sc.nextInt());
	}

}
