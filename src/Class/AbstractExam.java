package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractExam {
	protected Map<String, String> studentScore = new HashMap<String, String>();
	
	abstract Map<String, String> getStudentScore();
	abstract void setScore(ArrayList<Integer> student, ArrayList<Integer> scores);
}
