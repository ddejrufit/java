package src.com.kang.oop01;
//	com.별칭.패키지이름 << 전부 소문자, 콤마(.)가 두개

//	Java : perfect한 객체지향 언어
//	C++, Python : hybrid한 객체지향 언어

//	객체지향 프로그래밍
//		실생활을 묘사하자 -> 보기 쉬워질 것 -> 유지보수에 용이

//class는 실행용(main역할), 라이브러리용(실해용에서 가져다 쓸(이용할)목적)
//class 이름 짓는 법: 첫글자는 대문자로 , Camel notation(낙타체)방식을 사용
public class OMain1 {	//실행용 class
	public static void main(String[] args) {
		//t : 객체, instance
		Transportation t = new Transportation();
		t.type = "지하철";
		t.number = "경의중앙선";
		t.fee = 1450;
		t.seat = false;
		t.station = "신논현역";
		t.go();
		t.printInfo();
		///////////////////////////////
		//핸드폰 객체
		// 핸드폰 회사
		// 핸드폰 이름
		// 가격
		// 핸드폰 번호
		// phonecall : 띠리링
		// 모든 정보가 출력되게
		phone p = new phone();
		p.compeny = "samsung";
		p.machein = "S21";
		p.price = 120;
		p.phonenum = 99547876;
		p.phonecall();
		p.printphone();
	}
}
