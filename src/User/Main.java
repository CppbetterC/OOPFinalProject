package User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Class.Course;
import Class.CourseList;

public class Main {
	private static ArrayList<User> userList = new ArrayList<User>();
	private static Scanner scanner = new Scanner(System.in);
	private static User login;
	
	public static void main(String[] args) {
		CourseList list = new CourseList();
		list.OpenClassFlie();
		list.getAllClass();
		String loginAccount;
		String loginPassword;
		System.out.println("Welcome to use the System");
		System.out.println("Please Login, Enter the Account");
		while(true) {
			System.out.print("Account:");
			loginAccount = scanner.nextLine();
			System.out.print("Password:");
			loginPassword = scanner.nextLine();		
			readAccount();		// prepare the account list for login
			System.out.println(Verify(loginAccount, loginPassword));	// get the permission of this account
			System.out.println("hello");
		}
	}
	
	private static void readAccount() {
		FileReader fr;
		try {
			fr = new FileReader("src/User.txt");
			BufferedReader br = new BufferedReader(fr);
			try {
				while(br.ready()) {
					String Line = br.readLine();
					String[] split = Line.split(";");
					userList.add(new User(split[0], split[1], split[2], split[3], split[4]));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String Verify(String account, String password) {
		for(User user: userList) {
			if(account.equals(user.getAccount())) {
				if(password.equals(user.getPassword())) {
					if(user.getPermission().equals("admin")) {
						System.out.println("Your permission is admin");
						login = new Admin(user);
//						pass data to writeClassToFile, writeGradesFile
//						writeClassToFile();
//						writeGradesToFile();
						
					}
					else if(user.getPermission().equals("scorer")) {
						System.out.println("Your permission is scorer");
						login = new Scorer(user);
//						pass data to writeClassToFile, writeGradesFile
//						writeClassToFile();
//						writeGradesToFile();
					}
					else if (user.equals("examinee")) {
						System.out.println("Your permission is examinee");
						login = new Examinee(user);
//						pass data to writeClassToFile, writeGradesFile
//						writeClassToFile();
//						writeGradesToFile();
					}
					else {
						return "Login Failed\n";
					}
					user = login;
					return "You have logged out\n";
				}
				else
					return "Password Error\n";
			}
		}
		return "Account No Found\n";
	}
	
	public static String getUserName(Integer id) {
		for(User user: userList) {
			if(user.getId() == id) {
				return user.getName();
			}
		}
		return "N/A";
	}
	
	private static void writeClassToFile() {
//		pass data to write data to file
		FileWriter fw;
		try {
			fw = new FileWriter("src/Class.txt");
			fw.write("data");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeGradesToFile() {
//		pass data to write data to file
		FileWriter fw;
		try {
			fw = new FileWriter("src/Class.txt");
			fw.write("data");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
