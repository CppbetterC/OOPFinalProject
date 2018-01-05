package User;

import java.util.Objects;
import java.util.Scanner;

import Class.ClassList;
import User.User;

public class Admin extends User implements MailServer {

	public Admin(User user) {
		super(user);
		System.out.println("Welcome back, " + getAccount() + "\n");
		function();	
	}
	
	protected void function() {
		while (true) {
			System.out.println("1. New Class\n" + "2. Delete Class\n" + "3. Search Class\n" + "4. Edit Class\n" + "5. Logout\n" + "*****************");
			System.out.println("Enter your Service: ");
			switch (scanner.nextInt()) {
				case 1: {
					
					break;
				}
				case 2: {
					break;
				}
				case 3: {
					break;
				}
				case 4: {
					break;
				}
				case 5: {
					return;
				}
			}
		}
	}

	@Override
	public void update(ClassList absClass, Object message, Object newValue) {
		if (!Objects.isNull(newValue)) {
			String finalScore = newValue.toString();
			String tmpMessage = message.toString();
			System.out.println("You get a mail\n" + tmpMessage);
			System.out.println("期末成績已經被改變 ->分數:" + finalScore);
//			call write method to write file to txt
		}
	}
}
