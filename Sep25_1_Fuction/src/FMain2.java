import java.util.Scanner;

//함수 구조 정리
// public stgatic A B (C){
//		내용
//}

// B : 함수명, 해당하는 함수의 기능이 대충이라도 보이게 작명 (동사스럽게)
// C : parameter(파라미터, 재료), 함수를 호출 하는 쪽(main)에서
//								데이터를 보낼 때
// A : return type, 함수에서 작업한 결과물을 호출한 쪽으로 보낼 떄
//					그 결과의 자료형(없을 때: void)
public class FMain2 {
	//함수 재귀적(recursive) 호출 => 고급 기술
	//		:함수 속에서 자기 자신의 함수를 또 다시 호출
	
	// 3항연산자 + 재귀적호출
	//1. 정수 하나를 넣으면 해당하는 수까지 1부터 다 더한 값을 '구'하는 함수
	private static int add(int a) {
		
		return (a == 1) ? 1 : (a + add(a-1));
	}
	
	//2. factorial
	//   3!=> 3 * 2 * 1 =6
	public static int mul(int a) {
		
		return (a == 1)? 1:(a * mul(a-1));
	
}	
	
	//3. 피보나치 수열 구하는 방법
	//	1 1 2 3 5 8 13 21 34..
	public static int fibo(int a) {
		
		return (a < 3 ) ? 1 :(fibo(a-2) + fibo(a-1) );

		
	}
	public static void main(String[] args) {
		System.out.println(add(5));
		System.out.println(mul(5));
		System.out.println(fibo(8));
	}
}
