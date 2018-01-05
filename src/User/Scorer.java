package User;

import User.User;

public class Scorer extends User implements MailServer {
	public Scorer(User user){
		super(user);
		System.out.println("Welcome back, " + getAccount() + "\n");
		function();
	}
	
	protected void function() {
		
	}
}
