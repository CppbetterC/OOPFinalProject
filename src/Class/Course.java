package Class;

import java.util.ArrayList;

public class Course {
	private Integer number;
	private String name;
	private String teacher;
	private ArrayList<String> student;
	private showFormat showFormat;
	
	public Course(Integer number, String name){
		this.number = number;
		this.name = name;
//		default showFormat is GradesMaxToMin
		this.showFormat = new GradesMaxToMin();
	}
	public Course(Integer number, String name, String teacher, ArrayList<String> student){
		this.number = number;
		this.name = name;
		this.teacher = teacher;
		this.student = student;
//		default showFormat is GradesMaxToMin
		this.showFormat = new GradesMaxToMin();
	}
	
	public Integer getNumber() {
		return this.number;
	}
	
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public ArrayList<String> getStudents() {
		return student;
	}
	public boolean addStudent(String student) {
		for(String s: this.student)
			if(s.equals(student))	return false;
		this.student.add(student);
		return true;
	}
	
	public boolean deleteStudent(String student) {
		for(String s: this.student)
			if(s.equals(student)) {
				this.student.remove(s);
				return true;
			}
		return false;
	}
	
	public String getName() {
		return name;
	}
	
	public void listGradeReport() {
//		implement the showFormat
//		using the design pattern(strategy)
	}
	
}
