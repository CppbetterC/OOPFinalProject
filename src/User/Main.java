package User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Class.Course;
import Class.CourseList;
import Class.TestManager;

public class Main {
	private static ArrayList<User> userList = new ArrayList<User>();
	private static Scanner scanner = new Scanner(System.in);
	private static User login;
	
	public static void main(String[] args) {
		CourseList list = new CourseList();
		String loginAccount;
		String loginPassword;
		System.out.println("Welcome to use the System");
		while(true) {
			System.out.print("Account:");
			loginAccount = scanner.nextLine();
			System.out.print("Password:");
			loginPassword = scanner.nextLine();	
			readAccount();		
			System.out.println(Verify(loginAccount, loginPassword));
		}
	}
	
	private static void readAccount() {
		FileReader fr;
		userList.clear();
		try {
			fr = new FileReader("src/DataBase/User.txt");
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
						
					}
					else if(user.getPermission().equals("scorer")) {
						System.out.println("Your permission is scorer");
						login = new Scorer(user);
					}
					else if (user.getPermission().equals("examinee")) {
						System.out.println("Your permission is examinee");
						login = new Examinee(user);
					}
					else {
						return "Login Failed\n";
					}
					deleteAllFile(new File("src/DataBase"));
					restoreClass();
					restoreUser();
					restoreCourse();
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
			if(user.getId().equals(id)) {
				return user.getName();
			}
		}
		return "N/A";
	}
	
	public static void printUserList() {
		for(User user: userList) {
			System.out.println(user.getId() + " " + user.getName());
		}
	}
	
	public static boolean addAccount(String name, String account, String password, String permission) {
		if(!permission.equals("admin") && !permission.equals("scorer") && !permission.equals("examinee"))
			return false;
		for(User user: userList) {
			if(user.getAccount().equals(account))	return false;
		}
		userList.add(new User(name, account, password, permission));
		return true;
	}
	
	public static boolean deleteAccount(Integer id) {
		for(User user: userList) {
			if(user.getId().equals(id)) {
				userList.remove(user);
				return true;
			}
		}
		return false;
	}
	
	public static boolean setPassword(Integer id, String password) {
		for(User user: userList) {
			if(user.getId().equals(id)) {
				user.setPassword(password);
				return true;
			}
		}
		return false;
	}
	
	private static void restoreClass() {
		FileWriter fw;
		ArrayList<Course> course = CourseList.getAllClass();
		try {
			fw = new FileWriter("src/DataBase/Class.txt");
			for (int i = 0; i < course.size(); i++) {
				Integer courseId = CourseList.getAllClassId(i);
				String courseName = CourseList.getAllClassName(i);
				Integer courseTeacher = CourseList.getAllClassTeacher(i);
				ArrayList<Integer> courseStudent = CourseList.getAllClassStudent(i);
				BufferedWriter br = new BufferedWriter(fw);
				br.write(courseId + ";");
				br.write(courseName + ";");
				br.write(courseTeacher + ";");
				for (Integer j :courseStudent){
					br.write(String.valueOf(j));
					if (j.equals(courseStudent.get(courseStudent.size()-1))) {
						break;
					}
					br.write(";");
				}
				if (i == course.size()-1) {
					br.flush();
					break;
				}
				br.newLine();
				br.flush();
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	private static void restoreCourse() {
		FileWriter fw;
		ArrayList<Course> course = CourseList.getAllClass();
		try {
			for (int i = 0; i < course.size(); i++) {
				TestManager test = CourseList.getAllClassGrade(i);
				Integer courseId = CourseList.getAllClassId(i);
				String courseName = CourseList.getAllClassName(i);
				Integer courseTeacher = CourseList.getAllClassTeacher(i);
				ArrayList<Integer> courseStudent = CourseList.getAllClassStudent(i);
				fw = new FileWriter("src/DataBase/"+courseId+".txt");
				BufferedWriter br = new BufferedWriter(fw);
				br.write(courseTeacher + ";");
				for (int j = 0; j < test.gettestlen(); j++) {
					String textName = test.getName(j);
					br.write(textName);
					if (j == test.gettestlen()-1) {
						break;
					}
					br.write(";");
				}
				br.newLine();
				for (int k = 0; k< courseStudent.size(); k++) {
					br.write(courseStudent.get(k) + ";");
					for(int l = 0; l < test.gettestlen(); l++) {
						Integer textGrade = test.getGrade(l, courseStudent.get(k), courseStudent);
						br.write(textGrade.toString());
						if (l == test.gettestlen()-1) {
							break;
						}
						br.write(";");
					}
					if (k == courseStudent.size()-1) {
						break;
					}
					br.newLine();
				}
				br.flush();
				fw.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void restoreUser() {
		FileWriter fw;
		try {
			fw = new FileWriter("src/DataBase/User.txt");
			for (int i = 0; i < userList.size(); i++) {
				Integer id = userList.get(i).getId();
				String name = userList.get(i).getName();
				String account = userList.get(i).getAccount();
				String password = userList.get(i).getPassword();
				String Permission = userList.get(i).getPermission();
				BufferedWriter br = new BufferedWriter(fw);
				br.write(id + ";");
				br.write(name + ";");
				br.write(account + ";");
				br.write(password + ";");
				br.write(Permission);
				if (i == userList.size()-1) {
					br.flush();
					break;
				}
				br.newLine();
				br.flush();
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteAllFile(File path) {
		if (!path.exists()) {
            return;
        }
        if (path.isFile()) {
            path.delete();
            return;
        }
        File[] files = path.listFiles();
        for (int i = 0; i < files.length; i++) {
        	deleteAllFile(files[i]);
        }
        path.delete();
	}
}
