package Class;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import User.MailServer;
import User.User;

public class ClassList {
	private static boolean finalScoreChanged = false;
	private static ArrayList<MailServer> observers = new ArrayList<MailServer>();
	private static Vector obs;
	private static ArrayList<Course> allClass = new ArrayList<Course>();
	public ClassList() {
		obs = new Vector();
	}
	
	public static synchronized void addObserver(MailServer mail) {
		if (mail == null) {
			throw new NullPointerException();
		}
		if (!obs.contains(mail)) {
			obs.addElement(mail);
		}
	}

	public static void attachObserver(MailServer newObserver) {
		observers.add(newObserver);
	}
	
//	public static void notifyObserverGetFinalScore(String mailContext, float finalScore) {
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
//		for(MailServer obs : observers) {
//			obs.update(this, mailContext, finalScore);
//		}
//	}
	public static void OpenClassFlie() {
		ArrayList<String> student = new ArrayList<String>();
		FileReader fr;
		try {
			fr = new FileReader("src/Class.txt");
			BufferedReader br = new BufferedReader(fr);
			try {
				while(br.ready()) {
					String Line = br.readLine();
					String[] split = Line.split(";");
					for (int i = 2; i < split.length;i++) {
						student.add(split[i]);
					}
					allClass.add(new Course(split[0],split[1],student));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void getAllClass() {
		System.out.println(allClass.get(0).getTeacher());
	}
	
}
