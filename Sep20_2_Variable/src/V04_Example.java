
public class V04_Example {
	public static void main(String[] args) {
		// 자료형 선택을 잘 해서
		// 이름, 오늘 날짜(년월일), 사는곳(구,시), 시력, Java경험 유무(true, false)
		// 각각 변수에 담은 후에
		// printf 사용해서 각각 콘솔에 찍히게 표현
		String name = "jihee";
		int year = 2023;
		int month = 9;
		int day = 20;
		String place = "서울";
		double eye = 1.0;
		boolean experienced = false;
		
		System.out.printf("이름 : %s\r\n", name);
		System.out.printf("날짜 : %d년 %02d월 %d일\r\n", year, month, day);
		System.out.printf("사는 곳 : %s\r\n", place);
		System.out.printf("시력 : %.1f\r\n", eye);
		System.out.printf("java 경험 유무 : %b\r\n", experienced);
	}
}
