package User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Class.Course;
import Class.CourseList;

public class User {
	private static Integer count = 0;
	private Integer id;
	private String name;
	private String account;
	private String password;
	private String permission;
	private ArrayList<Course> course;

	protected Scanner scanner = new Scanner(System.in);
	
	public User(String id, String name, String account, String password, String permission) {
		this.id = Integer.valueOf(id);
		this.name = name;
		this.account = account;
		this.password = password;
		this.permission = permission;
		this.course  = CourseList.getCourse(this.getId());
		count = this.id + 1;
	}
	
	public User(String name, String account, String password, String permission) {
		this.id = count;
		this.name = name;
		this.account = account;
		this.password = password;
		this.permission = permission;
		this.course  = CourseList.getCourse(this.getId());
		count++;
	}

	public User(User u) {
		this.id = u.id;
		this.name = u.name;
		this.account = u.account;
		this.password = u.password;
		this.permission = u.permission;
		this.course  = CourseList.getCourse(this.getId());
		System.out.println("Welcome back, " + getName() + "\n");
	}
	
	public User() {}
	
	protected void function() {
		while (true) {
			System.out.println("Your Classes:");
			for(Course c: course) {
				System.out.println(c);
				System.out.println();
			}
			System.out.println("\n\n*****************\n1. Change Password\n" + "2. Search Class\n" + "3. Logout\n*****************");
			System.out.println("Choose a Service or Enter a class number directely: ");
			Integer choice = Integer.valueOf(scanner.nextLine());
			System.out.flush();
			switch (choice) {
				case 1: {
					System.out.println("Please Enter new Password: ");
					if(Main.setPassword(this.id, scanner.nextLine())){
						System.out.println("Password has been Changed\n");
					}
					else
						System.out.println("Password Change failed\n");
					break;
				}
				case 2: {
					System.out.print("Please Enter Class Number or Teacher name or Student name: ");
					System.out.println(CourseList.getCourse(scanner.nextLine()));
					break;
				}
				case 3: {
					return;
				}
				default:
					rollAction(choice);
					break;
			}
		}
	}
	
	//Let different Roll to do different Action
	protected void rollAction(Integer choice) {}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermission() {
		return permission;
	}
}
