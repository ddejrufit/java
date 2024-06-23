
public class AMain4 {
	public static void main(String[] args) {
		String[] ss = {"ㅋㅋ","ㅎㅎ","ㅇㅇ","^^"};
//		System.out.println(ss);
		
		
		String s = null;
		for (int i = 0; i < ss.length; i++) {
//			System.out.println(ss[i]);
			s = ss[i]; // for문이 한번 돌 때마다 s의 값이 바뀜
			System.out.println(s);
		}
		
		// for-each문 (신형 for문)
		//		배열의 요소 변경이 필요한 경우에는 사용할 수 X
		//		원본을 그대로 가져다 쓰는 것이 아니기 때문에 원본 적용은 안됨
		//		(복사해다 쓰는 느낌)
		//		순서 조절이 불가능
		//		i(인덱스)값이 없어서 활용도가 떨어짐
//		for (자료형 변수형 : 배열){
//			내용
//		 }
	for (String s1 : ss) {
		System.out.println(s1);
	}
	
	
	
	
	}
}
