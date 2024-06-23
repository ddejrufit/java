package com.kang.oct202.main;

import java.util.HashMap;
import java.util.Set;

// Map 계열 (python : dict / Pbhect-C : NSDictionary)
// 		가변사이즈
//		<Key,Value>
//		key값도 지정해줘야
//		순서개념 X
//		HashMap..
public class MapMain {
	public static void main(String[] args) {
	//key값을 넣으면 value값을 내보내줌
		HashMap<String, Integer> hm = new HashMap<String,Integer>();
		hm.put("아메리카노", 2500);	
		hm.put("카페라떼", 3000);	
		hm.put("녹차라떼", 3500);	
		hm.put("레몬에이드", 5500);	
		hm.put("녹차라떼", 7000);	//[녹차라떼]의 key값이 중복되면
								// 가장 마지막에 지정된 value 값으로 수정!
		
		//key값을 넣으면 value값을 출력!
		System.out.println(hm.get("녹차라떼"));//7000
		
		Set<String> k = hm.keySet();//key값만 출력
		for (String ss : k) {
			System.out.println(ss);
			System.out.println(hm.get(ss));
		}
}
}
