package Class;

import java.util.ArrayList;

public class Class extends ClassList{
	private String courseName;
	private float finalScore;
	private showFormat showFormat;
	private String className;
	private String teacher;
	private ArrayList<String> student;
	
	public Class(String courseName, float finalScore, showFormat s) {
		this.courseName = courseName;
		this.finalScore = finalScore;
		this.showFormat = s;
	}
	public Class(String className, String teacher, ArrayList<String> student){
		this.className = className;
		this.teacher = teacher;
		this.student = student;
	}
	public String getclassName() {
		return teacher;
	}
	public void setclassName(String className) {
		this.className = className;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public ArrayList<String> getStudent() {
		return student;
	}
	public void setStudent(ArrayList<String> student) {
		this.student = student;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public float getFinalScore() {
		return finalScore;
	}
	
	public void setFinalScore(float finalScore) {
		this.finalScore = finalScore;
//		setChanged();
		notifyObserverGetFinalScore("FinalScore had been changed", new Float(finalScore));
	}
	
	public void listGradeReport() {
//		implement the showFormat
//		using the design pattern(strategy)
	}
	
}
