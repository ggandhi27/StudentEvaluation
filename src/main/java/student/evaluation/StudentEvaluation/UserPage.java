package student.evaluation.StudentEvaluation;

import javax.servlet.http.HttpServletRequest;
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
public class UserPage {
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public ModelAndView User(HttpServletRequest request,HttpSession session) {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        
        entity.User user = (entity.User)session.getAttribute("user");
    	ModelAndView model;
        if(user==null) {
        	model = new ModelAndView("login");
        }
        else {
        	model=new ModelAndView("user");
        }
		return model;
	}
}