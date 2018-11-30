package student.evaluation.StudentEvaluation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Controller
public class PTests {
	
	@RequestMapping(value="/ptests",method=RequestMethod.GET)
	public ModelAndView User() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        
		ModelAndView model=new ModelAndView("ptests");
		model.addObject("username", "Ankit Pathak");
		return model;
	}
}