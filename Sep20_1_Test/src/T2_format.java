
public class T2_format {
	public static void main(String[] args) {
//		System.out.printf("%?", 값);
		// %d : 정수 데이터가 올 자리(decimal, digit, 10진수)
		// %xd : x에 들어간 숫자 -1만큼 띄어쓰기로 채워져 출력
		// %0xd : x에 들어간 숫자 -1만큼 0으로 채워져 출력
		System.out.printf("%d", 105);
		System.out.println();
		System.out.printf("%6d", 1);
		System.out.println();
		System.out.printf("%03d", 1);
		System.out.println();
		// %f : 실수 데이터가 올 자리(float)
		// %.xf : 소수점 이하 자리수에서 반올림
		System.out.printf("%f", 1.23456);
		System.out.println();
		System.out.printf("%.3f", 1.23456);
		System.out.println();
		// 오늘은 09월이고, 내 시력은 1.34다
		System.out.printf("오늘은 %02d월이고, ", 9);
		System.out.printf("내 시력은 %.2f다", 1.34);
		System.out.println();
		System.out.printf("오늘은 %02d월이고, 내 시력은 %.2f다", 9, 1.34);
		System.out.println();
		
		// %s : 글자데이터가 들어가는 자리(String)
		//		숫자 : 큰따옴표 없이 그냥 써도 가능
		//		글자 : 큰따옴표 무조건 붙여줘야 가능
		//		그냥 사용하면 -> Java문법으로 해석 -> 오류가 난다
		System.out.printf("우리 학원 이름은 %s입니다", "솔데스크");
	}
}






