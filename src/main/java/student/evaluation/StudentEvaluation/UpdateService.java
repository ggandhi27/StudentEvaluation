package student.evaluation.StudentEvaluation;

import entity.User;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

@Service
public class UpdateService {

	
	
	private static NodeList fnameList;
	private static NodeList lnameList;
	private static NodeList passwordList;

	public void updateName(User obj) {
		
		obj.setFiName(fnameList.item(0));
		obj.setLaName(lnameList.item(0));
	}
	
	public void updatePassword(User obj) {
		obj.setPass(passwordList.item(0));
	}
	
	public void updateUser(User obj) {
		try {
			
			String filepath = "/tmp/"+obj.getUname()+".xml";
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(filepath);
	        doc.getDocumentElement().normalize();
	        fnameList = doc.getElementsByTagName("fname");
	        lnameList = doc.getElementsByTagName("lname");
	        passwordList = doc.getElementsByTagName("password");
	        
	        updateName(obj);
	        updatePassword(obj);
	        
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
