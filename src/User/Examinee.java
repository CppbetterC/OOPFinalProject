package User;

import User.User;

public class Examinee extends User {
	Learn learn;
	public Examinee(User user){
		super(user);
		function();
	}
	
	
	public Examinee() {
		super();
	}
	
	@Override
	protected void rollAction(Integer choice) {
		learn = new Learn(this.getId(), choice, course);
	}
}
