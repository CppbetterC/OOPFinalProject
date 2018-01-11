package User;

import java.util.ArrayList;
import java.util.Scanner;

import Class.Course;
import Class.CourseList;

public class Teach {
	Scanner scanner = new Scanner(System.in);
	boolean ischosen = false;
	public Teach(Integer userId, Integer courseNumber, ArrayList<Course> courses){
		System.out.println();
		System.out.println(CourseList.getCourse(courseNumber).get(0));
		
		for(Course c: courses) {
			if(c.equals(CourseList.getCourse(courseNumber).get(0)))
				ischosen = true;
		}
		
		if(ischosen) {
			while(true) {
				System.out.println("1. Display tests\n2. Add Tests\n3. Delete Tests\n4. Rejister grades\n5. Set weight\n6. Back");
				switch(Integer.valueOf(scanner.nextLine())) {
					case 1:
						if(!CourseList.getGrade(courseNumber))
							System.out.println("No test");
						break;
					case 2:
						System.out.println("Class name: ");
						if(CourseList.addGrade(courseNumber, scanner.nextLine()))
							System.out.println("Test add Successful");
						else
							System.out.println("Test add failed");
						break;
					case 3:
						if(CourseList.deleteGrade(courseNumber))
							System.out.println("Test delete Successful");
						else
							System.out.println("Test delete failed");;
						break;
					case 4:
						if(CourseList.setGrade(courseNumber))
							System.out.println("Grades set Successful");
						else
							System.out.println("Grades set failed");;
						break;
					case 5:
						if(CourseList.setWeight(courseNumber))
							System.out.println("Weight set Successful");
						else
							System.out.println("Weight set failed");
						break;
					case 6:
						return;
				}
			}
		}
		else {
			System.out.println("1. Teach this Class\n2. Back");
			System.out.println("Choose a serivce: ");
			switch(scanner.nextInt()) {
				case 1:
					System.out.println("Are you sure to choose this class?(Y/N) ");
					if(scanner.nextLine().equals("Y") || scanner.nextLine().equals("y"))
						if(CourseList.setTeacher(courseNumber, userId))
							System.out.println("You have added " + CourseList.getName(courseNumber));
						else
							System.out.println(CourseList.getName(courseNumber) + "aleady has teacher");
					break;
				case 2:
					return;
			}
		}
	}
}
