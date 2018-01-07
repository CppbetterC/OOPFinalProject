package Class;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import User.MailServer;
import User.Main;
import User.User;

public class CourseList {
	private static boolean finalScoreChanged = false;
	private static ArrayList<MailServer> observers = new ArrayList<MailServer>();
	private static Vector obs = new Vector();
	public static ArrayList<Course> allClass = new ArrayList<Course>();
	
	public CourseList() {
		ArrayList<Integer> student, minScore, finScore;
		FileReader fr, fr2;
		BufferedReader br, br2;
		try {
			fr = new FileReader("src/DataBase/Class.txt");
			br = new BufferedReader(fr);
			minScore = new ArrayList<Integer>();
			finScore = new ArrayList<Integer>();
			
			try {
				while(br.ready()) {
					String Line = br.readLine();
					String[] split = Line.split(";");
					student = new ArrayList<Integer>();
					for (int i = 3; i < split.length; i++) {
						student.add(Integer.valueOf(split[i]));
					}

					fr2 = new FileReader("src/DataBase/" + split[1]+".txt");
					br2 = new BufferedReader(fr2);
					while(br2.ready()) {
						minScore.clear();
						finScore.clear();
						String str = br2.readLine();
						String[] slice = str.split(";");
						for(int i = 1; i < slice.length; i++) {
							minScore.add(Integer.valueOf(1));
							finScore.add(Integer.valueOf(2));
						}
					}
					allClass.add(new Course(Integer.valueOf(split[0]), split[1], Integer.valueOf(split[2]),
								student, minScore, finScore));
				}
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void addCourse(String name) {
		allClass.add(new Course(name));
	}
	
	public static boolean deleteCourse(Integer number) {
		for(Course c: allClass) {
			if(c.getNumber().equals(number)) {
				allClass.remove(c);
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<Course> getCourse(Integer id){
		ArrayList<Course> chosen = new ArrayList<Course>();
		for(Course c: allClass) {
			if(id.equals(c.getTeacher()))	chosen.add(c);
			ArrayList<Integer> students = c.getStudents();
			for(Integer student: students) {
				if(student.equals(id)) chosen.add(c);
			}
		}
		return chosen;
	}
	
	public static ArrayList<Course> getCourse(String search){
		ArrayList<Course> result = new ArrayList<Course>();
		for(Course c: allClass) {
			if(search.equals(String.valueOf(c.getNumber())))	result.add(c);
			else if(search.equals(Main.getUserName(c.getTeacher())))	result.add(c);
			else {
				ArrayList<Integer> students = c.getStudents();
				for(Integer student: students) {
					if(search.equals(Main.getUserName(student))) result.add(c);
				}
			}
		}
		return result;
	}
	
	public static Integer getTeacher(Integer number) {
		for(Course c: allClass) {
			if(c.getNumber().equals(number)) return c.getTeacher();
		}
		return -1;
	}
	public static boolean setTeacher(Integer number, Integer teacher) {
		for(Course c: allClass) {
			if(c.getNumber().equals(number)) {
				c.setTeacher(teacher);
				return true;
			}
		}
		return false;
	}
	public static ArrayList<Integer> getStudents(Integer number) {
		for(Course c: allClass) {
			if(c.getNumber().equals(number)) return c.getStudents();
		}
		return null;
	}
	public static boolean addStudent(Integer number, Integer student) {
		for(Course c: allClass) {
			if(c.getNumber().equals(number)) return c.addStudent(student);
		}
		return false;
	}
	
	public static boolean deleteStudent(Integer number, Integer student) {
		for(Course c: allClass) {
			if(c.getNumber().equals(number)) return c.deleteStudent(student);
		}
		return false;
	}
	
	public static String getName(Integer number) {
		for(Course c: allClass) {
			if(c.getNumber().equals(number)) return c.getName();
		}
		return "Course " + String.valueOf(number) + " No found";
	}
	
	public static void printAllCourse() {
		for(Course c: allClass) {
			System.out.println(c);
		}
	}

	public static void attachObserver(MailServer newObserver) {
		observers.add(newObserver);
	}

//	Notify all observer, sent messages to them;
	public static void notifyObserverGetFinalScore(String mailContext) {
		for(MailServer obs : observers) {
			obs.update(mailContext);
		}
	}
	
	public static boolean addGrade(Integer number, String name) {
		for(Course c: allClass) {
			if(c.getNumber().equals(number)) {
				c.addGrade(name);
				return true;
			}
		}
		return false;
	}
	
	public static boolean deleteGrade(Integer number) {
		for(Course c: allClass) {
			if(c.getNumber().equals(number)) {
				return c.deleteGrade();
			}
		}
		return false;
	}
	
	public static boolean setGrade(Integer number) {
		for(Course c: allClass) {
			if(c.getNumber().equals(number)) {
				notifyObserverGetFinalScore("You had got a mail!");
				return c.setGrade();
			}
		}
		return false;
	}
	
	public static boolean setWeight(Integer number) {
		for(Course c: allClass) {
			if(c.getNumber().equals(number)) {
				return c.setWeight();
			}
		}
		return false;
	}
	
	public static boolean getGrade(Integer number) {
		for(Course c: allClass) {
			if(c.getNumber() == number) {
				return c.getGrade();
			}
		}
		return false;
	}

	public static boolean getGrade(Integer number, Integer userId) {
		for(Course c: allClass) {
			if(c.getNumber() == number) {
				c.getGrade(userId);
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<Course> getAllClass() {
		return allClass;
	}
	public static int getAllClasslen() {
		return allClass.size();
	}
	public static int getAllClassId(int index) {
		return allClass.get(index).getNumber();
	}
	public static String getAllClassName(int index) {
		return allClass.get(index).getName();
	}
	public static int getAllClassTeacher(int index) {
		return allClass.get(index).getTeacher();
	}
	public static ArrayList<Integer> getAllClassStudent(int index) {
		return allClass.get(index).getStudents();
	}
	public static TestManager getAllClassGrade(int index) {
		return allClass.get(index).getTestManager();
	}
}
