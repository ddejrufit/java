import java.util.Scanner;

public class K04_Example {
	public static void main(String[] args) {
		// escape 문자 포함해서 콘솔창에 명함처럼 만들기
		// 이름, 생일(년,월,일 따로), 나이, 키, 전화번호, 시력, 대면여부(true,false)
		// 콘솔에 입력받아서
		Scanner k = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = k.next();
		System.out.print("생일 년 : ");
		int year = k.nextInt();
		System.out.print("생일 월 : ");
		int month = k.nextInt();
		System.out.print("생일 일 : ");
		int day = k.nextInt();
		System.out.print("나이 : ");
		int age = k.nextInt();
		System.out.print("전화번호 : ");
		String phone = k.next();
		System.out.print("시력 : ");
		double eye = k.nextDouble();
		System.out.print("대면여부 : ");
		boolean soldesk = k.nextBoolean();
		System.out.println("*************************");
		System.out.printf("*이름\t: %s\t\t*\r\n", name);
		System.out.printf("*생년월일\t: %d년 %02d월 %02d일\t*\r\n", year, month, day);
		System.out.printf("*나이\t: %d살\t\t*\r\n", age);
		System.out.printf("*전화번호\t: %s\t\t*\r\n", phone);
		System.out.printf("*시력\t: %.1f\t\t*\r\n", eye);
		System.out.printf("*대면여부\t: %b\t\t*\r\n", soldesk);
		System.out.println("*************************");
	}
}




