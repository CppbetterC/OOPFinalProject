package User;

import java.util.ArrayList;
import java.util.Objects;

import Class.Course;
import Class.CourseList;
import User.User;

public class Examinee extends User/* implements MailServer*/ {
	Learn learn;
	public Examinee(User user){
		super(user);
		function();
	}
	
	@Override
	protected void rollAction(Integer choice) {
		learn = new Learn(this.getId(), choice);
	}

	public static void update(CourseList absClass, Object message, Object newValue) {
		if (!Objects.isNull(newValue)) {
			String finalScore = newValue.toString();
			String tmpMessage = message.toString();
			System.out.println("You get a mail\n" + tmpMessage);
			System.out.println("期末成績已經被改變 ->分數:" + finalScore);
//			call write method to write file to txt
		}
	}
}
