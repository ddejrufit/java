package com.chung.oct128.main;

import com.chung.oct128.avengers.Ironman;
import com.chung.oct128.human.Human;
import com.chung.oct128.planet.Planet;

public class OMain {
	public static void main(String[] args) {
		// 게임 개발 중
		// 행성 (이름,크기, 보이는지 안보이는지)
		// 사람 (이름)

		// 이름이 지구인 행성 생성(행성 이름)
		Planet p = new Planet("지구", 100, true);
		// 이름이 홍길동인 사람 생성
		Human h = new Human("홍길동");
		// 이 행성에 사람 입주
		p.add(h);
		
		// 사수 : interface
		// 부사수 : interface를 제어
		System.out.println("-----------------");
		Ironman i = new Ironman();
		h.pick(i);//이 사람이 아이언맨을 전담 영웅으로 pick
		h.helpAAAAAA();// 사람이 도와달라고 소리침
	}
}
