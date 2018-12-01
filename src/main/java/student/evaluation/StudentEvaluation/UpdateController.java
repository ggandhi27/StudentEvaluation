package student.evaluation.StudentEvaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import entity.User;

@Controller
@SessionAttributes("user")
public class UpdateController {
	
	@Autowired
	UpdateService updateService;
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	@ResponseBody
	public String updateProfile(
			@ModelAttribute("user")User user,
			@RequestParam(name="fname")String fname,
			@RequestParam(name="lname")String lname,
			@RequestParam(name="opass")String opass,
			@RequestParam(name="npass")String npass) {
		
		
//		ModelAndView model =  new ModelAndView("user");
//		user.setFname(fname);
//		user.setLname(lname);
//		user.setPassword(npass);
//		updateService.updateUser(user);
//		model.addObject("user", user);
//		return model;
//		
		return user.getEmail();
		
	}
}
