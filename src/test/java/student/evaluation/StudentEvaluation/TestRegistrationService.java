package student.evaluation.StudentEvaluation;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import entity.User;

public class TestRegistrationService {
	
	@Autowired
	private RegisterService registerService;
	
	private String getQuestion() {
		
		String questions[] = {"What is your first school name?",
				"Which city you were born in?",
				"What is the first name of your best friend?"};
		
		Random rand = new Random();
		int index = rand.nextInt((2-0)+1) + 0;
		
		return questions[index];
	}
	
	private String getName() {
		
		Random rand  = new Random();
		int length = rand.nextInt((15 - 6) + 1) + 6;
		int j;
		String username = "";
		for(j=0;j<length;j++) {
				username = username + (char)(rand.nextInt((122 - 97) + 1) + 97);
		}
		return username;

	}
	
	private String getPassword() {
		
		Random rand  = new Random();
		int length = rand.nextInt((15 - 8) + 1) + 8;
		int j;
		String password = "";
		for(j=0;j<length;j++) {
				password = password + (char)(rand.nextInt((122 - 48) + 1) + 48);
		}
		return password;

	}
	
	private String getEmail() {
		int len1,len2,i,j;
		String email;
		email = "";
		Random rand = new Random();
		len1 = rand.nextInt((15-8)+1)+8;
		len2 = rand.nextInt(10-7+1)+7;
		
		for(i=0;i<len1;i++) {
			email = email + (char)(rand.nextInt((122 - 97) + 1) + 97);
		}
		email = email+"@";
		for(i=0;i<len1;i++) {
			email = email + (char)(rand.nextInt((122 - 97) + 1) + 97);
		}
		email = email+".com";
	
		
		return email;
	}
	@Before
	public void createTestCases(){
		
		HashMap<String, Boolean> userMap= new HashMap<>();
		int i;
		String uname,fname,lname,pass,ques,ans,email;
		String str;
		try{
			FileWriter file = new FileWriter("/tmp/TestFile.csv");
			BufferedWriter bufferedWriter =
	                new BufferedWriter(file);
			

			for(i=0;i<200;i++) {
				str = "";
				while(true) {
					uname = this.getName();
					if(userMap.containsKey(uname)) {
						continue;
					}
					else {
						userMap.put(uname, true);
						break;
					}
				}
				fname = this.getName();
				lname = this.getName();
				pass = this.getPassword();
				ans = this.getName();
				ques = this.getQuestion();
				email = this.getEmail();
				str = uname+','+fname+','+lname+','+pass+','+ans+','+ques+','+email+','+"true";
				bufferedWriter.write(str);
				bufferedWriter.newLine();
				str = uname+','+fname+','+lname+','+pass+','+ans+','+ques+','+email+','+"false";
				bufferedWriter.write(str);
				bufferedWriter.newLine();
				
			}
			bufferedWriter.close();
		}
		catch (IOException  e) {
			fail("Cannot create the csv file.");
		}
		
	}

	@Test
	public void test() {
		
		try {
			
			BufferedReader p = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/TestFile.csv")));
			String str;
			while((str=p.readLine())!=null) {
				String strArr[] = str.split(",");
				User user = new User();
				user.setUname(strArr[0]);
				user.setFname(strArr[1]);
				user.setLname(strArr[2]);
				user.setPassword(strArr[3]);
				user.setAnswer(strArr[4]);
				user.setQuestion(strArr[5]);
				user.setEmail(strArr[6]);
				
				Boolean flag = registerService.register(user);
				assertEquals(Boolean.parseBoolean(strArr[7]),flag);
				
			}
		}
		catch(IOException e) {
			fail("Exception occured while testing");
		}
	}

}
