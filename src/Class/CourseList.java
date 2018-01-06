package Class;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import User.MailServer;
import User.User;

public class CourseList {
	private static boolean finalScoreChanged = false;
	private static ArrayList<MailServer> observers = new ArrayList<MailServer>();
	private static Vector obs = new Vector();
	private static ArrayList<Course> allClass = new ArrayList<Course>();
	
	public CourseList() {
		ArrayList<Integer> student;
		FileReader fr;
		try {
			fr = new FileReader("src/Class.txt");
			BufferedReader br = new BufferedReader(fr);
			try {
				while(br.ready()) {
					String Line = br.readLine();
					String[] split = Line.split(";");
					student = new ArrayList<Integer>();
					for (int i = 3; i < split.length; i++) {
						student.add(Integer.valueOf(split[i]));
					}
					allClass.add(new Course(Integer.valueOf(split[0]), split[1], Integer.valueOf(split[2]), student));
				}
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static boolean addCourse(Integer number, String name) {
		for(Course c: allClass) {
			if(c.getNumber() == number) return false;
		}
		allClass.add(new Course(number, name));
		return true;
	}
	
	public static boolean deleteCourse(Integer number) {
		for(Course c: allClass) {
			if(c.getNumber() == number) {
				allClass.remove(c);
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<Course> getCourse(Integer id){
		ArrayList<Course> chosen = new ArrayList<Course>();
		for(Course c: allClass) {
			if(id == c.getTeacher())	chosen.add(c);
			ArrayList<Integer> students = c.getStudents();
			for(Integer student: students) {
				if(student == id) chosen.add(c);
			}
		}
		return chosen;
	}
	
	public static Course getCourse(String search){
		for(Course c: allClass) {
			if(search.equals(String.valueOf(c.getNumber())))	return c;
			if(search.equals(c.getTeacher().toString()))	return c;
			ArrayList<Integer> students = c.getStudents();
			for(Integer student: students) {
				if(search.equals(student.toString())) return c;;
			}
		}
		return null;
	}
	
	public static Integer getTeacher(Integer number) {
		for(Course c: allClass) {
			if(c.getNumber() == number) return c.getTeacher();
		}
		return -1;
	}
	public static boolean setTeacher(Integer number, Integer teacher) {
		for(Course c: allClass) {
			if(c.getNumber() == number) {
				c.setTeacher(teacher);
				return true;
			}
		}
		return false;
	}
	public static ArrayList<Integer> getStudents(Integer number) {
		for(Course c: allClass) {
			if(c.getNumber() == number) return c.getStudents();
		}
		return null;
	}
	public static boolean addStudent(Integer number, Integer student) {
		for(Course c: allClass) {
			if(c.getNumber() == number) return c.addStudent(student);
		}
		return false;
	}
	
	public static boolean deleteStudent(Integer number, Integer student) {
		for(Course c: allClass) {
			if(c.getNumber() == number) return c.deleteStudent(student);
		}
		return false;
	}
	
	public static String getName(Integer number) {
		for(Course c: allClass) {
			if(c.getNumber() == number) return c.getName();
		}
		return "Course " + String.valueOf(number) + " No found";
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
		ArrayList<Integer> student = new ArrayList<Integer>();
		FileReader fr;
		try {
			fr = new FileReader("src/Class.txt");
			BufferedReader br = new BufferedReader(fr);
			try {
				while(br.ready()) {
					String Line = br.readLine();
					String[] split = Line.split(";");
					for (int i = 3; i < split.length;i++) {
						student.add(Integer.valueOf(split[i]));
					}
					allClass.add(new Course(Integer.valueOf(split[0]), split[1], Integer.valueOf(split[2]), student));
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
	public static void createQuiz() {
		QuizApp quize = new QuizApp();
	}
	public static void createExam() {
		ExamApp exam = new ExamApp();
	}
	
}
