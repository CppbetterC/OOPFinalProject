package User;

import java.util.Objects;

import Class.CourseList;
import User.User;

public class Examinee extends User/* implements MailServer*/ {
	public Examinee(User user){
		super(user);
		System.out.println("Welcome back, " + getAccount() + "\n");
		function();
	}
	
	protected void function() {
		while (true) {
			System.out.println("1. Change Password\n" + "2. Search Class\n" + "3. Logout\n" + "*****************");
			System.out.println("Enter your Service: ");
			switch (scanner.nextInt()) {
				case 1: {
					if(this.setPassword(scanner.nextLine()))
						System.out.println("Password has been Changed\n");
					else
						System.out.println("Password Change failed\n");
					break;
				}
				case 2: {
					break;
				}
				case 3: {
					return;
				}
				default:
					break;
			}
		}
	}
/*
	public static void update(CourseList absClass, Object message, Object newValue) {
		if (!Objects.isNull(newValue)) {
			String finalScore = newValue.toString();
			String tmpMessage = message.toString();
			System.out.println("You get a mail\n" + tmpMessage);
			System.out.println("期末成績已經被改變 ->分數:" + finalScore);
//			call write method to write file to txt
		}
	}*/
}
