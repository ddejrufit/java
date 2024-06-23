
// break : 반복문이 박살 > 반복문 밖의 코드로 이동
//		반복문이 여러개 중첩되어 있는 경우, break가 포함된 반복문만 종료!
// coutinue : 해당하는 턴 종료>> 반복문 시작 줄로 이동
// return : 함수 자체 종료 << 추후에

public class RMain5 {
	public static void main(String[] args) {
		for (int i = 1; i < 11; i++) {
			if (i % 2 == 0) {// i가 짝수있 때 ㅋ 출력
				System.out.println("ㅋ" + i);
			} else {// i가 홀수 일 때는 그냥 지나가게
				continue;// 반복문 시작점으로 이동 하기 때문에 조건 충족시 뒤쪽 출력 X
			}
			if (i == 6) {
				continue;
//				break;
			}
			System.out.println("점맛먹");
		}
		System.out.println("==================================");
		// 1부터 50까지 숫자 중에서 3의 배수만 출력 - continue 활용
		for (int i = 1; i <= 50; i++) {
			if (i % 3 != 0) {

				
				continue;
			}
			System.out.println(i);
		}
	}
}
