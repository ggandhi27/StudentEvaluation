package student.evaluation.StudentEvaluation;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Controller
@SessionAttributes("user")
public class PTests {
	
	@RequestMapping(value="/ptests",method=RequestMethod.GET)
	public ModelAndView User(HttpSession session) {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        
        entity.User user = (entity.User)session.getAttribute("user");
    	ModelAndView model;
        if(user==null) {
        	model = new ModelAndView("login");
        }
        else {
        	model=new ModelAndView("ptests");
        }
		
		return model;
	}
}