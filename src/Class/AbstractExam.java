package Class;

import java.util.ArrayList;

public abstract class AbstractExam {
	protected String name;
	protected ArrayList<Integer> scores = new ArrayList<Integer>();
	
	
	public AbstractExam(String name, Integer student) {
		this.name = name;
		for(int i = 0; i < student; i++)
			scores.add(0);
	}
	
	public void setGrade(ArrayList<Integer> scores) {
		this.scores = scores;
	}
	
	public Integer getGrade(Integer index) {
		return scores.get(index);
	}
}
