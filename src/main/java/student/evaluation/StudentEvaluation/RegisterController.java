package student.evaluation.StudentEvaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.User;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegisterController {

	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	@ResponseBody
	public String register(@RequestParam(value="fname") String fname,
			@RequestParam(value="lname") String lname,
			@RequestParam(value="username") String username,
			@RequestParam(value="email") String email,
			@RequestParam(value="password")String password,
			@RequestParam(value="question")String question,
			@RequestParam(value="answer")String answer) {
		
		User user = new User();
		
		user.setUname(username);
		user.setFname(fname);
		user.setLname(lname);
		user.setEmail(email);
		user.setPassword(password);
		user.setQuestion(question);
		user.setAnswer(answer);
		
		if(registerService.register(user))
		{
			return "registration done";
		}
		else {
			return "registration failed";
		}
	}
	
}
