package student.evaluation.StudentEvaluation;
import entity.Questions;
import java.util.*;

public class ExamService {
	public int checkAnswer(HashMap<Integer,String> examresult) {
		int res=0;
		ArrayList<Questions> arraylist=new ArrayList<Questions>();
		Question ques=new Question();
		arraylist=ques.fetchQuestion();
		while(ques!=null) {
			
		}
		return res;
	}
}
