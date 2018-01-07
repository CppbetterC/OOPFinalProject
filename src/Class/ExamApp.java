package Class;

public class ExamApp extends AbstractExamApp{
	 public ExamApp() {}

	 public AbstractExam createTest(String name){
		 return new Exam(name);
	 }
}
