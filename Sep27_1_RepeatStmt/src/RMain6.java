import java.util.Iterator;
import java.util.Scanner;

//ATM기기
//	1. 예금 2. 출금 3. 잔액 4. 종료
//	1
//	예금할 금액 : 10000
//	1. 예금 2. 출금 3. 잔액 4. 종료
//	3
//	잔액은 10000원 입니다.
//	1. 예금 2. 출금 3. 잔액 4. 종료
//	2
//	출금 할 금액 : 5000
//	1. 예금 2. 출금 3. 잔액 4. 종료
//	4
//	종료합니다.

public class RMain6 {
	public static void main(String[] args) {
		int a = 0;// (a << 선택한 번호)
		int b = 0;// (b << 잔액)

		for (int i = 0; i <= 0;) {
			int c = 0;// (c << 입력한 금액)
			Scanner k = new Scanner(System.in);
			System.out.print("1. 예금 2. 출금 3. 잔액 4. 종료\r\n");
			a = k.nextInt();

			switch (a) {
			case 1:
				Scanner m = new Scanner(System.in);
				System.out.print("금액을 입력해주세요:");
				c = m.nextInt();
				if (c < 0) {
					System.out.println("양수로 입력해주십시오");
					break;
				} else {
					System.out.printf(c + "원이 입금되어 잔액은 %d원입니다.\r\n", c + b);
					b = +c;
					break;
				}

			case 2:
				Scanner l = new Scanner(System.in);
				System.out.print("금액을 입력해주세요:");
				c = l.nextInt();
				if (b >= c) {
					System.out.printf(c + "원이 출금 되었습니다.잔액은 %d원입니다.\r\n", b - c);
					b -= c;
					break;
				} else {
					System.out.printf("잔액이 부족하여 출금 하실수 없습니다. 현재 잔액은 %d원입니다\r\n", b);
					break;
				}

			case 3:
				System.out.printf("현재 잔액은 %d원입니다\r\n", b);
				break;
			case 4:
				System.out.println("ATM기 서비스를 종료합니다.");
				i++;
				break;
			}
		}
	}

}
