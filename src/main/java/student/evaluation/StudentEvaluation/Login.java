package student.evaluation.StudentEvaluation;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import entity.User;

@Controller
public class Login {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value="/")
	public String login() {
		
		return "login";
		
	}
	
	@RequestMapping(value="/Login")
	@ResponseBody
	public String checkLogin(@RequestParam(name="username")String username,
			@RequestParam(name="password")String password) {
		
        
		File file = new File("/tmp/"+username+".xml");		
        
		if (!file.exists()) {
       	 return("User does not exists");
       	}
		else {
			if(loginService.checkPassword(username,password)) {
				return "Success";
			}
			else {
				return "Either username or password is incorrect.";
			}
		}
	}
}
