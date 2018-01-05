package User;

import java.util.Scanner;

import User.User;

public class Admin extends User implements MailServer {

	public Admin(User user) {
		super(user);
		System.out.println("Welcome back, " + getAccount() + "\n");
		function();
	}
	
	protected void function() {
		while (true) {
			System.out.println("1. 學期開課\n" + "2. 登記分數\n" + "3. 成績查詢\n" + "4. 離開系統\n" + "*****************");
			System.out.println("Enter your service");
			switch (scanner.nextInt()) {
				case 1: {
					continue;
				}
				case 2: {
					continue;
				}
				case 3: {
					continue;
				}
				case 4: {
					System.out.println("bye!!!");
					break;
				}
			}
		}
	}
}
