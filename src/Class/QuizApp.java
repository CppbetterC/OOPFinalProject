package Class;

public class QuizApp extends AbstractExamApp{
	 public QuizApp() {}

	 public AbstractExam getTypeOfTest(){
		 return new Quiz();
	 }
}
