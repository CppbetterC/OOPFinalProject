package Class;

import java.util.ArrayList;
import java.util.Scanner;

import User.Main;

public abstract class TestManager {
	protected ArrayList<AbstractExam> tests = new ArrayList<AbstractExam>();
	protected Scanner scanner = new Scanner(System.in);

	public abstract void addGrade(String name);
	
	public abstract boolean deleteGrade();
	
	public abstract boolean getGrade(ArrayList<Integer> students);

	public abstract void getGrade(ArrayList<Integer> students, Integer userId);
	
	public abstract boolean setGrade(ArrayList<Integer> students);
}
