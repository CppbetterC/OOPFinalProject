package Class;

import java.util.ArrayList;

import User.Main;

public class TOEIC extends TestManager {
	public TOEIC() {
		super();
		AbstractExamApp app = new ExamApp();
		this.tests.add(app.createTest("Total Grade"));
	}

	@Override
	public void addGrade(String name) {}

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
		Double sum = 0.0;
		for(AbstractExam test: tests) {
			for(int i = 0; i < students.size(); i++) {
				if(students.get(i) == userId){
					System.out.println(test.name + ": " + test.scores.get(i));
					sum += test.scores.get(i);
				}
			}
			System.out.println("Total Grade: " + sum);
		}
	}
}
