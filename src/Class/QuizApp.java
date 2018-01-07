package Class;

public class QuizApp extends AbstractExamApp{
	 public QuizApp() {}

	 public AbstractExam createTest(String name){
		 return new Quiz(name);
	 }
}
