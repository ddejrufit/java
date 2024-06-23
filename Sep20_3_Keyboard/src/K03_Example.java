import java.util.Scanner;

public class K03_Example {
	public static void main(String[] args) {
		// 메뉴, 가격, 칼로리(실수), 평점(5점만점)
		Scanner keyboard = new Scanner(System.in);
		// console 창에 입력 받도록
		System.out.print("메뉴 : ");
		String menu = keyboard.next(); // console에서 입력받은 내용 담기
		System.out.print("가격 : ");
		int price = keyboard.nextInt();
		System.out.print("칼로리 : ");
		double kcal = keyboard.nextDouble();
		System.out.print("평점 : ");
		double score = keyboard.nextDouble();
		// printf로 출력
		System.out.println("********************");
		System.out.printf("메뉴 : %s\r\n", menu);
		System.out.printf("가격 : %d\r\n", price);
		System.out.printf("칼로리 : %.1f\r\n", kcal);
		System.out.printf("평점 : %.1f\r\n", score);
		System.out.println("********************");
	}
}









