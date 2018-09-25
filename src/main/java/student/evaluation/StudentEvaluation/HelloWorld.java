package student.evaluation.StudentEvaluation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {

	@RequestMapping(value="/")
	public String hello() {
		return "Hello Bruh";
	}
}
