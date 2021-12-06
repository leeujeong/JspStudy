package Test_model;


//TestInterface를 구현하는 클래스
//TestInterface(부모)
//TeseA(자식)
public class TestA  implements TestInterface{

	//반드시 모든 추상 메소드를 오버라이드 해야된다.
	@Override
	public void doSome() {
		// TODO Auto-generated method stub
		System.out.println("TestA");
	}
}
