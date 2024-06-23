package sep25_2_conditionalStmt;

//import 정리 : ctrl + shift + o
import java.util.Random;

//조건문 : if문, switch문
//		switch문 : 비교 조건이 특정한 값이나 문자열인 경우
//			break;라는 걸 이용해서 각 조건이 만족되면 switch문이 깨지도록

// switch (변수 or 식){
//		case A :
//			대상 값이 A일떄 여기가 실행
//			break;
//		case B :
//			대상 값이 B일떄 여기가 실행
//			break;
//		case c :
//			대상 값이 C일떄 여기가 실행
//			break;
//		default :
//			값이 A도 B도 C도아닐 떄 여기가 실행
//			break;
//}

public class CMain3 {

	private static final int value = 0;

	public static void main(String[] args) {

//		Scanner k = new Scanner(System.in);

		// System.out.println("x:");
		// int x = k.nextInt();
		Random r = new Random();
		int x = r.nextInt(3) + 1;
		System.out.println(x);
		// x = 1:1입니다
		// x = 2:2일세
		// x = 3:33333333
		// x = 그 외: else 정도
		/*
		 * switch (x) { case 1: System.out.println("1입니다");
		 * 
		 * break; case 2: System.out.println("2일세");
		 * 
		 * break; case 3 : System.out.println("33333");
		 * 
		 * break;
		 * 
		 * default: System.out.println("여기는 else정도"); break; }
		 */

		// 랜덤으로 숫자 뽑기 -> 1~3까지만
		// 소수 : 1과 자기 자신만
		// 2,3 : 이 수는 소수
		// 1:소수가 아니죠

		switch (x) {

		case 2:

		case 3:
			System.out.println("이 수는 소수");

			break;

		default:
			System.out.println("소수가 아니죠");
			break;

		}
	}
}