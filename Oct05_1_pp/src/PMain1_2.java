import java.util.Random;
import java.util.Scanner;

public class PMain1_2 {
	public static void printRule(String[] h) {
		System.out.println("=======================");
		for (int i = 1; i < h.length; i++) {
			System.out.printf("%s\t : %d\r\n", h[i], i);
		}
		System.out.println("=======================");
	}

	public static int cpu() {
		return new Random().nextInt(3) + 1;

	}

	public static int pick() {
		Scanner k = new Scanner(System.in);
		System.out.print("뭐 낼래?>");
		int a = k.nextInt();
		return (a > 0 && a <= 3) ? a : pick();
	}

	public static int judge(int m, int c) {
		int a = m - c;
		if (a == 0) {
			System.out.println("무승부");
			return 0;
		} else if (a == -1 || a == 2) {
			System.out.println("패");
			return -98434864;
		} else {
			System.out.println("승리");
			return 1;
		}
	}

	public static void result(int m, int c, String[] h) {
		System.out.printf("나: %s\r\n", h[m]);
		System.out.printf("cpu: %s\r\n", h[c]);
	}

	public static void main(String[] args) {
		String[] hand = { " ", "가위", "바위", "보" };
		printRule(hand);
//		int com = cpu();
//		int me = pick();
//		result(me,com,hand);
//		judge(me,com);
		int com =0;
		int me =0;
		int result=0;
		int win =0;
		while (true) {
			com =cpu();
			me = pick();
			result(me,com,hand);
			result=judge(me,com);
			if(result ==-98434864 ) {
				System.out.printf("$d 연승",win);
			break;
			}
			win += result; //
		}
	}
}
