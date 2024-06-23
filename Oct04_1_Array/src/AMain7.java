import java.util.Random;

public class AMain7 {
	public static void main(String[] args) {
		// 숫자 1~100까지의 정수를 랜덤으로 10개 뽑는데
		// num 이라는 배열에 담기

		int[] num = new int[10];
		Random r = new Random();
		int a = 0;
		for (int i = 0; i < num.length; i++) {
			a = r.nextInt(100) + 1;
			num[i] = a;

		}
		for (int i : num) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < num.length; i++) {
			System.out.printf("%d) %d ", i + 1, num[i]);
		}
		System.out.println();
		System.out.println("===========================================");
		// 최소값,최대값 구하기
		int max = 0;
		int min = num[0];
		for (int i = 0; i < num.length; i++) {
			if (min > num[i]) {// min 에 있는 숫자보다 num[i]번째 숫자가 더 작다면
				min = num[i];// min그릇에 옮겨 담기

			} else if (max < num[i]) {// max에 있는 숫자보다 num[i]번째 숫자가 더 크다면
				max = num[i];
			}
		}
		System.out.println("최소값 : " + min);
		System.out.println("최대값 : " + max);
	}
}
