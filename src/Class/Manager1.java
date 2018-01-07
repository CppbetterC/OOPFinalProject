package Class;

import java.util.ArrayList;

import User.Main;

public class Manager1 extends TestManager {
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
