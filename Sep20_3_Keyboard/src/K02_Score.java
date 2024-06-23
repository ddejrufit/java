import java.util.Scanner;

public class K02_Score {
	public static void main(String[] args) {
		// 국어, 수학, 영어 점수를 받는 scanner 만들어고 변수에 담아주세요
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int kor = keyboard.nextInt();
		
		System.out.print("수학 : ");
		int math = keyboard.nextInt();
		
		System.out.print("영어 : ");
		int eng = keyboard.nextInt();
//		double eng = keyboard.nextDouble(); // 100.0
		
		int chong = kor + math + eng;
//		double chong = kor + math + eng;
		System.out.println(chong);
		
		double avg = chong / 3.0;
		System.out.println(avg);
		// (java한정) int / int => int로만 나옴(나머지 버림)
		// int 세 개 중에 하나는 double로 바꾸어 주어야
		// int / double => double
		// double / int => double
		// double / double => double
		
	}
}
