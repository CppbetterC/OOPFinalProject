package cs;

public class ExamApp extends AbstractExamApp{
	 public ExamApp() {}

	 public AbstractExam factoryMethod(){
		 return new Exam();
	 }
}
