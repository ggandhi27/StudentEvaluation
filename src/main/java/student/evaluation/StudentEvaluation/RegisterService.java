package student.evaluation.StudentEvaluation;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import entity.User;

@Service
public class RegisterService {
	
	public String register(User user) {
		
		try {
	         DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.newDocument();
	         
	         // root element
	         Element rootElement = doc.createElement("users");

	         doc.appendChild(rootElement);

	         

	         //username element
	         Element uname = doc.createElement("uname");
	         rootElement.appendChild(uname);
	         uname.appendChild(doc.createTextNode(user.getUname()));

	         // password element
	         Element password = doc.createElement("password");
	         rootElement.appendChild(password);
	         password.appendChild(doc.createTextNode(user.getPassword()));			

	         

	         // security element
	         Element question = doc.createElement("question");
	         rootElement.appendChild(question);
	         question.appendChild(doc.createTextNode(user.getQuestion()));

	         

	         //securityAnswer element
	         Element answer = doc.createElement("answer");
	         rootElement.appendChild(answer);
	         answer.appendChild(doc.createTextNode(user.getAnswer()));

	         

	         //mobile element
	         Element mobile = doc.createElement("mobile");
	         rootElement.appendChild(mobile);
	         mobile.appendChild(doc.createTextNode(user.getMobile()));

	         

	         //email element
	         Element email = doc.createElement("email");
	         rootElement.appendChild(email);
	         email.appendChild(doc.createTextNode(user.getEmail()));


	         //tests child-parent element

	         Element tests = doc.createElement("tests");
	         rootElement.appendChild(tests);

	         

	         //counter child element of tests
	         Element counter = doc.createElement("counter");
	         tests.appendChild(counter);
	         counter.appendChild(doc.createTextNode(Integer.toString(user.getCounter())));
	         
	         
//	         File files = new File("/UserDetails");
//	         
//	         if (!files.exists()) {
//	        	 System.out.println("Directory does not exists.");
//	        	 files.mkdir();
//	        	 System.out.println("Directory created.");
//	         }
//	         
	         // write the content into xml file
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result = new StreamResult(new File("/tmp/"+user.getUname()+".xml"));
	         System.out.println("File created");
	         transformer.transform(source, result);
	        
	         // Output to console for testing
	         StreamResult consoleResult = new StreamResult(System.out);
	         transformer.transform(source, consoleResult);
	         } 
			
			catch (Exception e) {

			return e.toString();
//	         return false;

	      }

	      
		
		return "Success";
		
	}

}
