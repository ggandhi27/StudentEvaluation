package entity;

import java.util.ArrayList;

public class User {
	
	private ArrayList<Tests> testList;
	private String fname;
	private String lname;
	private String uname;
	private String password;
	private String question;
	private String answer;
	private String mobile;
	private String email;
	private int counter;
	
	
	
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
		this.setPassword("ranger");
		this.setQuestion("favourite animal?");
		this.setAnswer("cat");
		this.setMobile("9892316");
		this.setEmail("dasf@gmail.com");
		this.setCounter(0);
	}
	public ArrayList<Tests> getTestList() {
		return testList;
	}
	public void setTestList(ArrayList<Tests> testList) {
		this.testList = testList;
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
	
	
	
}