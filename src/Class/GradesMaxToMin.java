package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradesMaxToMin implements showFormat{

	Scanner scanner = new Scanner(System.in);
	private float [] grades; 
	private int [] nid;
	private int count = 0;
	
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
			Map<String, String> tmpScore = new HashMap<String, String>();
			tmpScore = test.get(choice).getStudentScore();
			
			for(String key : tmpScore.keySet()) {
				this.grades[count] = Float.parseFloat(tmpScore.get(key));
				this.nid[count] = Integer.parseInt(key.toString());
				count++;
			}
			int left = 0;
			int right = this.grades.length - 1;
			System.out.println("GradesMinToMax......");
			quickSort(left, right, this.grades, this.nid);
			System.out.println("[學號]\t\t[成績]");
			System.out.println("--------+--------------");
			for(int i = 0; i < this.grades.length; i++) {
				System.out.println("[" + this.nid[i] + "]" + "\t|\t[" + this.grades[i] + "]");
			}
			System.out.println("select successfully");
		}
		else if(flag.equals("N")) {
			System.out.println("select false");
		}
		else {
			System.out.println("error instruction");
		}
	}
	
    public void quickSort(int left, int right, float[] numberArray, int[] nid) {
        if(left > right)
        {
            return;
        }
        int startIndex = left; 
        int endIndex = right;   
        float baseValue = numberArray[left];
        
        int baseStr = nid[left];
        float temp;
        int tempStr;

        while (startIndex != endIndex)
        {
            while (numberArray[endIndex] >= baseValue && startIndex < endIndex){
                endIndex--;
            }

            while (numberArray[startIndex] <= baseValue && startIndex < endIndex){
                startIndex++;
            }

            if (startIndex < endIndex){
                temp = numberArray[startIndex];
                numberArray[startIndex] = numberArray[endIndex];
                numberArray[endIndex] = temp;
                
                tempStr = nid[startIndex];
                nid[startIndex] = nid[endIndex];
                nid[endIndex] = tempStr;
            }
        }

        numberArray[left] = numberArray[startIndex];
        numberArray[startIndex] = baseValue;
        
        nid[left] = nid[startIndex];
        nid[startIndex] = baseStr;

        quickSort(left, startIndex - 1, numberArray, nid);
        quickSort(startIndex + 1, right, numberArray, nid);

    }
}
