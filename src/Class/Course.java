package Class;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import User.Main;
import User.User;

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
	
	public void getSingleGrade(Integer userId, Integer courseName) {
		ArrayList<String> id = new ArrayList<String>();
		Map<String, String> studentMidScore = new HashMap<String, String>();
		Map<String, String> studentFinScore =new HashMap<String, String>();
		FileReader fr;
		int count = 0;
		try {
			fr = new FileReader("src/" + courseName.toString() + ".txt");
			BufferedReader br = new BufferedReader(fr);
			try {
				while(br.ready()) {
					if(count != 0) {
						String Line = br.readLine();
						String[] split = Line.split(";");
						id.add(split[0]);
						studentMidScore.put(split[0], split[1]);
						studentFinScore.put(split[0], split[2]);
					}
					count++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int i = 1; i < id.size(); i++) {
			if ( userId == Integer.parseInt(id.get(i))){
				System.out.println("Searching successfully...");
				System.out.println("[UserId]\t\t[Mid]\t\t[Fin]");
				System.out.println("--------+--------------");
				System.out.print(userId + "\t|\t" 
				+ studentMidScore.get(id.get(i)) 
				+"\t|\t"
				+ studentFinScore.get(id.get(i)));
				break;
			}
		}
	}
	@Override
	public String toString() {
		return "Class: " + String.valueOf(this.number) + " " + this.name + "\nTeacher: " + Main.getUserName(this.teacher);
	}
}
