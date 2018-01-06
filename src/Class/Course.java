package Class;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import User.Main;
import User.User;

public class Course {
	private static Integer count = 1001;
	private Integer number;
	private String name;
	private Integer teacher;
	private ArrayList<Integer> student;
	private showFormat showFormat;
	Scanner scanner = new Scanner(System.in);
	
//	every AbstractExamApp will new Exam or Quiz;
//	We will set and get the score of the exam or quiz by this variable;
	private ArrayList<AbstractExam> numOfTest = new ArrayList<AbstractExam>();
	
	public Course(String name){
		this.number = count;
		this.name = name;
//		default showFormat is GradesMaxToMin
// 		we can change the showFormat to showSingleGrade
		this.showFormat = new GradesMaxToMin();
		count++;
	}
	public Course(Integer number, String name, Integer teacher, ArrayList<Integer> student){
		this.number = number;
		this.name = name;
		this.teacher = teacher;
		this.student = student;
//		default showFormat is GradesMaxToMin
		this.showFormat = new GradesMaxToMin();
		count = this.number + 1;
	}
	
	public Integer getNumber() {
		return this.number;
	}
	
	public Integer getTeacher() {
		return teacher;
	}
	public void setTeacher(Integer teacher) {
		this.teacher = teacher;
	}
	public ArrayList<Integer> getStudents() {
		return student;
	}
	public boolean addStudent(Integer student) {
		for(Integer s: this.student)
			if(s == student)	return false;
		this.student.add(student);
		return true;
	}
	
	public boolean deleteStudent(Integer student) {
		for(Integer s: this.student)
			if(s == student) {
				this.student.remove(s);
				return true;
			}
		return false;
	}
	
	public String getName() {
		return name;
	}
	
//	implement the showFormat
//	using the design pattern(strategy)
	public void getAllGrade() {
		this.showFormat.showGrades(this.numOfTest);
	}
	
	public void getSingleGrade(Integer userId, Integer courseName) {
		ArrayList<String> id = new ArrayList<String>();
		Map<String, String>  tmpScore = new HashMap<String, String>();
		

//		FileReader fr;
//		int count = 0;
//		try {
//			fr = new FileReader("src/" + courseName.toString() + ".txt");
//			BufferedReader br = new BufferedReader(fr);
//			try {
//				while(br.ready()) {
//					if(count != 0) {
//						String Line = br.readLine();
//						String[] split = Line.split(";");
//						id.add(split[0]);
//						studentMidScore.put(split[0], split[1]);
//						studentFinScore.put(split[0], split[2]);
//					}
//					count++;
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		for(int i = 1; i < id.size(); i++) {
//			if ( userId == Integer.parseInt(id.get(i))){
//				System.out.println("Searching successfully...");
//				System.out.println("[UserId]\t\t[Mid]\t\t[Fin]");
//				System.out.println("--------+--------------");
//				System.out.print(userId + "\t|\t" 
//				+ studentMidScore.get(id.get(i)) 
//				+"\t|\t"
//				+ studentFinScore.get(id.get(i)));
//				break;
//			}
//		}
	}
	
	@Override
	public String toString() {
		return "Class: " + String.valueOf(this.number) + " " + this.name + "\nTeacher: " + Main.getUserName(this.teacher);
	}

//	increase the test and the type of the text either Exam or Quiz
	public void addGrade() {
		AbstractExamApp app;
		System.out.println("Which type do you want to add");
		System.out.println("1.Quiz:\n2.Exam:\n");
		int choice = scanner.nextInt();
		if (choice == 1) {
			 app = new QuizApp();
			this.numOfTest.add(app.getTypeOfTest());
		}
		else if (choice == 2) {
			app  = new ExamApp();
			this.numOfTest.add(app.getTypeOfTest());
		}
		else {
			System.out.println("Error system instruction");
		}
	}
	
	public void deleteGrade() {
		int index = 0;
		System.out.println("Which index do you want to delete");
		
		for(AbstractExam app : numOfTest) {
			System.out.println(index + ":" + app.getClass().toString());
			index++;
		}
		System.out.println("Choice:");
		int choice = scanner.nextInt();
		System.out.println("Do you want to delete this?(Y/N)\nIndex = " 
		+ this.numOfTest.get(choice));
		String flag = scanner.nextLine();
		if (flag.equals("Y")) {
			this.numOfTest.remove(choice);
			System.out.println("delete successfully");
		}
		else if(flag.equals("N")) {
			System.out.println("delete false");
		}
		else {
			System.out.println("error instruction");
		}
	}
	
	public void setGrade() {
		int index = 0;
		System.out.println("Which index do you want to set grades");
		
		for(AbstractExam app : numOfTest) {
			System.out.println(index + ":" + app.getClass().toString());
			index++;
		}
		System.out.println("Choice:");
		int choice = scanner.nextInt();
		System.out.println("Do you want to delete this?(Y/N)\nIndex = " 
		+ this.numOfTest.get(choice));
		String flag = scanner.nextLine();
		if (flag.equals("Y")) {
			System.out.println("Enter the scores of the every student");
			ArrayList<Integer> scoreOfStudent = new ArrayList<Integer>();
			for(int i = 0;i < this.student.size(); i++) {
				int tmpScore = scanner.nextInt();
				scoreOfStudent.add(tmpScore);
			}
			this.numOfTest.get(choice).setScore(this.student, scoreOfStudent);
			System.out.println("update successfully");
		}
		else if(flag.equals("N")) {
			System.out.println("update false");
		}
		else {
			System.out.println("error instruction");
		}
	}
	
	
}
