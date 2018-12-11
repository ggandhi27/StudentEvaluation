package student.evaluation.StudentEvaluation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Controller
public class Exam {
	
	@RequestMapping(value="/C_exam",method=RequestMethod.GET)
	public ModelAndView C_exam() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
		ModelAndView model=new ModelAndView("C_exam");
		return model;
	}
	
	@RequestMapping(value="/J_exam",method=RequestMethod.GET)
	public ModelAndView J_exam() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        
		ModelAndView model=new ModelAndView("J_exam");
		return model;
	}
}