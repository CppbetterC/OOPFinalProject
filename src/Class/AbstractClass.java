package Class;


import java.util.ArrayList;
import java.util.Vector;

import User.MailServer;

public class AbstractClass {
	private boolean finalScoreChanged = false;
	private ArrayList<MailServer> observers = new ArrayList<MailServer>();
	private Vector obs;
	
	public AbstractClass() {
		obs = new Vector();
	}
	
	public synchronized void addObserver(MailServer mail) {
		if (mail == null) {
			throw new NullPointerException();
		}
		if (!obs.contains(mail)) {
			obs.addElement(mail);
		}
	}
	
	public void attachObserver(MailServer newObserver) {
		observers.add(newObserver);
	}
	
	public void notifyObserverGetFinalScore(String mailContext, float finalScore) {
//		String [] str;
//		synchronized (this) {
//			if (!finalScoreChanged) {
//				return;
//			}
//			else {
//				str = (String[]) obs.toArray();
//				clearChanged();
//			}
//		}
		for(MailServer obs : observers) {
			obs.update(this, mailContext, finalScore);
		}
	}
	
}
