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

import entity.User;

@Controller
@SessionAttributes("username")
public class Login {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value="/")
	public String login() {
		
		return "login.html";
		
	}
	
	@RequestMapping(value="/Login",method=RequestMethod.POST)
	public String checkLogin(@RequestParam(name="username")String username,
			@RequestParam(name="password")String password, ModelMap model) {
		
        
		File file = new File("/tmp/"+username+".xml");		
        
		if (!file.exists()) {
       	 return("User does not exists");
       	}
		else {
			if(loginService.checkPassword(username,password)) {
				User user = loginService.getUserObject(username);
				model.put("username",username);
				return "dashboard.jsp";
			}
			else {
				return "Either username or password is incorrect.";
			}
		}
	}
}
