package User;

import Class.AbstractClass;

// MailServer is a observer(Design Pattern) for Admin, Scorer and Examinee
// We will let the application to write some code to create a mailServer only for that application.

public interface MailServer {
	
	public abstract void update(AbstractClass absClass, 
			Object message, Object newValue);
	
}
