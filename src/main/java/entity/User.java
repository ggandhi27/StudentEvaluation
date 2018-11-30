package entity;

import java.util.ArrayList;
import org.w3c.dom.Node;

public class User {
	
	private ArrayList<Tests> testList;
	private String uname;
	private String fname;
	private String lname;
	private String password;
	private String question;
	private String answer;
	private String mobile;
	private String email;
	private int counter;
	
	//For use in updation code of profile
	private Node fiName;
	private Node laName;
	private Node mNumber;
	private Node pass;
	
	
	public void setFiName(Node fiName) {
		this.fiName = fiName;
		this.fiName.setTextContent(this.fname);
	}
	
	public void setLaName(Node laName) {
		this.laName = laName;
		this.laName.setTextContent(this.lname);
	}
	
	public void setmNumber(Node mNumber) {
		this.mNumber = mNumber;
		this.mNumber.setTextContent(this.mobile);
	}
	
	public void setPass(Node pass) {
		this.pass = pass;
		this.pass.setTextContent(this.password);
	}

	//for use in updation code of profile end
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}

	public User() {
		this.setUname("rajendar");
		this.setFname("asf");
		this.setLname("aszxvf");
		this.setPassword("12412 ");
		this.setQuestion("favourite animal?");
		this.setAnswer("cat");
		this.setMobile("98492316");
		this.setEmail("dasf@gmail.com");
		this.setCounter(0);
	}
	
	
	
}
