package User;

import java.util.Scanner;

import Class.CourseList;

public class Teach {
	Scanner scanner = new Scanner(System.in);
	public Teach(Integer userId, Integer courseNumber){
		while(true) {
			System.out.println(CourseList.getCourse(courseNumber));
			System.out.println("1. Display Quizes and Exams\n2. Add Exam\n3. Add Quiz");
			switch(scanner.nextInt()) {
				case 1:
					//c.getGrades();
					break;
				case 2:
					System.out.println("Are you sure to drop this class?(Y/N) ");
					if(scanner.nextLine().equals("Y") || scanner.nextLine().equals("y"))
						CourseList.deleteStudent(courseNumber, userId);
					System.out.println("You have droped " + CourseList.getName(courseNumber));
					break;
				case 3:
					return;
			}
		}
	}
}
