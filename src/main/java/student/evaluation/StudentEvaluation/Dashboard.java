package student.evaluation.StudentEvaluation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Dashboard {
	
	@RequestMapping(value="/dash")
	public String Dash() {
		return "dashboard.html";
	}
}
