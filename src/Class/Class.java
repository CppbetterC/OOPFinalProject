package Class;

public class Class extends AbstractClass{
	private String courseName;
	private float finalScore;
	
	public Class(String courseName, float finalScore) {
		super();
		this.courseName = courseName;
		this.finalScore = finalScore;
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
	
}
