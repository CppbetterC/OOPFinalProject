package cs;

import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		String loginAccount;
		String loginPassword;
		
//		Loading AccountInformation from src/cs/User.txt
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to use the System");
		System.out.println("Please Login, Enter the Account");
		System.out.print("****:");
		loginAccount = scanner.nextLine();
		System.out.print("++++:");
		loginPassword = scanner.nextLine();
		
//		System.out.println(loginAccount);
//		System.out.println(loginPassword);
		
		String permission = user.accountVerify(loginAccount, loginPassword);
		System.out.println(permission);
	
	}

}
