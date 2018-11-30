package student.evaluation.StudentEvaluation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

	@RequestMapping(value="/404.html",method=RequestMethod.GET)
	public String errorMapping()
	{
		return "redirect:/";
	}
}
