package student.evaluation.StudentEvaluation;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import entity.User;

@Controller
public class Login {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value="/")
	public String login() {
		
		return "login.html";
		
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
				User user = loginService.getUserObject(username);
				return user.getEmail();
			}
			else {
				return "Either username or password is incorrect.";
			}
		}
	}
}
