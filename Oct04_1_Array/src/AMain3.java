// 면접 문제 : call by value, call by reference
//			값에 의한 호출,		참조에 의한 호출
// 값에 의한 호출 : main의 변수화 함수의 parameter는 서로 다른 복사된 변수
//				값만 전달하기 때문에 parameter를 수정해도 main에 영향 X
// 참조에 의한 호출 : 참조 자체를 전달하기 때문에 완전히 같은 변수
//				함수 안에서 파라미터 수정을 진행하면 원래 변수에도 반영
public class AMain3 {
	public static void test(int a, int[] b, int[] c) {
		System.out.println("함수 a :" + a);// 10
		System.out.println("함수 b :" + b);// 주소값
		System.out.println("함수 c :" + c);// 주소값
		System.out.println("=================");
		a = 100;
		System.out.println("함수 깂 변경 a:" + a);
		b[0] = 100; // b의 0번째를 10에서 100으로 변경
		System.out.println("함수 값 변경 b[0]: " + b[0]);
		c = new int[] {100,200};// 말그대로 새로운 작업(main과는 아예 별개)
		System.out.println("함수 값 변경 c[0] :"+c[0]);
	}

	public static void main(String[] args) {
		int a = 10;
		int[] b = { 10, 20 };
		int[] c = { 10, 20 };
		System.out.println("main a :" + a);// 10
		System.out.println("main b :" + b);// 주소값
		System.out.println("main c :" + c);// 주소값
		System.out.println("=================");
		test(a, b, c);
		System.out.println("=================");
		System.out.println("main 값 변경 a: " + a);//10
		System.out.println("main 값 변경 b[0] : " + b[0]);//100
		System.out.println("main 값 변경 c[0] : " + c[0]);//10
	}
}
