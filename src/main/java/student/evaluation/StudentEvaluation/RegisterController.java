package student.evaluation.StudentEvaluation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegisterController {

	@RequestMapping(value="/register", method = RequestMethod.POST)
	@ResponseBody
	public String register(@RequestParam(value="fname") String fname,
			@RequestParam(value="lname") String lname,
			@RequestParam(value="username") String username,
			@RequestParam(value="email") String email,
			@RequestParam(value="password")String password,
			@RequestParam(value="question")String question,
			@RequestParam(value="answer")String answer) {
		
		
		return "registration done";
	}
	
}
