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

import Class.ClassList;
import Class.Course;
import User.User;

public class Admin extends User implements MailServer {
	
	private  ArrayList<String> defaultCourseName = new ArrayList<String>();
	private  ArrayList<String> defaultTeacherName = new ArrayList<String>();
	private  ArrayList<Course> defaultCourse = new ArrayList<Course>();
	
	public Admin(User user) {
		super(user);
		System.out.println("Welcome back, " + getAccount() + "\n");
		function();	
	}
	
	public void function() {
		while (true) {
			System.out.println("1. New Class\n" 
					+ "2. Delete Class\n" 
					+ "3. Search Class\n" 
					+ "4. Edit Class\n" 
					+ "5. Logout\n" + "*****************");
			System.out.println("Enter your Service: ");
			switch (scanner.nextInt()) {
				case 1: {
//					New Class, To create the class and set the all attribute;
					System.out.println("System is setting the couse in this semester");
					
					defaultCourseName.add("Math");
					defaultCourseName.add("Chemistry");
					defaultCourseName.add("Physical");
					defaultCourseName.add("Art");
					defaultCourseName.add("History");
					defaultCourseName.add("Geography");
					
					defaultTeacherName.add("Chen");
					defaultTeacherName.add("Lin");
					defaultTeacherName.add("Kuo");
					defaultTeacherName.add("Wang");
					defaultTeacherName.add("Ying");
					defaultTeacherName.add("Cheng");
					
					for(int i = 0; i < defaultCourseName.size(); i++) {
						defaultCourse.add(new Course(defaultCourseName.get(i).toString()));
					}
					this.writeCourseToFile(defaultCourse);
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
					System.out.println("Leave System......");
					System.out.println("bye!");
					return;
				}
			}
		}
	}
	
	private void writeCourseToFile(ArrayList<Course> courseInformation) {
		FileWriter fw;
		BufferedWriter bw;
		PrintWriter out;
		ArrayList<Course> tmpCourse = courseInformation;
		try {
			fw = new FileWriter("src/Class.txt", true);
			bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			
			// bug , get the address not value;
			for(int i = 0; i < tmpCourse.size(); i++) {
				out.print(tmpCourse.get(i).toString() + ";");
				out.println();
			}
			
			out.close();
			System.out.println("insert data to file successfully");
		} catch (IOException e) {
			e.printStackTrace();
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
