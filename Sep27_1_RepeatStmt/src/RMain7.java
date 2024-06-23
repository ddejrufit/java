import java.util.Scanner;

public class RMain7 {

	public static void main(String[] args) {
		int a = 0;// (a << 선택한 번호)
		int b = 0;// (b << 잔액)
		int c = 0;// (c << 입력한 금액)
		while (true) {

			Scanner k = new Scanner(System.in);
			System.out.print("1. 예금 2. 출금 3. 잔액 4. 종료\r\n");
			a = k.nextInt();

			if (a == 1) {

				while (true) {

					System.out.print("금액을 입력해주세요:");
					c = k.nextInt();
					if (c > 0) {
						System.out.printf(c + "원이 입금되어 잔액은 %d원입니다.\r\n", c + b);
						b += c;
						break;
					} else {

						System.out.println("다시 입력해주십시오");
					}
				}
			} else if (a == 2) {
				while (true) {
					System.out.print("금액을 입력해주세요:");
					c = k.nextInt();
					if (c < 0) {
						System.out.println("다시 입력해주십시오");
					} else if (b >= c) {
						System.out.printf(c + "원이 출금 되었습니다.잔액은 %d원입니다.\r\n", b - c);
						b -= c;
						break;

					} else if (b < c) {
						System.out.printf("잔액이 부족하여 출금 하실수 없습니다. 현재 잔액은 %d원입니다\r\n", b);

					}

					else if (a == 3) {
						System.out.printf("현재 잔액은 %d원입니다\r\n", b);

					} else if (a == 4) {
						System.out.println("ATM기 서비스를 종료합니다.");

						break;
					}
				}
			}
		}
	}
}
