package User;

import java.util.ArrayList;
import java.util.Scanner;

import Class.Course;
import Class.CourseList;

public class Learn {
	Scanner scanner = new Scanner(System.in);
	boolean ischosen = false;
	public Learn(Integer userId, Integer courseNumber, ArrayList<Course> courses){
		System.out.println();
		System.out.println(CourseList.getCourse(courseNumber).get(0));
		
		for(Course c: courses) {
			if(c.equals(CourseList.getCourse(courseNumber).get(0)))
				ischosen = true;
		}
		
		if(ischosen) {
			while(true) {
				System.out.println("1. Display grades\n2. Drop this Class\n3. Back");
				System.out.println("Choose a serivce: ");
				switch(scanner.nextInt()) {
					case 1:
						if(!CourseList.getGrade(courseNumber, userId))
							System.out.println("No found");
						break;
					case 2:
						System.out.println("Are you sure to drop this class?(Y/N) ");
						if(scanner.nextLine().equals("Y") || scanner.nextLine().equals("y"))
							CourseList.deleteStudent(courseNumber, userId);
						System.out.println("You have droped " + CourseList.getName(courseNumber));
					case 3:
						return;
				}
			}
		}
		
		else {
			System.out.println("1. Add this Class\n2. Back");
			System.out.println("Choose a serivce: ");
			switch(scanner.nextInt()) {
				case 1:
					System.out.println("Are you sure to choose this class?(Y/N) ");
					if(scanner.nextLine().equals("Y") || scanner.nextLine().equals("y"))
						CourseList.addStudent(courseNumber, userId);
					System.out.println("You have added " + CourseList.getName(courseNumber));
					break;
				case 2:
					return;
			}
		}
	}
}
