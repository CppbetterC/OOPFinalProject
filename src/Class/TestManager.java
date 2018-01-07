package Class;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import User.Main;

public abstract class TestManager {
	protected ArrayList<AbstractExam> tests = new ArrayList<AbstractExam>();
	protected Scanner scanner = new Scanner(System.in);

	public abstract void addGrade(String name, Integer studentCount);
	
	public abstract boolean deleteGrade();
	
	public abstract boolean getGrade(ArrayList<Integer> students);

	public abstract void getGrade(ArrayList<Integer> students, Integer userId);
	
	public abstract boolean setGrade(ArrayList<Integer> students);
	
	public abstract boolean setWeight();
	
	public void addStudent() {
		for(AbstractExam test: tests) {
			test.scores.add(0);
		}
	}
	
	public void deleteStudent(int index) {
		for(AbstractExam test: tests) {
			test.scores.remove(index);
		}
	}
	
	public String getName(int index) {
		return tests.get(index).name;
	}

	public Integer getGrade(int index,int studentId, ArrayList<Integer> students) {
		Integer score = 0;
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i) == studentId){
				score = tests.get(index).scores.get(i);
				break;
			}
		}
		return score;
	}
	
	public Integer gettestlen() {
		return tests.size();
	}
	
	public boolean setGrade(ArrayList<Integer> students, 
			ArrayList<Integer> MinScore, ArrayList<Integer> FinScore) {
		if (students.size()>0) {
			this.tests.get(0).setGrade(MinScore);
			this.tests.get(1).setGrade(FinScore);
			System.out.print("Data has been loaded complete");
			return true;
		}
		System.out.println("Data has not been loaded complete");
		return false;
	}
}
