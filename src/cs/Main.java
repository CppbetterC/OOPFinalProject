package cs;

import java.util.Scanner;

public class Main {

	private int [] accountOfPermission = {0, 0, 0};
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String loginAccount;
		String loginPassword;
		
//		Loading AccountInformation from src/cs/User.txt
		User user = new User();
		
		
		System.out.println("Welcome to use the System");
		System.out.println("Please Login, Enter the Account");
		System.out.print("****:");
		loginAccount = scanner.nextLine();
		System.out.print("++++:");
		loginPassword = scanner.nextLine();
		
		// get the permission of this account
		String permission = user.accountVerify(loginAccount, loginPassword);
//		System.out.println(permission);
		if (permission.equals("admin")){
			loginWithAdmin(permission);
		}
		else if (permission.equals("scorer")) {
			
		}
		else if (permission.equals("examinee")) {
			
		}
		else {
			System.out.println("Invaild User");
		}
	
	}
	
	public static void loginWithAdmin(String permission) {
		System.out.println("Welcome to use the system\n"
				+ "your permission is" + permission);
		System.out.println("1. 學期開課\n"
				+ "2. 登記分數\n"
				+ "3. 成績查詢\n"
				+ "4. 離開系統\n"
				+ "*****************");
		System.out.println("Enter your service");
		int service = scanner.nextInt();
		
		while(true) {
			System.out.println("1. 學期開課\n"
					+ "2. 登記分數\n"
					+ "3. 成績查詢\n"
					+ "4. 離開系統\n"
					+ "*****************");
			System.out.println("Enter your service");
			service = scanner.nextInt();
			switch (service){
				case 1:{ 
					continue;
				}
				case 2:{
					continue;
				}
				case 3:{
					continue;
				}
				case 4:{
					System.out.println("bye!!!");
					break;
				}
			}
		}

		
	}

}
