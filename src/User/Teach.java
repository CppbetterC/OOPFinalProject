package User;

import java.util.Scanner;

import Class.CourseList;

public class Teach {
	Scanner scanner = new Scanner(System.in);
	public Teach(Integer userId, Integer courseNumber){
		while(true) {
			System.out.println(CourseList.getCourse(courseNumber));
			System.out.println("1. Display tests\n2. Add Tests\n3. Delete Tests\n4. Rejister grades\n5. Back");
			switch(scanner.nextInt()) {
				case 1:
					System.out.flush();
					CourseList.getGrade(courseNumber);
					break;
				case 2:
					System.out.flush();
					CourseList.addGrade(courseNumber);
					break;
				case 3:
					System.out.flush();
					CourseList.deleteGrade(courseNumber);
					break;
				case 4:
					System.out.flush();
					CourseList.setGrade(courseNumber);
					break;
				case 5:
					return;
			}
		}
	}
}
