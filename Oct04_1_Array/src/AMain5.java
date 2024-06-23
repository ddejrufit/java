import java.util.Scanner;

//함수 X

// 물건 가격 : 입력받고 > 출력
// 낸 금액 : 입력받고 > 출력
// 거스름돈을 계산 > 출력
////////////////////
// 물건 가격: 5,680원
// 낸 금액 6,000원
// 거스름돈 320원
// 100원: 3개, 10원 2개
public class AMain5 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("상품의 가격은? :");
		int a = k.nextInt();// 물건 값
		System.out.print("지불할 금액은? :");
		int b = k.nextInt();// 지불한 금액
		if (a > b) {
			System.out.println("금액이 모자랍니다");
		} else {
			int c = b - a; // 거스름돈

			System.out.printf("물건 가격 :%,d원\n\r", a);
			System.out.printf("낸 금액 :%,d원\n\r", b);
			System.out.printf("거스름돈 :%,d원\n\r", c);
			int option = 100000;
			while (true) {
				option /= 2; // option = option /2 ;
				if (c >= option) {
					System.out.printf("%d원 짜리 %d개 \r\n", option, c / option);
					c %= option;
					System.out.println("나머지 : " + c);
				}
				option /= 5;
				if (c >= option) {
					System.out.printf("%d원 짜리 %d개 \r\n", option, c / option);
					c %= option;
					System.out.println("나머지 : " + c);
				}
				if (option == 10) {
					break;
				}

			}

		}

	}

}
