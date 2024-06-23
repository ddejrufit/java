package sep25_2_conditionalStmt;

import java.util.Scanner;

public class CMain2 {
	public static void main(String[] args) {
		// 콘솔 창에 정수 x값을 입력받도록
		Scanner k = new Scanner(System.in);
		System.out.print("x값을입력:");
		int x = k.nextInt();
		// x가 90 이상이면
		if (x >= 90) {
			System.out.println("[x는 90과 같거나 크다]");
			System.out.println("[A등급]");
		}
		// [x는 90과 같거나 크다]

		// [A등급입니다]
		// 그 외 나머지 (90미만)
		// [x는 90보다 작다]
		// [B등급입니다]
		else {
			System.out.println("[x는 90보다 작다]");
			System.out.println("B등급");
		}
		System.out.println("=====================");
		// x가 10미만이면 [y는 10] 콘솔에 찍히게 + 변수 y에 값을 담아서 y의 값이 콘솔에 나오게
		// x가 4미만이면 [y는 20] 콘솔에 찍히게+ 변수 y에 20
		if (x < 4) {
			int y = 20;// 자료형까지 같이 사용하면 변수 하나 새로 생성
			System.out.println(y);
		} else if (x < 10) {
			int y = 10; // 바로 위에 있는 int y= 20;과는 아무 상관 없는 변수
			System.out.println(y);
		}
		System.out.println("====================");
		// (자료형없이) 변수명만 적은 경우는 값 변경
		int y = 0;
		if (x < 4) {
			y = 20;// 0이 담겨있던 변수 y의 값을 20으로 변경
		} else if (x < 10) {
			y = 10;// 0이 담겨있던 변수 y의 값을 10으로 변경
		}
		System.out.println(y);// 바뀐 y의 값이 출력
	}

}
