import java.util.Scanner;

public class K05_Tomorrow {
	public static void main(String[] args) {

		// =
		// 우항에 있는 것을 좌항에 넣어라
		// 변수(좌항)에 값(우항)을 넣을 때 사용
		// String name = "솔데스크";
		// A = B >> B를 A에 넣어라

		// 키보드 입력받을 준비
		Scanner k = new Scanner(System.in);
		// 키보드 입력받는 위치를 설정
		System.out.print("x : ");
		// 입력받은 값을 변수 x에 넣게 하는 과정
		double x = k.nextDouble();
		// 키보드 입력받는 위치를 설정
		System.out.print("y : ");
		// 입력받은 값을 변수 y에 넣게 하는 과정
		int y = k.nextInt();

		// x, y값 확인
		System.out.println("==============");
		System.out.printf("x는 %.0f, y는 %d\r\n", x, y);
		System.out.println("==============");

		// 이것도 가능하지만, 문제가 변수에 담아서 콘솔에 나오게 하기
//		System.out.printf("합 : %d", x + y); // 1회성일 때
		
		// 계산한 값을 변수에 따로 담기
		// 		변수에 담는 이유 : 변수에 한번 담아두면 계속 꺼내서 쓸 수 있음
		double hab = x + y;
		double cha = x - y;
		double gob = x * y;
		double na = x / y;
		// int / int = int (Java한정)
		// int / double = double
		// double / double = double
		System.out.println(hab);
		System.out.println(cha);
		System.out.println(gob);
		System.out.println(na);
		
		
		
		
		
	}
}









