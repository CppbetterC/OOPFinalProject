package User;

import java.util.ArrayList;
import java.util.Objects;

import Class.Course;
import Class.CourseList;
import User.User;

public class Scorer extends User {
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
}
