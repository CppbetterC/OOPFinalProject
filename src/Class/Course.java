package Class;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import User.Main;
import User.User;

public class Course {
	private static Integer count = 1001;
	private Integer number;
	private String name;
	private Integer teacher;
	private ArrayList<Integer> student;
	private TestManager test;
	Scanner scanner = new Scanner(System.in);
	
	public Course(String name){
		this.number = count;
		this.name = name;
		test = new FengChiaUniversity();
		count++;
	}
	public Course(Integer number, String name, Integer teacher, ArrayList<Integer> student){
		this.number = number;
		this.name = name;
		this.teacher = teacher;
		this.student = student;
		test = new FengChiaUniversity();
		count = this.number + 1;
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
	
	@Override
	public String toString() {
		return "Class: " + String.valueOf(this.number) + " " + this.name + "\nTeacher: " + Main.getUserName(this.teacher);
	}	
	
	public void addGrade(String name) {
		test.addGrade(name);
	}
	
	public boolean deleteGrade() {
		return test.deleteGrade();
	}
	
	public boolean setGrade() {
		return test.setGrade(this.student);
	}
	
	public boolean setWeight() {
		return test.setWeight();
	}
	
	public boolean getGrade() {
		return test.getGrade(this.student);
	}

	public void getGrade(Integer userId) {
		test.getGrade(this.student, userId);
	}
	public TestManager getTestManager() {
		return test;
	}
}
