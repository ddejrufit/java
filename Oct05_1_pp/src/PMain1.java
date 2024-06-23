
import java.util.Random;
import java.util.Scanner;

//함수
// 컴퓨터 vs 나 : 가위바위보

// 컴퓨터 가위 vs 나 바위
// 나 승!
// 나 패!
// 무승부!
public class PMain1 {
	public static int na() {

		Scanner k = new Scanner(System.in);
		System.out.print("가위 바위 보:");
		String r = k.next();
		int a = 0;

		switch (r) {
		case "가위":
			a = 1;
			break;
		case "바위":
			a = 2;
			break;
		case "보":
			a = 3;
			break;

		}
		return a;

	}

	public static int cpu() {
		Random r = new Random();
		int b = r.nextInt(3);
		switch (b) {
		case 0:
			System.out.println("cpu:가위");
			break;
		case 1:
			System.out.println("cpu:바위");
			break;
		case 2:
			System.out.println("cpu:보");
			break;
		}
		return b;
	}

	public static int judge(int a, int b) {
		int c = 0;
		if (a == 1) {
			if (b == 0) {
				System.out.println("무승부!");
			} else if (b == 1) {
				System.out.println("cpu 승!");
				c = 1;
			} else if (b == 2) {
				System.out.println("나 승!");
				c = 2;
			}
		} else if (a == 2) {
			if (b == 0) {
				System.out.println("나 승!");
				c = 2;
			} else if (b == 1) {
				System.out.println("무승부!");
			} else if (b == 2) {
				System.out.println("cpu 승!");
				c = 1;
			}
		} else if (a == 3) {
			if (b == 0) {
				System.out.println("cpu 승!");
				c = 1;
			} else if (b == 1) {
				System.out.println("나 승!");
				c = 2;
			} else if (b == 2) {
				System.out.println("무승부!");
			}

		}
		return c;
	}

	public static void main(String[] args) {
		int d = 0;
		while (true) {

			int a = na();

			int b = cpu();

			int c = judge(a, b);
			if (c == 2) {
				++d;
				System.out.printf("%d연승중입니다.", d);
			} else if (c == 1) {
				System.out.println("패배하셨습니다.");
				break;
			}
		}
	}
}
