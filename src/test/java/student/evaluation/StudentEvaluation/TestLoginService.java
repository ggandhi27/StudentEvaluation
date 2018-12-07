package student.evaluation.StudentEvaluation;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Random;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestLoginService {

	private String generatePassword() {
		Random rand  = new Random();
		int length = rand.nextInt((15 - 8) + 1) + 8;
		int j;
		String password = "";
		for(j=0;j<length;j++) {
				password = password + (char)(rand.nextInt((122 - 48) + 1) + 48);
		}
		return password;
	}
	
	private String generateUsername() {
		Random rand  = new Random();
		int length = rand.nextInt((15 - 6) + 1) + 6;
		int j;
		String username = "";
		for(j=0;j<length;j++) {
				username = username + (char)(rand.nextInt((122 - 97) + 1) + 97);
		}
		return username;

	}
	@Test
	public void test() {
		
		//Step 1: Read TestFile.csv to fetch the username and password.
		
		try{
			BufferedReader p = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/TestFile.csv")));
			LoginService loginService = new LoginService();
			String str;
			String username,password;
			while((str=p.readLine())!=null) {
				
				String strArr[] = str.split(",");
				username = strArr[0];
				password = strArr[3];
				//Step 2: Pass the username and correct password to the checkpassword() method.
				Boolean flag = loginService.checkPassword(username, password);
				//Step 3: Assert the result.
				assertEquals("true",String.valueOf(flag));
				//Step 4: Pass the username and incorrect password to the checkpassword() method.
				password = this.generatePassword();
				flag = loginService.checkPassword(username, password);
				//Step 5: Assert the result.
				assertEquals("false",String.valueOf(flag));
				//Step 6: Create some random usernames and passwords to the checkpassword() method.
				username = this.generateUsername();
				flag = loginService.checkPassword(username, password);
				//Step 7: Assert the result.
				assertEquals("false",String.valueOf(flag));
			}
			
			
		}
		catch(Exception e) {
			fail(e.toString());
		}
		
	}

}
