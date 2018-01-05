package Account;

import java.util.Scanner;

import Account.User;

public class Admin extends User implements MailServer{
	private Scanner scanner = new Scanner(System.in);
	private Account user;
	public Admin(Account user){
		this.user = user;
		System.out.println("Welcome to use the system\n"
				+ "your permission is" + user.getPermission());
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
