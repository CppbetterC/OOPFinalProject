package Class;

import java.util.ArrayList;

import User.Main;

public class TOEIC extends TestManager {
	public TOEIC(Integer studentCount) {
		super();
		AbstractExamApp app = new ExamApp();
		this.tests.add(app.createTest("Total Grade", studentCount));
	}

	
	public TOEIC(Integer studentCount, ArrayList<String[]> data) {
		super();
		ArrayList<String> scoretest;
		ArrayList<Integer> scoretest2;
	
		for(int j = 0 ; j < data.get(0).length; j++) {
			scoretest = new ArrayList<String>();
			scoretest2 = new ArrayList<Integer>();
			
			if(j == 0) {
				continue;
			}
			
			for(int i = 0; i < data.size(); i++) {
				scoretest.add(data.get(i)[j]);
			}
			if (j == 1 || j == 2) {
				AbstractExamApp app = new ExamApp();
				this.tests.add(app.createTest(scoretest.get(0), studentCount));
			}
			else {
				AbstractExamApp app = new QuizApp();
				this.tests.add(app.createTest(scoretest.get(0), studentCount));
			}
			scoretest.remove(0);
			for(int k = 0; k < scoretest.size(); k++) {
				scoretest2.add(Integer.parseInt((scoretest.get(k))));
			}
			this.tests.get(j-1).setGrade(scoretest2);
		}
	}
	
	@Override
	public void addGrade(String name, Integer studentCount) {}

	@Override
	public boolean deleteGrade() {
		return false;
	}

	@Override
	public boolean setGrade(ArrayList<Integer> students) {
		System.out.println("Enter the scores of the every student");
		ArrayList<Integer> scoreOfStudent = new ArrayList<Integer>();
		for(Integer student: students) {
			System.out.print(Main.getUserName(student) + ": ");
			int tmpScore = Integer.valueOf(scanner.nextLine());
			scoreOfStudent.add(tmpScore);
		}
		this.tests.get(0).setGrade(scoreOfStudent);
		return true;
	}
	
	public boolean getGrade(ArrayList<Integer> students) {
		int index = 0;
		for(AbstractExam app : tests) {
			System.out.println(index++ + ":" + app.name);
		}
		System.out.println("Which Test do you want to see: ");
		int choice = Integer.valueOf(scanner.nextLine());
		if (choice >= 0 && choice < tests.size()) {
			System.out.println("Enter the scores of the every student");
			int i = 0;
			for(Integer student: students) {
				System.out.println(Main.getUserName(student) + ": " + tests.get(choice).scores.get(i++));
			}
			return true;
		}
		System.out.println(tests.size());
		return false;
	}

	public void getGrade(ArrayList<Integer> students, Integer userId) {
		Double sum = 0.0;
		for(AbstractExam test: tests) {
			for(int i = 0; i < students.size(); i++) {
				if(students.get(i).equals(userId)){
					System.out.println(test.name + ": " + test.scores.get(i));
					sum += test.scores.get(i);
				}
			}
		}
	}

	@Override
	public boolean setWeight() {
		return false;
	}
}
