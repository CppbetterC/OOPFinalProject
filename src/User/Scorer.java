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
	
	@Override
	protected void rollAction(Integer choice) {
		teach = new Teach(this.getId(), choice);
	}

	@Override
	public void update(CourseList absClass, Object message, Object newValue) {
		if (!Objects.isNull(newValue)) {
			String finalScore = newValue.toString();
			String tmpMessage = message.toString();
			System.out.println("You get a mail\n" + tmpMessage);
			System.out.println("期末成績已經被改變 ->分數:" + finalScore);
//			call write method to write file to txt
		}
	}
}
