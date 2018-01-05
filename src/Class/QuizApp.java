package Class;

public class QuizApp extends AbstractExamApp{
	 public QuizApp() {}

	 public AbstractExam factoryMethod(){
		 return new Quiz();
	 }
}
