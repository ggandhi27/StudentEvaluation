package student.evaluation.StudentEvaluation;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import entity.User;

@Controller
@SessionAttributes("user")
public class Login {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value="/")
	public String login() {
		
		return "login";
		
	}
	
	@RequestMapping(value="/Login")
	public ModelAndView checkLogin(@RequestParam(name="username")String username,
			@RequestParam(name="password")String password) {
		
        
		File file = new File("/tmp/"+username+".xml");		
        
		if (!file.exists()) {
       	 return null;
       	}
		else {
			if(loginService.checkPassword(username,password)) {
				ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
				templateResolver.setPrefix("/templates/");
		        templateResolver.setSuffix(".html");
		        
				ModelAndView model=new ModelAndView("dashboard");
				
				User user  = loginService.getUserObject(username);
				model.addObject("user", user);
				return model;
			}
			else {
				return null;
			}
		}
	}
}
