package Class;

public class Class extends AbstractClass{
	private String courseName;
	private float finalScore;
	private showFormat showFormat;
	
	public Class(String courseName, float finalScore, showFormat s) {
		this.courseName = courseName;
		this.finalScore = finalScore;
		this.showFormat = s;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public float getFinalScore() {
		return finalScore;
	}
	
	public void setFinalScore(float finalScore) {
		this.finalScore = finalScore;
//		setChanged();
		notifyObserverGetFinalScore("FinalScore had been changed"
				, new Float(finalScore));
	}
	
	public void listGradeReport() {
//		implement the showFormat
//		using the design pattern(strategy)
	}
	
}
