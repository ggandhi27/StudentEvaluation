package student.evaluation.StudentEvaluation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Controller
@SessionAttributes("user")
public class Dashboard {
	
	@RequestMapping(value="/dash",method=RequestMethod.GET)
	public ModelAndView Dash() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        
		ModelAndView model=new ModelAndView("dashboard");
		return model;
	}
}