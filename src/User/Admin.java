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
	
	@Override
	public void function() {
		while (true) {
			System.out.println("1. Change Password\n2. Manage Accounts\n" + "3. Manage Classes\n" + "4. Logout\n" + "*****************");
			System.out.println("Choose a Service or Enter a class number directely: ");
			Integer choice = Integer.valueOf(scanner.nextLine());
			System.out.flush();
			switch (choice) {
				case 1:{
					System.out.println("Please Enter new Password: ");
					if(Main.setPassword(this.getId(), scanner.nextLine())){
						System.out.println("Password has been Changed\n");
					}
					else
						System.out.println("Password Change failed\n");
					break;
				} 
				case 2:{
					accountManager();
					break;
				}
				case 3: {
					courseManager();
					break;
				}
				case 4:
					return;
				default:
					break;
			}
		}
	}
	
	private void accountManager() {
		while(true) {
			Main.printUserList();
			System.out.println("\n\n*****************\n1. Add Accounts\n2. Delete Accounts\n3. Back\n*****************");
			System.out.println("Choose a Service: ");
			Integer choice = Integer.valueOf(scanner.nextLine());
			switch (choice) {
				case 1: {
					System.out.print("Name: ");
					String name = scanner.nextLine();
					System.out.print("Account: ");
					String account = scanner.nextLine();
					System.out.print("Password: ");
					String password = scanner.nextLine();
					System.out.print("Permission: ");
					String permission = scanner.nextLine();
					System.out.flush();
					if(Main.addAccount(name, account, password, permission))
						System.out.println("Account add successful!!");
					else
						System.out.println("Account already exist or Permission is illegal");
					break;
				}
				case 2: {
					System.out.print("Account id: ");
					Integer id = Integer.valueOf(scanner.nextLine());
					System.out.flush();
					if(Main.deleteAccount(id))
						System.out.println("Account Delete successful!!");
					else
						System.out.println("Account id is not exist");
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
	
	private void courseManager() {
		while(true) {
			CourseList.printAllCourse();
			System.out.println("\n\n*****************\n1. Add Class\n2. Delete Class\n3. Back\n*****************");
			System.out.println("Choose a Service: ");
			Integer choice = Integer.valueOf(scanner.nextLine());
			switch (choice) {
				case 1: {
					System.out.print("Class Name: ");
					String name = scanner.nextLine();
					CourseList.addCourse(name);
					System.out.flush();
					System.out.println("Account add successful!!");
					break;
				}
				case 2: {
					System.out.print("Class id: ");
					Integer id = Integer.valueOf(scanner.nextLine());
					System.out.flush();
					if(CourseList.deleteCourse(id))
						System.out.println("Class Delete successful!!");
					else
						System.out.println("Class id is not exist");
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
	
	@Override
	public void update(Object message) {
		if (!Objects.isNull(message)) {
			String tmpMessage = message.toString();
			System.out.println("You got a mail");
			System.out.println("[" + tmpMessage + "]");
//			call write method to write file to txt
		}
	}
}
