package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quiz extends AbstractExam {
	private Map<String, String> studentScore = new HashMap<String, String>();
	
	public Map<String, String> getStudentMidScore() {
		return studentScore;
	}

	public void setScore(ArrayList<Integer> student, ArrayList<Integer> scores){
		 System.out.println("This is Quiz...");
		 for(int i = 0; i < student.size(); i++) {
			 this.studentScore.put(student.get(i).toString(), scores.get(i).toString());
		 }
	}
}
