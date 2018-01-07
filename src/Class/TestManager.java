package Class;

import java.util.ArrayList;
import java.util.Scanner;

import User.Main;

public class TestManager {
	private ArrayList<AbstractExam> tests = new ArrayList<AbstractExam>();
	private ArrayList<Double> wieght = new ArrayList<Double>();
	
	private Scanner scanner = new Scanner(System.in);
	
	public TestManager() {
		AbstractExamApp app = new ExamApp();
		this.tests.add(app.createTest("Mid-Term"));
		this.wieght.add(0.5);
		this.tests.add(app.createTest("Final"));
		this.wieght.add(0.5);
	}

	public void addGrade(String name) {
		AbstractExamApp app = new QuizApp();
		this.tests.add(app.createTest(name));
		this.wieght.add(0.0);
	}
	
	public boolean deleteGrade() {
		System.out.println("Which Quiz do you want to delete");
		
		for(int i = 2; i < tests.size(); i++) {
			System.out.println(i-1 + ":" + tests.get(i).name);
		}
		System.out.println("Choice:");
		Integer choice = Integer.valueOf(scanner.nextLine());
		if (choice > 0 && choice < tests.size()) {
			this.tests.remove(choice+1);
			return true;
		}
		return false;
	}
	
	public boolean setGrade(ArrayList<Integer> students) {
		int index = 1;		
		for(AbstractExam app : tests) {
			System.out.println(index + ":" + app.name);
			index++;
		}
		System.out.println("Which Test do you want to set grades: ");
		int choice = Integer.valueOf(scanner.nextLine());
		if (choice > 0 && choice < tests.size()) {
			System.out.println("Enter the scores of the every student");
			ArrayList<Integer> scoreOfStudent = new ArrayList<Integer>();
			for(Integer student: students) {
				System.out.print(Main.getUserName(student) + ": ");
				int tmpScore = Integer.valueOf(scanner.nextLine());
				scoreOfStudent.add(tmpScore);
			}
			this.tests.get(choice-1).setGrade(scoreOfStudent);
			return true;
		}
		return false;
	}
	
	public boolean setWeight() {
		int index = 1;		
		double sum = 0;
		for(AbstractExam app : tests) {
			System.out.println(index + ":" + app.name);
			index++;
		}
		System.out.println("sum of weight must be 1");
		System.out.println("Please Enter each test weight: ");
		ArrayList<Double> w = new ArrayList<Double>();
		for(AbstractExam app : tests)
			System.out.println(index++ + ": " + app.name);
		for(AbstractExam app : tests) {
			System.out.println(app.name + ": ");
			w.add(Double.valueOf(scanner.nextLine()));
		}
		for(Double d: w)	sum += d;
		if(sum == 1.0) {
			this.wieght = w;
			return true;
		}
		return false;
	}
	
	public boolean getGrade(ArrayList<Integer> students) {
		int index = 1;		
		for(AbstractExam app : tests) {
			System.out.println(index++ + ":" + app.name);
		}
		System.out.println("Which Test do you want to see: ");
		int choice = Integer.valueOf(scanner.nextLine());
		if (choice > 0 && choice < tests.size()) {
			System.out.println("Enter the scores of the every student");
			int i = 0;
			for(Integer student: students) {
				System.out.println(Main.getUserName(student) + ": " + tests.get(choice).scores.get(i++));
			}
			return true;
		}
		return false;
	}

	public void getGrade(ArrayList<Integer> students, Integer userId) {
		for(AbstractExam test: tests) {
			for(Integer student: students) {
				if(student == userId)
					System.out.println(test.name + ": " + test.scores.get(student));
			}
		}
	}
}
