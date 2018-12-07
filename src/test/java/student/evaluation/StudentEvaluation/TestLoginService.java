package student.evaluation.StudentEvaluation;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestLoginService {

	@Test
	public void test() {
		
		//Step 1: Read TestFile.csv to fetch the username and password.
		
		try{
			BufferedReader p = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/TestFile.csv")));
			
			String str;
			
			while((str=p.readLine())!=null) {
				
			}
			
			
		}
		catch(Exception e) {
			fail(e.toString());
		}
		
		//Step 2: Pass the username and correct password to the checkpassword() method.
		//Step 3: Assert the result.
		//Step 4: Pass the username and incorrect password to the checkpassword() method.
		//Step 5: Assert the result.
		//Step 6: Create some random usernames and passwords to the checkpassword() method.
		//Step 7: Assert the result.
	}

}
