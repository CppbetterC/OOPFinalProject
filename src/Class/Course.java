package Class;

import java.util.ArrayList;

public class Course {
	private Integer number;
	private String name;
	private Integer teacher;
	private ArrayList<Integer> student;
	private showFormat showFormat;
	
	public Course(Integer number, String name){
		this.number = number;
		this.name = name;
//		default showFormat is GradesMaxToMin
		this.showFormat = new GradesMaxToMin();
	}
	public Course(Integer number, String name, Integer teacher, ArrayList<Integer> student){
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
	
	public Integer getTeacher() {
		return teacher;
	}
	public void setTeacher(Integer teacher) {
		this.teacher = teacher;
	}
	public ArrayList<Integer> getStudents() {
		return student;
	}
	public boolean addStudent(Integer student) {
		for(Integer s: this.student)
			if(s == student)	return false;
		this.student.add(student);
		return true;
	}
	
	public boolean deleteStudent(Integer student) {
		for(Integer s: this.student)
			if(s == student) {
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
