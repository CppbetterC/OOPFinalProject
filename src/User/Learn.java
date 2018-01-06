package User;

import java.util.ArrayList;
import java.util.Scanner;

import Class.Course;
import Class.CourseList;

public class Learn {
	private ArrayList<Course> course;
	Scanner scanner = new Scanner(System.in);
	public Learn(Integer userId, Integer courseNumber){
		course  = CourseList.getCourse(userId);
		for(Course c: course) {
			if(courseNumber == c.getNumber()) {
				System.out.println("Class Name: " + c.getNumber() + c.getName());
				System.out.println("Teacher: " + Main.getUserName(c.getTeacher()));
				System.out.println("1. Display grades\n2. Drop this Class\n3. Back");
				switch(scanner.nextInt()) {
					case 1:
						//c.getGrades();
						break;
					case 2:
						System.out.println("Are you sure to drop this class?(Y/N) ");
						if(scanner.nextLine() == "Y" || scanner.nextLine() == "y")
							c.deleteStudent(userId);
						break;
					case 3:
						return;
				}
			}
		}
	}
}
