package student.evaluation.StudentEvaluation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Dashboard {
	
	@RequestMapping(value="/dash",method=RequestMethod.GET)
	public ModelAndView Dash() {
		ModelAndView model=new ModelAndView("dashboard.html");
		model.addObject("username", "Ankit Pathak");
		return model;
	}
}
