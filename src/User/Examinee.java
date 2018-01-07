package User;

import java.util.ArrayList;
import java.util.Objects;

import Class.Course;
import Class.CourseList;
import User.User;

public class Examinee extends User implements MailServer {
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
