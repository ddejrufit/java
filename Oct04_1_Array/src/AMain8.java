import java.util.Random;
import java.util.Scanner;

public class AMain8 {
	public static void main(String[] args) {
		// 무작위 숫자 계산하기!
		// 키보드 입력받아서 무작위로 내가 7개 숫자(정수)입략해서
		// 그 숫자들의 합과 곱을 syso로!
		Scanner k = new Scanner(System.in);
		int[] num= new int[7];
				int sum=0;
		int gob=1;
		for (int i = 0; i < num.length; i++) {
			System.out.printf("숫자입력 %d :",i+1);
			num[i] = k.nextInt();
			sum +=num[i];
			gob *= num[i];
		}
		System.out.println("합은 :"+sum);
		System.out.println("곱은 :"+gob);
	}

}
