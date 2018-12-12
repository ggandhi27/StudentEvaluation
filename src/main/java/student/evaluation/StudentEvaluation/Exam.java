package student.evaluation.StudentEvaluation;
import student.evaluation.StudentEvaluation.Question;
import entity.Questions;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        ArrayList<Questions> arraylist = new ArrayList<Questions>();
    	Question ques = new Question();
    	arraylist=ques.fetchQuestion();
		ModelAndView model=new ModelAndView("C_exam");
		model.addObject("questions",arraylist);
		return model;
	}
	
	@RequestMapping(value="/J_exam",method=RequestMethod.GET)
	public ModelAndView J_exam() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        ArrayList<Questions> arraylist = new ArrayList<Questions>();
    	Question ques = new Question();
    	arraylist=ques.fetchQuestion();
		ModelAndView model=new ModelAndView("J_exam");
		model.addObject("questions",arraylist);
		return model;
	}
	@PostMapping(value="/result")
	public ModelAndView Result(@ModelAttribute(value="examresult") HashMap<Integer,String> examresult ) {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        
		ModelAndView model=new ModelAndView("result");
		return model;
	}
}