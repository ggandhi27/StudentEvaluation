package student.evaluation.StudentEvaluation;
import entity.Questions;
import java.util.*;

public class ExamService {
	public int checkAnswer(HashMap<Integer,String> examresult) {
		int res=0;
		ArrayList<Questions> arraylist=new ArrayList<Questions>();
		Question ques=new Question();
		arraylist=ques.fetchQuestion();
		Iterator<Questions> iterator = arraylist.iterator();
		while(iterator.hasNext()) {
			Questions question = iterator.next();
			if(examresult.containsValue(question.getAnswer())) {
				res++;
			}
		}
		return res;
	}
}
