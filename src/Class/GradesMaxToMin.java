package Class;

public class GradesMaxToMin implements showFormat{

	private float [] grades; 
	private String [] nid;
	
	@Override
	public void showGrades(float[] grades, String[] nid) {
//		need to know which subject do user want to retrieve.
		this.grades = grades;
		this.nid = nid;
		int left = 0;
		int right = grades.length - 1;
		System.out.println("GradesMinToMax......");
		quickSort(left, right, this.grades, this.nid);
		System.out.println("[學號]\t\t[成績]");
		System.out.println("--------+--------------");
		for(int i = 0; i < this.grades.length; i++) {
			System.out.println("[" + this.nid[i] + "]" + "\t|\t[" + this.grades[i] + "]");
		}
	}
	
    public void quickSort(int left, int right, float[] numberArray, String[] nid) {
        if(left > right)
        {
            return;
        }
        int startIndex = left; 
        int endIndex = right;   
        float baseValue = numberArray[left];
        String baseStr = nid[left];
        float temp;
        String tempStr;

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
