package student.evaluation.StudentEvaluation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorld {


	@RequestMapping(value="/")
	public String hello() {
		return "index.html";
	}
	
	@RequestMapping(value="/Login")
	public String login() {
		
		return "login.html";
		
	}

}