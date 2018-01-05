import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Class.AbstractClass;
import User.Account;
import User.Admin;
import User.Examinee;
import User.Scorer;
import User.User;

public class Main {
	private static ArrayList<User> userList = new ArrayList<User>();
	private static Scanner scanner = new Scanner(System.in);
	private static User login;
	
	public static void main(String[] args) {
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
		int id = 0;
		try {
			fr = new FileReader("src/User.txt");
			BufferedReader br = new BufferedReader(fr);
			try {
				while(br.ready()) {
					String Line = br.readLine();
					String[] split = Line.split(";");
					userList.add(new User(split[0], split[1], split[2], split[3]));
					id++;
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
						login = new Admin(user);
						return "You have logged out\n";
					}
					else if(user.getPermission().equals("scorer")) {
						login = new Scorer(user);
						return "You have logged out\n";
					}
					else if (user.equals("examinee")) {
						login = new Examinee(user);
						return "You have logged out\n";
					}
					else {
						return "Login Failed\n";
					}
				}
				else
					return "Password Error\n";
			}
		}
		return "Account No Found\n";
	}
}
