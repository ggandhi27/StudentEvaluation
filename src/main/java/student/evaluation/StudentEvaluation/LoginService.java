package student.evaluation.StudentEvaluation;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import entity.User;

@Service
public class LoginService {

	private static Document getDocument(String username) {
		
		try {
	         File inputFile = new File("/tmp/"+username+".xml");
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
	
	public static boolean checkPassword(String username,String password) {
		
		Document doc = getDocument(username);
		
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
		
		
		
		return null;
	}
}
