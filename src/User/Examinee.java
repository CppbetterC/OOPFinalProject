package User;

import java.util.ArrayList;
import java.util.Objects;

import Class.Course;
import Class.CourseList;
import User.User;

public class Examinee extends User/* implements MailServer*/ {
	private ArrayList<Course> course  = CourseList.getCourse(this.getId());
	Learn learn;
	public Examinee(User user){
		super(user);
		System.out.println("Welcome back, " + getName() + "\n");
		function();
	}
	
	protected void function() {
		while (true) {
			System.out.println("Your Classes:");
			for(Course c: course) {
				System.out.println(c);
				System.out.println();
			}
			System.out.println("\n\n*****************\n1. Change Password\n" + "2. Search Class\n" + "3. Logout\n*****************");
			System.out.println("Choose a Service or Enter a class number directely: ");
			Integer choice = scanner.nextInt();
			switch (choice) {
				case 1: {
					scanner.nextLine();
					System.out.println("Please Enter new Password: ");
					if(this.setPassword(scanner.nextLine()))
						System.out.println("Password has been Changed\n");
					else
						System.out.println("Password Change failed\n");
					break;
				}
				case 2: {
					System.out.println(CourseList.getCourse(scanner.nextLine()));
					break;
				}
				case 3: {
					return;
				}
				default:
					learn = new Learn(this.getId(), choice);
					break;
			}
		}
	}

	public static void update(CourseList absClass, Object message, Object newValue) {
		if (!Objects.isNull(newValue)) {
			String finalScore = newValue.toString();
			String tmpMessage = message.toString();
			System.out.println("You get a mail\n" + tmpMessage);
			System.out.println("期末成績已經被改變 ->分數:" + finalScore);
//			call write method to write file to txt
		}
	}
}
