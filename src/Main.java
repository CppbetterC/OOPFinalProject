import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Account.Account;
import Account.Admin;
import Account.Examinee;
import Account.Scorer;
import Account.User;

public class Main {
	private static ArrayList<Account> userList = new ArrayList<Account>();
	private static Scanner scanner = new Scanner(System.in);
	private static User user;
	
	public static void main(String[] args) {
		String loginAccount;
		String loginPassword;

		System.out.println("Welcome to use the System");
		System.out.println("Please Login, Enter the Account");
		System.out.print("Account:");
		loginAccount = scanner.nextLine();
		System.out.print("Password:");
		loginPassword = scanner.nextLine();
		
		// prepare the account list for login
		readAccount();
		// get the permission of this account
		System.out.println(Verify(loginAccount, loginPassword));
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
					userList.add(new Account(split[0], split[1], split[2], split[3]));
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
		for(Account ul: userList) {
			if(account.equals(ul.getAccount())) {
				if(password.equals(ul.getPassword())) {
					if(ul.getPermission().equals("admin")) {
						user = new Admin(ul);
					}
					else if(ul.getPermission().equals("scorer")) {
						user = new Scorer();
					}
					else if (ul.equals("examinee")) {
						user = new Examinee();
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
	
	public static void loginWithAdmin(String permission) {	
	}
}
