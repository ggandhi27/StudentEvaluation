package student.evaluation.StudentEvaluation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {
	
	@RequestMapping(value="/")
	public String login() {
		
		return "login.html";
		
	}
	
	@RequestMapping(value="/error")
	public String error()
	{
		return "Error.html";
	}

}
