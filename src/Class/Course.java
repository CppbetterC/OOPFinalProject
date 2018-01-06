package Class;

import java.util.ArrayList;

public class Course {
	private String courseName;
	private float finalScore;
	private showFormat showFormat;
	private String teacher;
	private ArrayList<String> student;
	
	public Course(String className, String teacher, ArrayList<String> student){
		this.courseName = courseName;
		this.teacher = teacher;
		this.student = student;
		this.finalScore = -1;
//		default showFormat is GradesMaxToMin
		this.showFormat = new GradesMaxToMin();
	}
	
	public Course(String className){
		super();
		this.courseName = courseName;
//		this.teacher = null;
//		this.student = null;
//		this.finalScore = -1;
//		this.showFormat = new GradesMaxToMin();
	}
	
//	public String getclassName() {
//		return className;
//	}
//	public void setclassName(String className) {
//		this.className = className;
//	}
	
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
	
	public void setclassName(String courseName) {
		this.courseName = courseName;
	}
	
	public float getFinalScore() {
		return finalScore;
	}
	
	public void setFinalScore(float finalScore) {
		this.finalScore = finalScore;
//		setChanged();
//		notifyObserverGetFinalScore("FinalScore had been changed", new Float(finalScore));
	}
	
	public void listGradeReport() {
//		implement the showFormat
//		using the design pattern(strategy)
	}
	
}
