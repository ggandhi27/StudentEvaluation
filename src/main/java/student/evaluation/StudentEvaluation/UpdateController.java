package student.evaluation.StudentEvaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import entity.User;

@Controller
@SessionAttributes("user")
public class UpdateController {
	
	@Autowired
	UpdateService updateService;
	
	@RequestMapping("/update")
	public ModelAndView updateProfile(
			@ModelAttribute("user")User user,
			@RequestParam(name="fname")String fname,
			@RequestParam(name="lname")String lname,
			@RequestParam(name="opass")String opass,
			@RequestParam(name="npass")String npass) {
		
		
		
		
		
		return null;
	}
}
