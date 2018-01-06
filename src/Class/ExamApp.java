package Class;

public class ExamApp extends AbstractExamApp{
	 public ExamApp() {}

	 public AbstractExam getTypeOfTest(){
		 return new Exam();
	 }
}
