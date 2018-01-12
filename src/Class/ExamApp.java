package Class;


public class ExamApp extends AbstractExamApp{
	 public ExamApp() {}

	 public AbstractExam createTest(String name, Integer studentCount){
		 return new Exam(name, studentCount);
	 }
}
