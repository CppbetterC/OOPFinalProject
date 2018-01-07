package User;

import java.util.ArrayList;
import java.util.Objects;

import Class.Course;
import Class.CourseList;
import User.User;

public class Scorer extends User implements MailServer {
	Teach teach;
	public Scorer(User user){
		super(user);
		function();
	}
	
	public Scorer() {
		super();
	}
	
	
	@Override
	protected void rollAction(Integer choice) {
		teach = new Teach(this.getId(), choice, course);
	}

	@Override
	public void update(Object message) {
		if (!Objects.isNull(message)) {
			String tmpMessage = message.toString();
			System.out.println("You got a mail");
			System.out.println("[" + tmpMessage + "]");
//			call write method to write file to txt
		}
	}
}
