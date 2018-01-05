package Class;

public abstract class AbstractExamApp {
	AbstractExam t;

	 public AbstractExamApp() {}
		 

	 public void doSomethings(){
		 t = factoryMethod();
		 t.test();
	 }
	 
	 abstract AbstractExam factoryMethod();
}
