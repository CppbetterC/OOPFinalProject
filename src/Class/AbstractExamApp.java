package Class;

public abstract class AbstractExamApp {
	AbstractExam t;

	 public AbstractExamApp() {}
		 
//	 public void doSomethings(){
//		 t = getTypeOfTest();
//		 t.test();
//	 }
	 
	 abstract AbstractExam getTypeOfTest();
}
