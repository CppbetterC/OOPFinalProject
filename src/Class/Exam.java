package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Exam extends AbstractExam{
	private Map<String, String> studentScore = new HashMap<String, String>();
	
	public Map<String, String> getStudentScore() {
		return studentScore;
	}

	public void setScore(ArrayList<Integer> student, ArrayList<Integer> scores){
		 System.out.println("This is Exam...");
		 for(int i = 0; i < student.size(); i++) {
			 this.studentScore.put(student.get(i).toString(), scores.get(i).toString());
		 }
	}

}
