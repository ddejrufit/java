import java.util.Scanner;

// 어떤 숫자를 콘솔에 입력하면
// 그 숫자의 약수를 구해주는 프로그램
// 예) 12 >> 1, 2, 3, 4, 6, 12
// 배역 필요 X 오직 for문
//계속 숫자 입력하면 약수 계속 뽑아주도록 하되,(엔터 치기 전까지 무한루프)
//콘솔창에 엔터만 치면 반복문 숫자 입력 안나오게
public class PMain1 {
	public static void main(String[] args) {
		int a = 0;
		Scanner k = new Scanner(System.in);
		while (true) {
			System.out.print("약수 구할 정수 입력:");
			a = k.nextInt();
			System.out.printf("[%d]의 약수는 :", a);
			for (int i = 1; i <= a; i++) {

				if (a % i == 0) {
					System.out.printf(" %d ", i);
				}

			}
			System.out.println();
		}
	}
}
