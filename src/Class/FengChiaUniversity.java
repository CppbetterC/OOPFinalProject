package Class;

import java.util.ArrayList;

import User.Main;

public class FengChiaUniversity extends TestManager {
	protected ArrayList<Double> wieght = new ArrayList<Double>();

	public FengChiaUniversity(Integer studentCount) {
		super();
		AbstractExamApp app = new ExamApp();
		this.tests.add(app.createTest("Mid-Term", studentCount));
		this.wieght.add(0.5);
		this.tests.add(app.createTest("Final", studentCount));
		this.wieght.add(0.5);
	}
	
	public void addGrade(String name, Integer studentCount) {
		AbstractExamApp app = new QuizApp();
		this.tests.add(app.createTest(name, studentCount));
		this.wieght.add(0.0);
	}
	
	public boolean deleteGrade() {
		System.out.println("Which Quiz do you want to delete");
		
		for(int i = 0; i < tests.size(); i++) {
			if(Exam.class.isInstance(tests.get(i)))	continue;
			System.out.println(i + ":" + tests.get(i).name);
		}
		System.out.println("Choice:");
		int choice = Integer.valueOf(scanner.nextLine());
		if(choice < 0 || choice > tests.size())	return false;
		if (Quiz.class.isInstance(tests.get(choice))) {
			this.tests.remove(choice);
			this.wieght.remove(choice);
			return true;
		}
		return false;
	}
	
	public boolean setGrade(ArrayList<Integer> students) {
		int index = 0;
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
			this.tests.get(choice).setGrade(scoreOfStudent);
			return true;
		}
		return false;
	}

	public boolean getGrade(ArrayList<Integer> students) {
		int index = 0;		
		for(AbstractExam app : tests) {
			System.out.println(index++ + ":" + app.name);
		}
		System.out.println("Which Test do you want to see: ");
		int choice = Integer.valueOf(scanner.nextLine());
		if (choice > -1 && choice < tests.size()) {
			int i = 0;
			for(Integer student: students) {
				System.out.println(Main.getUserName(student) + ": " + tests.get(choice).scores.get(i++));
			}
			return true;
		}
		return false;
	}

	public void getGrade(ArrayList<Integer> students, Integer userId) {
		Double sum = 0.0;
		for(AbstractExam test: tests) {
			for(int i = 0; i < students.size(); i++) {
				if(students.get(i).equals(userId)){
					System.out.println(test.name + ": " + test.scores.get(i));
					sum += test.scores.get(i) * wieght.get(i);
				}
			}
		}
		System.out.println("Total Grade: " + sum);
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
}
