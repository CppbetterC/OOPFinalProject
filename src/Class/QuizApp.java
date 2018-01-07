package Class;

public class QuizApp extends AbstractExamApp{
	 public QuizApp() {}

	 public AbstractExam createTest(String name, Integer studentCount){
		 return new Quiz(name, studentCount);
	 }
}
