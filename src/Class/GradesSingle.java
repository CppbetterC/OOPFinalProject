package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradesSingle implements showFormat{
	
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void showGrades(ArrayList<AbstractExam> test) {
		int index = 0;
		System.out.println("Which index do you want to select");
		
		for(AbstractExam app : test) {
			System.out.println(index + ":" + app.getClass().toString());
			index++;
		}
		System.out.println("Choice:");
		int choice = scanner.nextInt();
		System.out.println("Do you want to select this?(Y/N)\nIndex = " 
		+ test.get(choice));
		String flag = scanner.nextLine();
		if (flag.equals("Y")) {
			System.out.println("What is your nid"); 
			String nid = scanner.nextLine();
			Map<String, String> tmpScore = new HashMap<String, String>();
			tmpScore = test.get(choice).getStudentScore();
			System.out.println("[學號]\t\t[成績]");
			System.out.println("--------+--------------");
			System.out.println("[" + nid + "]" + "\t|\t[" + tmpScore.get(nid) + "]");
			System.out.println("select successfully");
		}
		else if(flag.equals("N")) {
			System.out.println("select false");
		}
		else {
			System.out.println("error instruction");
		}
	}

}
