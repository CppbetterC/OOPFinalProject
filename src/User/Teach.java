package User;

import java.util.Scanner;

import Class.CourseList;

public class Teach {
	Scanner scanner = new Scanner(System.in);
	public Teach(Integer userId, Integer courseNumber){
		while(true) {
			System.out.println(CourseList.getCourse(courseNumber));
			System.out.println("1. Display tests\n2. Add Tests\n3. Delete Tests\n4. Rejister grades\n5. Set grades\n6. Back");
			switch(scanner.nextInt()) {
				case 1:
					if(CourseList.getGrade(courseNumber))
						System.out.println("Weight set Successful");
					else
						System.out.println("Weight set failed");
					break;
				case 2:
					System.out.println("Class name: ");
					if(CourseList.addGrade(courseNumber, scanner.nextLine()))
						System.out.println("Weight set Successful");
					else
						System.out.println("Weight set failed");
					break;
				case 3:
					if(CourseList.deleteGrade(courseNumber))
						System.out.println("Weight set Successful");
					else
						System.out.println("Weight set failed");;
					break;
				case 4:
					if(CourseList.setGrade(courseNumber))
						System.out.println("Weight set Successful");
					else
						System.out.println("Weight set failed");;
					break;
				case 5:
					if(CourseList.setWeight(courseNumber))
						System.out.println("Weight set Successful");
					else
						System.out.println("Weight set failed");
				case 6:
					return;
			}
		}
	}
}
