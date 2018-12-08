package student.evaluation.StudentEvaluation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Controller
public class HelloWorld {

	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public ModelAndView hello() {
		ServletContextTemplateResolver templateResolver = 
	            new ServletContextTemplateResolver();

		templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
		ModelAndView model  = new ModelAndView("test");
		
		model.addObject("welcome", "hello");
		return model;
	}
}
