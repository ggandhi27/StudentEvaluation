package student.evaluation.StudentEvaluation;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import entity.Tests;
import entity.User;

@Service
public class LoginService {

	private Document getDocument(String username) {
		
		try {
	         File inputFile = new File("/tmp/"+username+".xml");
//	         File inputFile = new File("e:\\New folder\\"+username+".xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         return doc;
		}
		catch(Exception e) {
			return null;
		}
		
	}
	
	public boolean checkPassword(String username,String password) {
		

        File inputFile = new File("/tmp/"+username+".xml");
//        File inputFile = new File("e:\\New folder\\"+username+".xml");
        Document doc = this.getDocument(username);
		
        if(doc==(null)) {
        	return false;
        }
		String pass;
		NodeList nList = doc.getElementsByTagName("users");
		Node node = nList.item(0);
		Element element  = (Element)node;
		
		pass=element.getElementsByTagName("password").item(0).getTextContent();

		if(pass.equals(password))
		{
			return true;
		}
		else {
			return false;		
		}
	}

	public User getUserObject(String username) {
		User user = new User();
		Document doc = getDocument(username);
		NodeList nList = doc.getElementsByTagName("users");
		Node node = nList.item(0);
		Element element  = (Element)node;
		ArrayList<Tests> testList = new ArrayList<Tests>();
		

		user.setUname(element.getElementsByTagName("uname").item(0).getTextContent());
		user.setPassword(element.getElementsByTagName("password").item(0).getTextContent());
		user.setFname(element.getElementsByTagName("fname").item(0).getTextContent());
		user.setLname(element.getElementsByTagName("lname").item(0).getTextContent());
		user.setQuestion(element.getElementsByTagName("question").item(0).getTextContent());
		user.setAnswer(element.getElementsByTagName("answer").item(0).getTextContent());
		user.setEmail(element.getElementsByTagName("email").item(0).getTextContent());
		
		for(int i = 0; i<Integer.parseInt(element.getElementsByTagName("counter").item(0).getTextContent()); i++) {
			Tests test  = new Tests();
			test.setName(element.getElementsByTagName("name").item(i).getTextContent());
			test.setMarks(Integer.parseInt(element.getElementsByTagName("marks").item(i).getTextContent()));
			test.setTime(Integer.parseInt(element.getElementsByTagName("time").item(i).getTextContent()));
			testList.add(test);
		}
		
		user.setTestList(testList);
		return user ;
	}
}
