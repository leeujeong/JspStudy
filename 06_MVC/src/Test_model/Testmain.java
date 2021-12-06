package Test_model;

public class Testmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestInterface obj = null;
		
		if(Math.random() < 0.5) {
			obj = new TestA();
		}else {
			obj = new TestB();
		}
		
		obj.doSome();
	}

}
