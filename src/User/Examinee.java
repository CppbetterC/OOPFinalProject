package User;

import User.User;

public class Examinee extends User implements MailServer {
	public Examinee(User user){
		super(user);
		System.out.println("Welcome back, " + getAccount() + "\n");
		function();
	}
	
	protected void function() {
		
	}
}
