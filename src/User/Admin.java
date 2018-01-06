package User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import Class.Course;
import Class.CourseList;
import User.User;

public class Admin extends User implements MailServer {
	public Admin(User user) {
		super(user);
		System.out.println("Welcome back, " + getAccount() + "\n");
		function();	
	}
	
	public void function() {
		while (true) {
			System.out.println("1. Manage Accounts\n" + "2. Manage Classes\n" + "3. Logout\n" + "*****************");
			System.out.println("Choose a Service or Enter a class number directely: ");
			Integer choice = scanner.nextInt();
			switch (choice) {
				case 1: {
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
				default:
					break;
			}
		}
	}
	
	@Override
	public void update(CourseList absClass, Object message, Object newValue) {
		if (!Objects.isNull(newValue)) {
			String finalScore = newValue.toString();
			String tmpMessage = message.toString();
			System.out.println("You get a mail\n" + tmpMessage);
			System.out.println("期末成績已經被改變 ->分數:" + finalScore);
//			call write method to write file to txt
		}
	}
}
